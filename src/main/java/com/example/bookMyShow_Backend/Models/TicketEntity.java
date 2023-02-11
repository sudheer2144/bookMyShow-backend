package com.example.bookMyShow_Backend.Models;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class TicketEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String allocatedSeats;
    private int amount;
    private Date bookedAt;

    @ManyToOne
    @JoinColumn
    private UserEntity userEntity;

    @ManyToOne
    @JoinColumn
    private ShowEntity showEntity;

    @OneToMany(mappedBy = "ticketEntity",cascade = CascadeType.ALL)
    private List<ShowSeatEntity> bookedSeatsList=new ArrayList<>();


}
