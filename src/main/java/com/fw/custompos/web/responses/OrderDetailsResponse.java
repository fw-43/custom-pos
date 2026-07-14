package com.fw.custompos.web.responses;

import java.util.List;

public class OrderDetailsResponse {

  private OrderDetailsInfoResponse info;
  private List<OrderDetailsMenuOrderedResponse> menuOrdered;
  private Integer totalPrice;
  private String totalPriceString;

  public OrderDetailsInfoResponse getInfo() {
    return info;
  }

  public void setInfo(OrderDetailsInfoResponse info) {
    this.info = info;
  }

  public List<OrderDetailsMenuOrderedResponse> getMenuOrdered() {
    return menuOrdered;
  }

  public void setMenuOrdered(List<OrderDetailsMenuOrderedResponse> menuOrdered) {
    this.menuOrdered = menuOrdered;
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
