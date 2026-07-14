package com.fw.custompos.web.responses;

import java.util.UUID;

public class MenuUpdateViewResponse {

  private UUID id;
  private String name;
  private Integer price;

  public UUID getId() {
    return id;
  }

  public void setId(UUID id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Integer getPrice() {
    return price;
  }

  public void setPrice(Integer price) {
    this.price = price;
  }
}
