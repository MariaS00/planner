package com.example.planner.repository;

import com.example.planner.model.Category;
import com.example.planner.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<User, UUID> {

    List<User> findByUserId(UUID userId);

    List<User> findByName(String name);

   // List<User> findByTaskCategoryEquals(Category category);
}
