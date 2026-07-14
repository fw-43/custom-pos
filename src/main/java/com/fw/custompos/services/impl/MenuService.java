package com.fw.custompos.services.impl;

import com.fw.custompos.constants.PropertyConstants;
import com.fw.custompos.entities.Menu;
import com.fw.custompos.repositories.MenuRepository;
import com.fw.custompos.services.dto.MenuDropdownDTO;
import com.fw.custompos.utils.CurrencyStringFormatUtil;
import com.fw.custompos.utils.MapperUtil;
import com.fw.custompos.web.responses.MenuCreateResponse;
import com.fw.custompos.web.responses.MenuDeleteResponse;
import com.fw.custompos.web.responses.MenuListingResponse;
import com.fw.custompos.web.responses.MenuUpdateResponse;
import com.fw.custompos.web.responses.MenuUpdateViewResponse;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

@Service
public class MenuService {

  private final MapperUtil mapperUtil;
  private final CurrencyStringFormatUtil currencyStringFormatUtil;
  private final MenuRepository menuRepository;

  public MenuService(
      MapperUtil mapperUtil,
      CurrencyStringFormatUtil currencyStringFormatUtil,
      MenuRepository menuRepository) {
    this.mapperUtil = mapperUtil;
    this.currencyStringFormatUtil = currencyStringFormatUtil;
    this.menuRepository = menuRepository;
  }

  public List<MenuDropdownDTO> getMenuDropdowns() {
    return menuRepository.findAll().stream()
        .map(mapperUtil::mapMenuToMenuDropdownDTO)
        .sorted(Comparator.comparing(MenuDropdownDTO::getName, String.CASE_INSENSITIVE_ORDER))
        .collect(Collectors.toList());
  }

  public List<MenuListingResponse> getAllMenus() {
    List<MenuListingResponse> menuListingResponses =
        menuRepository.findAll().stream()
            .map(mapperUtil::mapMenuToMenuListingResponse)
            .sorted(
                Comparator.comparing(
                    MenuListingResponse::getMenuName, String.CASE_INSENSITIVE_ORDER))
            .collect(Collectors.toList());
    menuListingResponses.forEach(
        mlr -> mlr.setPriceString(currencyStringFormatUtil.format(mlr.getPrice())));
    /** convert time zone */
    menuListingResponses.forEach(
        m ->
            m.setDisplayedCreatedDate(
                m.getCreatedDate()
                    .plusHours(7)
                    .format(DateTimeFormatter.ofPattern(PropertyConstants.DATE_TIME_PATTERN))));
    menuListingResponses.forEach(
        m ->
            m.setDisplayedLastModifiedDate(
                m.getLastModifiedDate()
                    .plusHours(7)
                    .format(DateTimeFormatter.ofPattern(PropertyConstants.DATE_TIME_PATTERN))));
    /** */
    return menuListingResponses;
  }

  public MenuUpdateViewResponse getMenuByMenuId(UUID menuId) {
    Optional<Menu> optMenu = menuRepository.findById(menuId);
    if (!optMenu.isPresent()) {
      throw new IllegalArgumentException("Menu not found");
    }
    MenuUpdateViewResponse response = mapperUtil.mapMenuToMenuUpdateViewResponse(optMenu.get());
    return response;
  }

  public MenuCreateResponse createMenu(String name, Integer price) {
    Menu newMenu = new Menu();
    newMenu.setName(name);
    newMenu.setPrice(price);
    menuRepository.save(newMenu);
    MenuCreateResponse response = new MenuCreateResponse();
    response.setMessage("ADD MENU SUCCESS");
    return response;
  }

  public MenuUpdateResponse updateMenu(UUID id, String name, Integer price) {
    Optional<Menu> optMenu = menuRepository.findById(id);
    if (!optMenu.isPresent()) {
      throw new IllegalArgumentException("Menu not found");
    }
    Menu menu = optMenu.get();
    menu.setName(name);
    menu.setPrice(price);
    menuRepository.save(menu);
    MenuUpdateResponse response = new MenuUpdateResponse();
    response.setMessage("UPDATE MENU SUCCESS");
    return response;
  }

  public MenuDeleteResponse deleteMenu(UUID id) {
    Optional<Menu> optMenu = menuRepository.findById(id);
    if (!optMenu.isPresent()) {
      throw new IllegalArgumentException("Menu not found");
    }
    menuRepository.deleteById(id);
    MenuDeleteResponse response = new MenuDeleteResponse();
    response.setMessage("DELETE MENU SUCCESS");
    return response;
  }
}
