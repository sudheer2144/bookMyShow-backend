package com.example.bookMyShow_Backend.Controllers;

import com.example.bookMyShow_Backend.DTO.TheatreRequestDTO;
import com.example.bookMyShow_Backend.DTO.TheatreResponseDTO;
import com.example.bookMyShow_Backend.Services.TheatreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigurationPackage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/theatre")
public class TheatreController {

    @Autowired
    TheatreService theatreService;

    @PostMapping("/create")
    public ResponseEntity createTheatre(@RequestBody TheatreRequestDTO theatreRequestDTO){
        theatreService.createTheatre(theatreRequestDTO);
        return new ResponseEntity<>("Success", HttpStatus.CREATED);
    }

    @GetMapping("/getTheatre")
    public ResponseEntity<TheatreResponseDTO> getTheatre(@RequestParam int id){
        TheatreResponseDTO theatre = theatreService.getTheatre(id);
        return new ResponseEntity<>(theatre,HttpStatus.CREATED);
    }
}
