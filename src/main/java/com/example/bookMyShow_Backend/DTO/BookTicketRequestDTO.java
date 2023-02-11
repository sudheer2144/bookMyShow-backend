package com.example.bookMyShow_Backend.DTO;

import lombok.Data;

import java.util.List;

@Data
public class BookTicketRequestDTO {
    private int userId;
    private int showId;
    private List<String> listOfTicketsRequested;
}
