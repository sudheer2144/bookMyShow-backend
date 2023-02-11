package com.example.bookMyShow_Backend.Models;


import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor

public class ShowEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private LocalDate ShowDate;

    private LocalTime ShowTime;

    private double multiplier;

    @CreationTimestamp
    private Date CreatedOn;

    @UpdateTimestamp
    private Date updatedOn;

    @ManyToOne
    @JoinColumn
    private MovieEntity movie;

    @ManyToOne
    @JoinColumn
    private TheatreEntity theatre;

    @OneToMany(mappedBy = "showEntity",cascade = CascadeType.ALL)
    private List<TicketEntity> listOfTickets=new ArrayList<>();

    @OneToMany(mappedBy = "show",cascade = CascadeType.ALL)
    private List<ShowSeatEntity> listOfSeats=new ArrayList<>();


}
