package com.example.planner.repository;

import com.example.planner.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<User, UUID> {

    User findByUserId(UUID userId);

    User findByName(String name);

    @Modifying
    @Query("update User set name = :newName where userId = :userId")
    int updateName(String newName, UUID userId);


}
