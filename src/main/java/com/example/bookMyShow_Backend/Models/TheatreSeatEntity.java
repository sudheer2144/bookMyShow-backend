package com.example.bookMyShow_Backend.Models;

import com.example.bookMyShow_Backend.Enums.SeatType;
import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class TheatreSeatEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String seatNo;
    @Enumerated(value = EnumType.STRING)
    private SeatType seatType;
    private int rate;

    @ManyToOne
    @JoinColumn
    private TheatreEntity theatre;

    public TheatreSeatEntity(String seatNo, SeatType SeatType, int rate) {
        this.rate=rate;
        this.seatNo=seatNo;
        this.seatType=SeatType;

    }
}
