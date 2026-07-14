package com.fw.custompos.entities;

import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Table(name = "order_menu")
@Entity
public class OrderMenu {

  @Id
  @Column(name = "id")
  @GeneratedValue
  private UUID id;

  @JoinColumn(name = "order_id")
  @ManyToOne
  private Order order;

  @JoinColumn(name = "menu_id")
  @ManyToOne
  private Menu menu;

  @Column(name = "quantity")
  @Min(value = 1)
  @NotNull
  private Integer quantity;

  @Column(name = "notes")
  private String notes;

  public UUID getId() {
    return id;
  }

  public void setId(UUID id) {
    this.id = id;
  }

  public Order getOrder() {
    return order;
  }

  public void setOrder(Order order) {
    this.order = order;
  }

  public Menu getMenu() {
    return menu;
  }

  public void setMenu(Menu menu) {
    this.menu = menu;
  }

  public @Min(value = 1) @NotNull Integer getQuantity() {
    return quantity;
  }

  public void setQuantity(@Min(value = 1) @NotNull Integer quantity) {
    this.quantity = quantity;
  }

  public String getNotes() {
    return notes;
  }

  public void setNotes(String notes) {
    this.notes = notes;
  }
}
