package com.fawry.foodorderingapi.repository;

import com.fawry.foodorderingapi.entity.AppGroup;
import com.fawry.foodorderingapi.entity.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AppUserRepo extends JpaRepository<AppUser,Long> {

    Optional<AppUser> findByEmail(String email);

    @Query("select g from AppUser u " +
            "join u.OwnedGroups g where u.id=:userId" +
            " and g.id =:groupId")
    List<AppGroup> returnOwnedGroup(@Param("userId") Long userId, @Param("groupId") Long groupId);
}
