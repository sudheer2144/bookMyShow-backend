package com.example.bookMyShow_Backend.Services;


import com.example.bookMyShow_Backend.DTO.MovieRequestDTO;
import com.example.bookMyShow_Backend.DTO.MovieResponseDTO;
import com.example.bookMyShow_Backend.Models.MovieEntity;
import com.example.bookMyShow_Backend.Repositories.MovieRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieService {
    @Autowired
    MovieRepo movieRepo;

    public void createMovie(MovieRequestDTO movieRequestDTO){
        MovieEntity movieEntity = MovieEntity.builder().name(movieRequestDTO.getName()).duration(movieRequestDTO.getDuration()).releaseDate(movieRequestDTO.getReleaseDate()).build();
        movieRepo.save(movieEntity);
    }

    public MovieResponseDTO getMovie(String name) {
        MovieEntity foundMovieEntity = movieRepo.findMovieByName(name);
        MovieResponseDTO requiredMovie = MovieResponseDTO.builder().id(foundMovieEntity.getId()).name(foundMovieEntity.getName()).duration(foundMovieEntity.getDuration()).releaseDate(foundMovieEntity.getReleaseDate()).build();
        return requiredMovie;
    }
}
