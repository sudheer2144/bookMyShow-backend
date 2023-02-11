package com.example.bookMyShow_Backend.Services;

import com.example.bookMyShow_Backend.DTO.UserRequestDTO;
import com.example.bookMyShow_Backend.DTO.UserResponseDTO;
import com.example.bookMyShow_Backend.Models.UserEntity;
import com.example.bookMyShow_Backend.Repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepo userRepo;

    public void createUser(UserRequestDTO userRequestDTO){
        UserEntity userEntity = UserEntity.builder().name(userRequestDTO.getName()).mobile(userRequestDTO.getMobile()).build();
        userRepo.save(userEntity);
    }

    public UserResponseDTO findUserByName(String name){
        UserEntity foundUserEntity = userRepo.findUserByName(name);
        UserResponseDTO requiredUser = UserResponseDTO.builder().name(foundUserEntity.getName()).createdDate(foundUserEntity.getCreatedOn()).mobile(foundUserEntity.getMobile()).id(foundUserEntity.getId()).build();
        return requiredUser;
    }

    public List<UserResponseDTO> findAllUsers(){
        List<UserEntity> userEntities = userRepo.findAll();
        List<UserResponseDTO> usersList = new ArrayList<>();
        for(UserEntity userEntity : userEntities){
            UserResponseDTO newUser = UserResponseDTO.builder().id(userEntity.getId()).name(userEntity.getName()).mobile(userEntity.getMobile()).createdDate(userEntity.getCreatedOn()).build();
            usersList.add(newUser);
        }
        return usersList;
    }
}
