package com.fw.custompos.web.views;

import com.fw.custompos.constants.ApiViewContracts;
import com.fw.custompos.services.impl.MenuService;
import com.fw.custompos.services.impl.OrderService;
import com.fw.custompos.utils.PathResolverUtil;
import java.util.UUID;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(ApiViewContracts.ORDER_MENU)
public class OrderMenuViewController {

  private final PathResolverUtil pathResolverUtil;
  private final MenuService menuService;
  private final OrderService orderService;

  public OrderMenuViewController(
      PathResolverUtil pathResolverUtil, MenuService menuService, OrderService orderService) {
    this.pathResolverUtil = pathResolverUtil;
    this.menuService = menuService;
    this.orderService = orderService;
  }

  @GetMapping(ApiViewContracts.CREATE + "/{orderId}")
  public String create(Model model, @PathVariable String orderId) {
    model.addAttribute("orderId", orderId);
    model.addAttribute(
        "customerName", orderService.findCustomerNameByOrderId(UUID.fromString(orderId)));
    model.addAttribute("menus", menuService.getMenuDropdowns());
    return pathResolverUtil.resolve(ApiViewContracts.ORDER_MENU + ApiViewContracts.CREATE);
  }
}
