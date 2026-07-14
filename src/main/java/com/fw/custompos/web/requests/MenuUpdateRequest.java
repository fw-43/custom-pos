package com.fw.custompos.web.requests;

import javax.validation.constraints.NotNull;

public class MenuUpdateRequest {

  @NotNull private String id;
  @NotNull private String name;
  @NotNull private Integer price;

  public @NotNull String getId() {
    return id;
  }

  public void setId(@NotNull String id) {
    this.id = id;
  }

  public @NotNull String getName() {
    return name;
  }

  public void setName(@NotNull String name) {
    this.name = name;
  }

  public @NotNull Integer getPrice() {
    return price;
  }

  public void setPrice(@NotNull Integer price) {
    this.price = price;
  }
}
