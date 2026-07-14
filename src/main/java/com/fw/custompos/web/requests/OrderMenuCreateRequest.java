package com.fw.custompos.web.requests;

import java.util.UUID;

public class OrderMenuCreateRequest {

  private UUID orderId;
  private UUID menuId;
  private Integer quantity;
  private String notes;

  public UUID getOrderId() {
    return orderId;
  }

  public void setOrderId(UUID orderId) {
    this.orderId = orderId;
  }

  public UUID getMenuId() {
    return menuId;
  }

  public void setMenuId(UUID menuId) {
    this.menuId = menuId;
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
