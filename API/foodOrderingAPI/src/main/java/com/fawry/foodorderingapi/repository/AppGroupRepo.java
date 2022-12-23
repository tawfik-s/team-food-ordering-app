package com.fawry.foodorderingapi.repository;

import com.fawry.foodorderingapi.entity.AppGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppGroupRepo extends JpaRepository<AppGroup, Long> {

}
