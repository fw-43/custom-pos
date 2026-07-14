package com.fw.custompos.web.responses;

import java.time.ZonedDateTime;
import java.util.UUID;

public class OrderListingResponse {

  private UUID orderId;
  private String customerName;
  private String displayedCreatedDate;
  private ZonedDateTime createdDate;

  public UUID getOrderId() {
    return orderId;
  }

  public void setOrderId(UUID orderId) {
    this.orderId = orderId;
  }

  public String getCustomerName() {
    return customerName;
  }

  public void setCustomerName(String customerName) {
    this.customerName = customerName;
  }

  public String getDisplayedCreatedDate() {
    return displayedCreatedDate;
  }

  public void setDisplayedCreatedDate(String displayedCreatedDate) {
    this.displayedCreatedDate = displayedCreatedDate;
  }

  public ZonedDateTime getCreatedDate() {
    return createdDate;
  }

  public void setCreatedDate(ZonedDateTime createdDate) {
    this.createdDate = createdDate;
  }
}
