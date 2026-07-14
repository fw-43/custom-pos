package com.fw.custompos.web.requests;

import com.fw.custompos.services.dto.OrderDetailsDTO;
import java.util.List;

public class OrderDetailsCreateRequest {

  private String customerName;
  private List<OrderDetailsDTO> orderDetails;

  public String getCustomerName() {
    return customerName;
  }

  public void setCustomerName(String customerName) {
    this.customerName = customerName;
  }

  public List<OrderDetailsDTO> getOrderDetails() {
    return orderDetails;
  }

  public void setOrderDetails(List<OrderDetailsDTO> orderDetails) {
    this.orderDetails = orderDetails;
  }
}
