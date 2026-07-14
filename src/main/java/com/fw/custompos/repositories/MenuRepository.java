package com.fw.custompos.repositories;

import com.fw.custompos.entities.Menu;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MenuRepository extends JpaRepository<Menu, UUID> {}
