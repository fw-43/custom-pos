package com.fw.custompos.repositories;

import com.fw.custompos.entities.Transaction;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction, UUID> {}
