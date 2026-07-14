package com.fw.custompos.entities;

import java.time.ZonedDateTime;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Table(name = "transaction")
@Entity
public class Transaction {

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

  @Column(name = "customer_name")
  @NotNull
  @NotEmpty
  private String customerName;

  @Column(name = "total_price")
  @NotNull
  private Integer totalPrice;

  @Column(name = "receipt_content_json", length = 5000)
  @NotNull
  @NotEmpty
  private String receiptContentJson;

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

  public @NotNull @NotEmpty String getCustomerName() {
    return customerName;
  }

  public void setCustomerName(@NotNull @NotEmpty String customerName) {
    this.customerName = customerName;
  }

  public @NotNull Integer getTotalPrice() {
    return totalPrice;
  }

  public void setTotalPrice(@NotNull Integer totalPrice) {
    this.totalPrice = totalPrice;
  }

  public @NotNull @NotEmpty String getReceiptContentJson() {
    return receiptContentJson;
  }

  public void setReceiptContentJson(@NotNull @NotEmpty String receiptContentJson) {
    this.receiptContentJson = receiptContentJson;
  }
}
