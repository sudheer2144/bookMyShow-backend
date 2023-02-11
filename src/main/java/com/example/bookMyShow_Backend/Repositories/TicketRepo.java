package com.example.bookMyShow_Backend.Repositories;

import com.example.bookMyShow_Backend.Models.TicketEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketRepo extends JpaRepository<TicketEntity,Integer> {
}
