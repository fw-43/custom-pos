package com.fw.custompos.services.impl;

import com.fw.custompos.entities.Menu;
import com.fw.custompos.entities.Order;
import com.fw.custompos.entities.OrderMenu;
import com.fw.custompos.repositories.OrderMenuRepository;
import com.fw.custompos.web.responses.OrderMenuCreateResponse;
import com.fw.custompos.web.responses.OrderMenuDeleteResponse;
import java.util.UUID;
import org.springframework.stereotype.Service;

@Service
public class OrderMenuService {

  private final OrderMenuRepository orderMenuRepository;

  public OrderMenuService(OrderMenuRepository orderMenuRepository) {
    this.orderMenuRepository = orderMenuRepository;
  }

  public OrderMenuCreateResponse createOrderMenu(
      UUID orderId, UUID menuId, Integer quantity, String notes) {
    Order order = new Order(orderId);
    Menu menu = new Menu(menuId);
    OrderMenu newOrderMenu = new OrderMenu();
    newOrderMenu.setOrder(order);
    newOrderMenu.setMenu(menu);
    newOrderMenu.setQuantity(quantity);
    newOrderMenu.setNotes(notes);
    orderMenuRepository.save(newOrderMenu);
    OrderMenuCreateResponse response = new OrderMenuCreateResponse();
    response.setMessage("CREATE SUCCESS");
    return response;
  }

  public OrderMenuDeleteResponse deleteOrderMenuByOrderMenuId(String id) {
    UUID uuid = UUID.fromString(id);
    orderMenuRepository.deleteById(uuid);
    OrderMenuDeleteResponse response = new OrderMenuDeleteResponse();
    response.setMessage("DELETE SUCCESS");
    return response;
  }

  public OrderMenuDeleteResponse deleteOrderMenusByOrderId(UUID orderId) {
    orderMenuRepository.deleteAllByOrderId(orderId);
    OrderMenuDeleteResponse response = new OrderMenuDeleteResponse();
    response.setMessage("DELETE BY ORDER ID SUCCESS");
    return response;
  }
}
