package com.fw.custompos.web.api;

import com.fw.custompos.constants.ApiViewContracts;
import com.fw.custompos.services.impl.OrderService;
import com.fw.custompos.web.requests.OrderCreateRequest;
import com.fw.custompos.web.requests.OrderDeleteRequest;
import com.fw.custompos.web.requests.OrderDetailsCreateRequest;
import com.fw.custompos.web.responses.OrderCreateResponse;
import com.fw.custompos.web.responses.OrderDeleteResponse;
import com.fw.custompos.web.responses.OrderDetailsCreateResponse;
import javax.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(ApiViewContracts.API + ApiViewContracts.ORDER)
public class OrderController {

  private final OrderService orderService;

  public OrderController(OrderService orderService) {
    this.orderService = orderService;
  }

  @PostMapping(ApiViewContracts.CREATE)
  public OrderCreateResponse create(@Valid @RequestBody OrderCreateRequest request) {
    return orderService.createNewOrder(request.getCustomerName());
  }

  @PostMapping(ApiViewContracts.CREATE_DETAILS)
  public OrderDetailsCreateResponse createDetails(
      @Valid @RequestBody OrderDetailsCreateRequest request) {
    return orderService.createNewOrderWithDetails(
        request.getCustomerName(), request.getOrderDetails());
  }

  @PostMapping(ApiViewContracts.DELETE)
  public OrderDeleteResponse delete(@RequestBody OrderDeleteRequest request) {
    return orderService.deleteOrderByOrderId(request.getOrderId());
  }
}
