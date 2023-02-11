package com.example.bookMyShow_Backend.Controllers;

import com.example.bookMyShow_Backend.DTO.UserRequestDTO;
import com.example.bookMyShow_Backend.DTO.UserResponseDTO;
import com.example.bookMyShow_Backend.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/createUser")
    public ResponseEntity createUser(@RequestBody UserRequestDTO userRequestDTO){
        userService.createUser(userRequestDTO);
        return new ResponseEntity<>("Successfully Created", HttpStatus.CREATED);
    }

    @GetMapping("/find-user-by-name")
    public ResponseEntity<UserResponseDTO> createUser(@RequestParam String name){
        return new ResponseEntity<>(userService.findUserByName(name), HttpStatus.CREATED);
    }

    @GetMapping("/find-all-users")
    public ResponseEntity<List<UserResponseDTO>> findAllUsers(){
        return new ResponseEntity<>(userService.findAllUsers(), HttpStatus.CREATED);
    }

}
