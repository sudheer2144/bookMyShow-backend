package com.example.bookMyShow_Backend.Controllers;

import com.example.bookMyShow_Backend.DTO.MovieRequestDTO;
import com.example.bookMyShow_Backend.DTO.MovieResponseDTO;
import com.example.bookMyShow_Backend.Services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/movie")
public class MovieController {

    @Autowired
    MovieService movieService;

    @PostMapping("/create")
    public ResponseEntity createMovie(@RequestBody MovieRequestDTO movieRequestDTO){
        movieService.createMovie(movieRequestDTO);
        return new ResponseEntity<>("Successfully Created", HttpStatus.CREATED);
    }

    @GetMapping("/get-movie-by-name")
    public ResponseEntity<MovieResponseDTO> getMovie(@RequestParam String name){
        return new ResponseEntity<>(movieService.getMovie(name), HttpStatus.CREATED);
    }

}
