package com.fw.custompos.web.responses;

import java.util.UUID;

public class OrderDetailsMenuOrderedResponse {

  private UUID orderMenuId;
  private String menuName;
  private String priceString;
  private Integer price;
  private Integer quantity;
  private String notes;

  public UUID getOrderMenuId() {
    return orderMenuId;
  }

  public void setOrderMenuId(UUID orderMenuId) {
    this.orderMenuId = orderMenuId;
  }

  public String getMenuName() {
    return menuName;
  }

  public void setMenuName(String menuName) {
    this.menuName = menuName;
  }

  public String getPriceString() {
    return priceString;
  }

  public void setPriceString(String priceString) {
    this.priceString = priceString;
  }

  public Integer getPrice() {
    return price;
  }

  public void setPrice(Integer price) {
    this.price = price;
  }

  public Integer getQuantity() {
    return quantity;
  }

  public void setQuantity(Integer quantity) {
    this.quantity = quantity;
  }

  public String getNotes() {
    return notes;
  }

  public void setNotes(String notes) {
    this.notes = notes;
  }
}
