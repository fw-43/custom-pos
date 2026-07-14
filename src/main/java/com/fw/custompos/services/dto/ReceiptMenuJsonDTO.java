package com.fw.custompos.services.dto;

public class ReceiptMenuJsonDTO {

  private String menuName;
  private Integer price;
  private String priceString;
  private Integer quantity;
  private String notes;

  public String getMenuName() {
    return menuName;
  }

  public void setMenuName(String menuName) {
    this.menuName = menuName;
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
