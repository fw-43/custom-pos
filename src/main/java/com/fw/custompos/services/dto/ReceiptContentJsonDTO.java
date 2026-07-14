package com.fw.custompos.services.dto;

import java.util.List;

public class ReceiptContentJsonDTO {

  private String cashierName;
  private String customerName;
  private String orderedDate;
  private String transactionDate;
  private List<ReceiptMenuJsonDTO> menuOrdered;
  private String totalPriceString;

  public String getCashierName() {
    return cashierName;
  }

  public void setCashierName(String cashierName) {
    this.cashierName = cashierName;
  }

  public String getCustomerName() {
    return customerName;
  }

  public void setCustomerName(String customerName) {
    this.customerName = customerName;
  }

  public String getOrderedDate() {
    return orderedDate;
  }

  public void setOrderedDate(String orderedDate) {
    this.orderedDate = orderedDate;
  }

  public String getTransactionDate() {
    return transactionDate;
  }

  public void setTransactionDate(String transactionDate) {
    this.transactionDate = transactionDate;
  }

  public List<ReceiptMenuJsonDTO> getMenuOrdered() {
    return menuOrdered;
  }

  public void setMenuOrdered(List<ReceiptMenuJsonDTO> menuOrdered) {
    this.menuOrdered = menuOrdered;
  }

  public String getTotalPriceString() {
    return totalPriceString;
  }

  public void setTotalPriceString(String totalPriceString) {
    this.totalPriceString = totalPriceString;
  }
}
