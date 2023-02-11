package com.example.bookMyShow_Backend.Models;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class TheatreEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String city;
    private String address;

    @OneToMany(mappedBy = "theatre",cascade = CascadeType.ALL)
    private List<TheatreSeatEntity> theatreSeatsList=new ArrayList<>();

    @OneToMany(mappedBy = "theatre",cascade = CascadeType.ALL)
    private List<ShowEntity> theatreShowsList=new ArrayList<>();


}
