package com.example.bookMyShow_Backend.Repositories;

import com.example.bookMyShow_Backend.Models.ShowSeatEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShowSeatRepo extends JpaRepository<ShowSeatEntity,Integer> {
}
