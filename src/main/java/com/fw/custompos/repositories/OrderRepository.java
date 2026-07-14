package com.fw.custompos.repositories;

import com.fw.custompos.entities.Order;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface OrderRepository extends JpaRepository<Order, UUID> {

  @Query("select o from Order o left join fetch o.orderMenu where o.id = ?1")
  Order findOrderDetailsById(UUID id);
}
