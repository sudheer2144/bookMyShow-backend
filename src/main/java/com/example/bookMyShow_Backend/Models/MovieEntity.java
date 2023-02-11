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
public class MovieEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(unique = true,nullable = false)
    private String name;

    private int duration;
    private Date releaseDate;


    @OneToMany(mappedBy = "movie",cascade = CascadeType.ALL)
    private List<ShowEntity> movieShowsList=new ArrayList<>();

}
