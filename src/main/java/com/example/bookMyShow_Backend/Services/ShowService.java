package com.example.bookMyShow_Backend.Services;

import com.example.bookMyShow_Backend.DTO.ShowRequestDTO;
import com.example.bookMyShow_Backend.Models.*;
import com.example.bookMyShow_Backend.Repositories.MovieRepo;
import com.example.bookMyShow_Backend.Repositories.ShowRepo;
import com.example.bookMyShow_Backend.Repositories.ShowSeatRepo;
import com.example.bookMyShow_Backend.Repositories.TheatreRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ShowService {
    @Autowired
    MovieRepo movieRepo;
    @Autowired
    TheatreRepo theatreRepo;
    @Autowired
    ShowRepo showRepo;
    @Autowired
    ShowSeatRepo showSeatRepo;

    public String createShow(ShowRequestDTO showRequestDTO){

        MovieEntity movie=movieRepo.findMovieByName(showRequestDTO.getMovieName());
        TheatreEntity theatre=theatreRepo.findById(showRequestDTO.getTheatreId()).get();

        ShowEntity showEntity= ShowEntity.builder().ShowDate(showRequestDTO.getShowDate()).ShowTime(showRequestDTO.getShowTime()).multiplier(showRequestDTO.getMultiplier()).build();
        showEntity.setTheatre(theatre);
        showEntity.setMovie(movie);

        movie.getMovieShowsList().add(showEntity);
        theatre.getTheatreShowsList().add(showEntity);

        List<ShowSeatEntity> seatEntityList=createShowSeats(theatre.getTheatreSeatsList());

        for(ShowSeatEntity showSeat:seatEntityList){
            showSeat.setShow(showEntity);
        }

        movieRepo.save(movie);
        theatreRepo.save(theatre);
        //showRepo.save(showEntity);
        return "Show added Successfully";
    }

    private List<ShowSeatEntity> createShowSeats(List<TheatreSeatEntity> theatreSeatsList) {

        List<ShowSeatEntity> seats=new ArrayList<>();

        for(TheatreSeatEntity theatreSeat:theatreSeatsList){
            ShowSeatEntity showSeat=ShowSeatEntity.builder().seatType(theatreSeat.getSeatType()).seatNo(theatreSeat.getSeatNo()).available(true).build();
            seats.add(showSeat);
        }
        showSeatRepo.saveAll(seats);
        return seats;
    }
}
