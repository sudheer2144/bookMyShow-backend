package com.example.bookMyShow_Backend.Repositories;

import com.example.bookMyShow_Backend.Models.ShowEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShowRepo extends JpaRepository<ShowEntity,Integer> {
}
