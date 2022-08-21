package com.Sanket.SpringbootTransaction.repository;

import com.Sanket.SpringbootTransaction.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
