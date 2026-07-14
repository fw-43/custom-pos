package com.fw.custompos.web.api;

import com.fw.custompos.constants.ApiViewContracts;
import com.fw.custompos.services.dto.MenuDropdownDTO;
import com.fw.custompos.services.impl.MenuService;
import com.fw.custompos.web.requests.MenuCreateRequest;
import com.fw.custompos.web.requests.MenuDeleteRequest;
import com.fw.custompos.web.requests.MenuUpdateRequest;
import com.fw.custompos.web.responses.MenuCreateResponse;
import com.fw.custompos.web.responses.MenuDeleteResponse;
import com.fw.custompos.web.responses.MenuUpdateResponse;
import java.util.List;
import java.util.UUID;
import javax.validation.Valid;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(ApiViewContracts.API + ApiViewContracts.MENU)
public class MenuController {

  private final MenuService menuService;

  public MenuController(MenuService menuService) {
    this.menuService = menuService;
  }

  @GetMapping(ApiViewContracts.DROPDOWN)
  public List<MenuDropdownDTO> dropdown() {
    return menuService.getMenuDropdowns();
  }

  @PostMapping(ApiViewContracts.CREATE)
  public MenuCreateResponse create(@Valid @RequestBody MenuCreateRequest request) {
    return menuService.createMenu(request.getName(), request.getPrice());
  }

  @PostMapping(ApiViewContracts.UPDATE)
  public MenuUpdateResponse update(@Valid @RequestBody MenuUpdateRequest request) {
    return menuService.updateMenu(
        UUID.fromString(request.getId()), request.getName(), request.getPrice());
  }

  @PostMapping(ApiViewContracts.DELETE)
  public MenuDeleteResponse delete(@RequestBody MenuDeleteRequest request) {
    return menuService.deleteMenu(UUID.fromString(request.getId()));
  }
}
