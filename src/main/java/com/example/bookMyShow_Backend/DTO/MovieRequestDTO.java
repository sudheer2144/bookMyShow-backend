package com.example.bookMyShow_Backend.DTO;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
public class MovieRequestDTO {

    private String name;
    private int duration;
    private Date releaseDate;
}
