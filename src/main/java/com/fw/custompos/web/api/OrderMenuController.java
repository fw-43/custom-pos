package com.fw.custompos.web.api;

import com.fw.custompos.constants.ApiViewContracts;
import com.fw.custompos.services.impl.OrderMenuService;
import com.fw.custompos.web.requests.OrderMenuCreateRequest;
import com.fw.custompos.web.requests.OrderMenuDeleteRequest;
import com.fw.custompos.web.responses.OrderMenuCreateResponse;
import com.fw.custompos.web.responses.OrderMenuDeleteResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(ApiViewContracts.API + ApiViewContracts.ORDER_MENU)
public class OrderMenuController {

  private final OrderMenuService orderMenuService;

  public OrderMenuController(OrderMenuService orderMenuService) {
    this.orderMenuService = orderMenuService;
  }

  @PostMapping(ApiViewContracts.CREATE)
  public OrderMenuCreateResponse create(@RequestBody OrderMenuCreateRequest request) {
    return orderMenuService.createOrderMenu(
        request.getOrderId(), request.getMenuId(), request.getQuantity(), request.getNotes());
  }

  @PostMapping(ApiViewContracts.DELETE)
  public OrderMenuDeleteResponse delete(@RequestBody OrderMenuDeleteRequest request) {
    return orderMenuService.deleteOrderMenuByOrderMenuId(request.getId());
  }
}
