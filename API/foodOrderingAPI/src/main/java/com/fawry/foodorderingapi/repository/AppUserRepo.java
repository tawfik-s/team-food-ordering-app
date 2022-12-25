package com.fawry.foodorderingapi.repository;

import com.fawry.foodorderingapi.entity.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AppUserRepo extends JpaRepository<AppUser,Long> {

    Optional<AppUser> findByEmail(String email);
}
