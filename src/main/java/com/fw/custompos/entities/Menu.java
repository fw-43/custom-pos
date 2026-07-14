package com.fw.custompos.entities;

import java.time.ZonedDateTime;
import java.util.Set;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Table(name = "menu")
@Entity
public class Menu {

  @Id
  @Column(name = "id")
  @GeneratedValue
  private UUID id;

  @Column(name = "created_date")
  @CreationTimestamp
  private ZonedDateTime createdDate;

  @Column(name = "last_modified_date")
  @UpdateTimestamp
  private ZonedDateTime lastModifiedDate;

  @Column(name = "name")
  @NotNull
  @NotEmpty
  private String name;

  @Column(name = "price")
  @NotNull
  private Integer price;

  @OneToMany(mappedBy = "menu", fetch = FetchType.LAZY)
  private Set<OrderMenu> orderMenu;

  public Menu() {}

  public Menu(UUID id) {
    this.id = id;
  }

  public UUID getId() {
    return id;
  }

  public void setId(UUID id) {
    this.id = id;
  }

  public ZonedDateTime getCreatedDate() {
    return createdDate;
  }

  public void setCreatedDate(ZonedDateTime createdDate) {
    this.createdDate = createdDate;
  }

  public ZonedDateTime getLastModifiedDate() {
    return lastModifiedDate;
  }

  public void setLastModifiedDate(ZonedDateTime lastModifiedDate) {
    this.lastModifiedDate = lastModifiedDate;
  }

  public @NotNull @NotEmpty String getName() {
    return name;
  }

  public void setName(@NotNull @NotEmpty String name) {
    this.name = name;
  }

  public @NotNull Integer getPrice() {
    return price;
  }

  public void setPrice(@NotNull Integer price) {
    this.price = price;
  }

  public Set<OrderMenu> getOrderMenu() {
    return orderMenu;
  }

  public void setOrderMenu(Set<OrderMenu> orderMenu) {
    this.orderMenu = orderMenu;
  }
}
