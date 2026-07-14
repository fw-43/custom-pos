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
@RequestMapping(ApiViewContracts.ORDER)
public class OrderViewController {

  private final PathResolverUtil pathResolverUtil;
  private final OrderService orderService;
  private final MenuService menuService;

  public OrderViewController(
      PathResolverUtil pathResolverUtil, OrderService orderService, MenuService menuService) {
    this.pathResolverUtil = pathResolverUtil;
    this.orderService = orderService;
    this.menuService = menuService;
  }

  @GetMapping(ApiViewContracts.LIST)
  public String list(Model model) {
    model.addAttribute("orders", orderService.findAllOrders());
    model.addAttribute("menus", menuService.getMenuDropdowns());
    return pathResolverUtil.resolve(ApiViewContracts.ORDER + ApiViewContracts.LIST);
  }

  @GetMapping(ApiViewContracts.DETAILS + "/{id}")
  public String details(Model model, @PathVariable String id) {
    model.addAttribute("odr", orderService.findOrderDetailsByOrderId(UUID.fromString(id)));
    return pathResolverUtil.resolve(ApiViewContracts.ORDER + ApiViewContracts.DETAILS);
  }

  @GetMapping(ApiViewContracts.CREATE)
  public String create() {
    return pathResolverUtil.resolve(ApiViewContracts.ORDER + ApiViewContracts.CREATE);
  }
}
