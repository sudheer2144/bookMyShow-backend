package com.example.bookMyShow_Backend.Services;

import com.example.bookMyShow_Backend.DTO.TheatreRequestDTO;
import com.example.bookMyShow_Backend.DTO.TheatreResponseDTO;
import com.example.bookMyShow_Backend.Enums.SeatType;
import com.example.bookMyShow_Backend.Models.TheatreEntity;
import com.example.bookMyShow_Backend.Models.TheatreSeatEntity;
import com.example.bookMyShow_Backend.Repositories.TheatreRepo;
import com.example.bookMyShow_Backend.Repositories.TheatreSeatRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TheatreService {

    @Autowired
    TheatreSeatRepo theatreSeatRepo;

    @Autowired
    TheatreRepo theatreRepo;


    public void createTheatre(TheatreRequestDTO theatreRequestDTO){

        TheatreEntity theatre=TheatreEntity.builder().name(theatreRequestDTO.getName()).city(theatreRequestDTO.getCity()).address(theatreRequestDTO.getAddress()).build();

        List<TheatreSeatEntity> theatreSeats = createSeatList();

        for(TheatreSeatEntity theatreSeat:theatreSeats){
            theatreSeat.setTheatre(theatre);
        }

        theatre.setTheatreSeatsList(theatreSeats);

        theatreRepo.save(theatre);
    }

    public List<TheatreSeatEntity> createSeatList(){

        List<TheatreSeatEntity> theatreSeats = new ArrayList<>();

        char c='A';
        for(int i=1;i<=10;i++){
            TheatreSeatEntity theatreSeatEntity;
            if(i<=5){
                String seat = "1"+c;
                theatreSeatEntity=new TheatreSeatEntity(seat,SeatType.CLASSIC,100);
                if(i==5){
                    c='A'-1;
                }
            }
            else{
                String seat="2"+c;
                theatreSeatEntity=new TheatreSeatEntity(seat,SeatType.PREMIUM,200);
            }
            theatreSeats.add(theatreSeatEntity);
            c+=1;
        }

        theatreSeatRepo.saveAll(theatreSeats);
        return theatreSeats;
    }

    public TheatreResponseDTO getTheatre(int id){
        TheatreEntity theatreFound=theatreRepo.findById(id).get();
        TheatreResponseDTO theatreResponseDTO=TheatreResponseDTO.builder().id(theatreFound.getId()).name(theatreFound.getName()).city(theatreFound.getCity()).address(theatreFound.getAddress()).build();
        return theatreResponseDTO;
    }

}