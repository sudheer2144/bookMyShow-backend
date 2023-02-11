package com.example.bookMyShow_Backend.Services;

import com.example.bookMyShow_Backend.DTO.BookTicketRequestDTO;
import com.example.bookMyShow_Backend.Models.*;
import com.example.bookMyShow_Backend.Repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class TicketService {

    @Autowired
    MovieRepo movieRepo;
    @Autowired
    ShowRepo showRepo;
    @Autowired
    TicketRepo ticketRepo;
    @Autowired
    TheatreRepo theatreRepo;
    @Autowired
    UserRepo userRepo;
    public String bookTickets(BookTicketRequestDTO bookTicketRequestDTO) throws Exception{

        UserEntity userEntity=userRepo.findById(bookTicketRequestDTO.getUserId()).get();
        ShowEntity showEntity=showRepo.findById(bookTicketRequestDTO.getShowId()).get();

        List<String> ticketsRequested=bookTicketRequestDTO.getListOfTicketsRequested();

        List<ShowSeatEntity> listOfShowSeats=showEntity.getListOfSeats();

        List<ShowSeatEntity> bookedSeats=new ArrayList<>();

        for(ShowSeatEntity showSeat:listOfShowSeats){
            String seatNo=showSeat.getSeatNo();
            if(showSeat.isAvailable() && ticketsRequested.contains(seatNo)){
                bookedSeats.add(showSeat);
            }
        }

        if(bookedSeats.size()!=ticketsRequested.size()){
            throw new RuntimeException("Requested seats are not available");
        }


        TicketEntity ticketEntity=new TicketEntity();

        String allocatedSeats="";

        int totalAmount = 0;
        int rate=0;
        double multiplier=showEntity.getMultiplier();

        for(ShowSeatEntity bookedSeat:bookedSeats){
            bookedSeat.setBookedAt(new Date());
            bookedSeat.setTicketEntity(ticketEntity);
            bookedSeat.setShow(showEntity);
            bookedSeat.setAvailable(false);

            allocatedSeats=allocatedSeats+bookedSeat.getSeatNo()+",";

            if(bookedSeat.getSeatNo().charAt(0)=='1'){
                rate=100;
            }
            else{
                rate=200;
            }
            totalAmount+=multiplier*rate;
        }

        ticketEntity.setAmount(totalAmount);
        ticketEntity.setBookedAt(new Date());
        ticketEntity.setShowEntity(showEntity);
        ticketEntity.setUserEntity(userEntity);
        ticketEntity.setBookedSeatsList(bookedSeats);
        ticketEntity.setAllocatedSeats(allocatedSeats);

        ticketRepo.save(ticketEntity);

        return "Booked Successfully";
    }
}
