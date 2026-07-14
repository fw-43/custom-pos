package com.fw.custompos.web.views;

import com.fw.custompos.constants.ApiViewContracts;
import com.fw.custompos.services.impl.MenuService;
import com.fw.custompos.utils.PathResolverUtil;
import java.util.UUID;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(ApiViewContracts.MENU)
public class MenuViewController {

  private final PathResolverUtil pathResolverUtil;
  private final MenuService menuService;

  public MenuViewController(PathResolverUtil pathResolverUtil, MenuService menuService) {
    this.pathResolverUtil = pathResolverUtil;
    this.menuService = menuService;
  }

  @GetMapping(ApiViewContracts.LIST)
  public String list(Model model) {
    model.addAttribute("menus", menuService.getAllMenus());
    return pathResolverUtil.resolve(ApiViewContracts.MENU + ApiViewContracts.LIST);
  }

  @GetMapping(ApiViewContracts.CREATE)
  public String create() {
    return pathResolverUtil.resolve(ApiViewContracts.MENU + ApiViewContracts.CREATE);
  }

  @GetMapping(ApiViewContracts.UPDATE + "/{menuId}")
  public String update(Model model, @PathVariable String menuId) {
    model.addAttribute("menu", menuService.getMenuByMenuId(UUID.fromString(menuId)));
    return pathResolverUtil.resolve(ApiViewContracts.MENU + ApiViewContracts.UPDATE);
  }
}
