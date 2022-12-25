package com.fawry.foodorderingapi.repository;

import com.fawry.foodorderingapi.entity.Order;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubOrderRepo extends JpaRepository<Order, Long> {
}
