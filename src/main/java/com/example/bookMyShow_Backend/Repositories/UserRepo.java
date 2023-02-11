package com.example.bookMyShow_Backend.Repositories;

import com.example.bookMyShow_Backend.Models.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<UserEntity, Integer> {
    UserEntity findUserByName(String name);
}
