package com.fawry.foodorderingapi.repository;

import com.fawry.foodorderingapi.entity.SubOrderItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubOrderItemRepo extends JpaRepository<SubOrderItem,Long> {
}
