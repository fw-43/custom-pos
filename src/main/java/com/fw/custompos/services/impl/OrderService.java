package com.fw.custompos.services.impl;

import com.fw.custompos.constants.PropertyConstants;
import com.fw.custompos.entities.Menu;
import com.fw.custompos.entities.Order;
import com.fw.custompos.entities.OrderMenu;
import com.fw.custompos.repositories.OrderMenuRepository;
import com.fw.custompos.repositories.OrderRepository;
import com.fw.custompos.services.dto.OrderDetailsDTO;
import com.fw.custompos.utils.CurrencyStringFormatUtil;
import com.fw.custompos.utils.MapperUtil;
import com.fw.custompos.utils.PriceUtil;
import com.fw.custompos.web.responses.OrderCreateResponse;
import com.fw.custompos.web.responses.OrderDeleteResponse;
import com.fw.custompos.web.responses.OrderDetailsCreateResponse;
import com.fw.custompos.web.responses.OrderDetailsInfoResponse;
import com.fw.custompos.web.responses.OrderDetailsMenuOrderedResponse;
import com.fw.custompos.web.responses.OrderDetailsResponse;
import com.fw.custompos.web.responses.OrderListingResponse;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

  private final MapperUtil mapperUtil;
  private final CurrencyStringFormatUtil currencyStringFormatUtil;
  private final OrderRepository orderRepository;
  private final OrderMenuRepository orderMenuRepository;

  public OrderService(
      MapperUtil mapperUtil,
      CurrencyStringFormatUtil currencyStringFormatUtil,
      OrderRepository orderRepository,
      OrderMenuRepository orderMenuRepository) {
    this.mapperUtil = mapperUtil;
    this.currencyStringFormatUtil = currencyStringFormatUtil;
    this.orderRepository = orderRepository;
    this.orderMenuRepository = orderMenuRepository;
  }

  public List<OrderListingResponse> findAllOrders() {
    List<OrderListingResponse> response =
        orderRepository.findAll().stream()
            .map(mapperUtil::mapOrderToOrderListingResponse)
            .sorted(Comparator.comparing(OrderListingResponse::getCreatedDate))
            .collect(Collectors.toList());
    /** convert time zone */
    response.forEach(o -> o.setCreatedDate(o.getCreatedDate().plusHours(7)));
    response.forEach(
        o ->
            o.setDisplayedCreatedDate(
                o.getCreatedDate()
                    .format(DateTimeFormatter.ofPattern(PropertyConstants.DATE_TIME_PATTERN))));
    /** */
    return response;
  }

  public OrderDetailsResponse findOrderDetailsByOrderId(UUID orderId) {
    /**
     * this call below will return Order object with the populated Set of OrderMenu, with each
     * already has the populated Menu object
     */
    Order order = orderRepository.findOrderDetailsById(orderId);
    List<OrderDetailsMenuOrderedResponse> menuOrdered = new ArrayList<>();
    int totalPrice = 0;
    if (order.getOrderMenu() != null) {
      menuOrdered =
          order.getOrderMenu().stream()
              .map(mapperUtil::mapOrderMenuToOrderDetailsMenuOrderedResponse)
              .sorted(Comparator.comparing(OrderDetailsMenuOrderedResponse::getMenuName))
              .collect(Collectors.toList());
      menuOrdered.forEach(mo -> mo.setPriceString(currencyStringFormatUtil.format(mo.getPrice())));
      totalPrice = PriceUtil.calculateTotalPrice(menuOrdered);
    }
    OrderDetailsInfoResponse odir = mapperUtil.mapOrderToOrderDetailsInfoResponse(order);
    /** convert time zone */
    odir.setCreatedDate(
        order
            .getCreatedDate()
            .plusHours(7)
            .format(DateTimeFormatter.ofPattern(PropertyConstants.DATE_TIME_PATTERN)));
    /** */
    OrderDetailsResponse odr = new OrderDetailsResponse();
    odr.setInfo(odir);
    odr.setMenuOrdered(menuOrdered);
    odr.setTotalPrice(totalPrice);
    odr.setTotalPriceString(currencyStringFormatUtil.format(totalPrice));
    return odr;
  }

  public String findCustomerNameByOrderId(UUID orderId) {
    return orderRepository.findById(orderId).get().getCustomerName();
  }

  public OrderDetailsCreateResponse createNewOrderWithDetails(
      String customerName, List<OrderDetailsDTO> orderDetails) {
    Order newOrder = new Order();
    newOrder.setCustomerName(customerName);
    newOrder = orderRepository.save(newOrder);
    List<OrderMenu> orderMenus = new ArrayList<>();
    for (int i = 0; i < orderDetails.size(); i++) {
      OrderDetailsDTO orderDetailsDto = orderDetails.get(i);
      Order order = new Order(newOrder.getId());
      Menu menu = new Menu(UUID.fromString(orderDetailsDto.getMenuId()));
      OrderMenu orderMenu = new OrderMenu();
      orderMenu.setOrder(order);
      orderMenu.setMenu(menu);
      orderMenu.setQuantity(orderDetailsDto.getQuantity());
      orderMenu.setNotes(orderDetailsDto.getNotes());
      orderMenus.add(orderMenu);
    }
    orderMenuRepository.saveAllAndFlush(orderMenus);
    OrderDetailsCreateResponse response = new OrderDetailsCreateResponse();
    response.setMessage("CREATE NEW ORDER WITH DETAILS SUCCESS");
    return response;
  }

  public OrderCreateResponse createNewOrder(String customerName) {
    Order newOrder = new Order();
    newOrder.setCustomerName(customerName);
    orderRepository.save(newOrder);
    OrderCreateResponse response = new OrderCreateResponse();
    response.setMessage("CREATE NEW ORDER SUCCESS");
    return response;
  }

  public OrderDeleteResponse deleteOrderByOrderId(UUID orderId) {
    OrderDeleteResponse response = new OrderDeleteResponse();
    Order order = orderRepository.findOrderDetailsById(orderId);
    if (order.getOrderMenu().size() > 0) {
      throw new IllegalArgumentException("Cannot delete non-empty order");
    } else {
      response.setMessage("DELETE SUCCESS");
      orderRepository.delete(order);
    }
    return response;
  }
}
