package com.fawry.foodorderingapi.repository;

import com.fawry.foodorderingapi.entity.Order;

import com.fawry.foodorderingapi.model.ItemOrderSummaryDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepo extends JpaRepository<Order, Long> {
    List<Order>findByGroupId(Long groupId);

    @Query(name = "filterNative",nativeQuery = true)
    List<ItemOrderSummaryDto>filterNative(@Param("groupId") Long groupId);
}
