package com.fw.custompos.web.responses;

import java.time.ZonedDateTime;
import java.util.UUID;

public class MenuListingResponse {

  private UUID menuId;
  private String menuName;
  private ZonedDateTime createdDate;
  private String displayedCreatedDate;
  private ZonedDateTime lastModifiedDate;
  private String displayedLastModifiedDate;
  private Integer price;
  private String priceString;

  public UUID getMenuId() {
    return menuId;
  }

  public void setMenuId(UUID menuId) {
    this.menuId = menuId;
  }

  public String getMenuName() {
    return menuName;
  }

  public void setMenuName(String menuName) {
    this.menuName = menuName;
  }

  public ZonedDateTime getCreatedDate() {
    return createdDate;
  }

  public void setCreatedDate(ZonedDateTime createdDate) {
    this.createdDate = createdDate;
  }

  public String getDisplayedCreatedDate() {
    return displayedCreatedDate;
  }

  public void setDisplayedCreatedDate(String displayedCreatedDate) {
    this.displayedCreatedDate = displayedCreatedDate;
  }

  public ZonedDateTime getLastModifiedDate() {
    return lastModifiedDate;
  }

  public void setLastModifiedDate(ZonedDateTime lastModifiedDate) {
    this.lastModifiedDate = lastModifiedDate;
  }

  public String getDisplayedLastModifiedDate() {
    return displayedLastModifiedDate;
  }

  public void setDisplayedLastModifiedDate(String displayedLastModifiedDate) {
    this.displayedLastModifiedDate = displayedLastModifiedDate;
  }

  public Integer getPrice() {
    return price;
  }

  public void setPrice(Integer price) {
    this.price = price;
  }

  public String getPriceString() {
    return priceString;
  }

  public void setPriceString(String priceString) {
    this.priceString = priceString;
  }
}
