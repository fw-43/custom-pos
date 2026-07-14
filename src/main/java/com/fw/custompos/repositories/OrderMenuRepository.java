package com.fw.custompos.repositories;

import com.fw.custompos.entities.OrderMenu;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface OrderMenuRepository extends JpaRepository<OrderMenu, UUID> {

  @Query("delete from OrderMenu where order_id = ?1")
  @Modifying(clearAutomatically = true)
  @Transactional
  void deleteAllByOrderId(UUID orderId);
}
