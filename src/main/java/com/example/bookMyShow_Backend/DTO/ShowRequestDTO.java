package com.example.bookMyShow_Backend.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@NoArgsConstructor
public class ShowRequestDTO {
    private String movieName;
    private LocalDate showDate;
    private LocalTime showTime;
    private int theatreId;
    private double multiplier;
}
