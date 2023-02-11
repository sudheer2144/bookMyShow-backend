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
public class MovieResponseDTO {
    private int id;
    private String name;
    private int duration;
    private Date releaseDate;
}
