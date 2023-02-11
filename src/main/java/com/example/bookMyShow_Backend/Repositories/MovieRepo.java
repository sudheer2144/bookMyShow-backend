package com.example.bookMyShow_Backend.Repositories;

import com.example.bookMyShow_Backend.Models.MovieEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepo extends JpaRepository<MovieEntity,Integer> {
    MovieEntity findMovieByName(String name);
}
