package com.fw.custompos.services.dto;

import java.time.ZonedDateTime;
import java.util.UUID;

public class TransactionListingDTO {

  private UUID transactionId;
  private String customerName;
  private String displayedTransactionDate;
  private ZonedDateTime transactionDate;
  private Integer totalPrice;
  private String totalPriceString;

  public UUID getTransactionId() {
    return transactionId;
  }

  public void setTransactionId(UUID transactionId) {
    this.transactionId = transactionId;
  }

  public String getCustomerName() {
    return customerName;
  }

  public void setCustomerName(String customerName) {
    this.customerName = customerName;
  }

  public String getDisplayedTransactionDate() {
    return displayedTransactionDate;
  }

  public void setDisplayedTransactionDate(String displayedTransactionDate) {
    this.displayedTransactionDate = displayedTransactionDate;
  }

  public ZonedDateTime getTransactionDate() {
    return transactionDate;
  }

  public void setTransactionDate(ZonedDateTime transactionDate) {
    this.transactionDate = transactionDate;
  }

  public Integer getTotalPrice() {
    return totalPrice;
  }

  public void setTotalPrice(Integer totalPrice) {
    this.totalPrice = totalPrice;
  }

  public String getTotalPriceString() {
    return totalPriceString;
  }

  public void setTotalPriceString(String totalPriceString) {
    this.totalPriceString = totalPriceString;
  }
}
