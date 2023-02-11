package com.example.bookMyShow_Backend.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor

public class TheatreResponseDTO {
    private int id;
    private String name;
    private String city;
    private String address;
}
