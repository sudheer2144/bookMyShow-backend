package com.example.bookMyShow_Backend.Repositories;

import com.example.bookMyShow_Backend.Models.TheatreSeatEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TheatreSeatRepo extends JpaRepository<TheatreSeatEntity,Integer> {
}
