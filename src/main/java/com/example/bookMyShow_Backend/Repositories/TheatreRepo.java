package com.example.bookMyShow_Backend.Repositories;

import com.example.bookMyShow_Backend.Models.TheatreEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TheatreRepo extends JpaRepository<TheatreEntity,Integer> {
}
