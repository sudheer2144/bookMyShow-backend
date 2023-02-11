package com.example.bookMyShow_Backend.Controllers;

import com.example.bookMyShow_Backend.DTO.BookTicketRequestDTO;
import com.example.bookMyShow_Backend.Services.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ticket")
public class TicketController {

    @Autowired
    TicketService ticketService;

    @PostMapping("/book")
    public String bookTicket(@RequestBody BookTicketRequestDTO bookTicketRequestDTO) throws Exception{
        return ticketService.bookTickets(bookTicketRequestDTO);
    }
}
