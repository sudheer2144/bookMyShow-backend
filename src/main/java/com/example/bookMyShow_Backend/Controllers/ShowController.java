package com.example.bookMyShow_Backend.Controllers;

import com.example.bookMyShow_Backend.DTO.ShowRequestDTO;
import com.example.bookMyShow_Backend.Services.ShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/show")
public class ShowController {

    @Autowired
    ShowService showService;

    @PostMapping("/create")
    public ResponseEntity createShow(@RequestBody ShowRequestDTO showRequestDTO){
        return new ResponseEntity<>(showService.createShow(showRequestDTO), HttpStatus.CREATED);
    }
}
