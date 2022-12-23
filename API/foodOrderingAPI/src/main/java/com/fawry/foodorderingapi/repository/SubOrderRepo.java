package com.fawry.foodorderingapi.repository;

import com.fawry.foodorderingapi.entity.SubOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubOrderRepo extends JpaRepository<SubOrder,Long> {
}