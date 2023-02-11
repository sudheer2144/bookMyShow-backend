package com.example.bookMyShow_Backend.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class UserResponseDTO {
    private int id;
    private String name;
    private String mobile;
    private Date createdDate;
}
