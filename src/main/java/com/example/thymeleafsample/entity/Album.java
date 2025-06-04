package com.example.thymeleafsample.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name="albums")
@Data
public class Album {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long albumId;

    private Integer artistId;

    private String albumTitle;

    private LocalDate releaseDate;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="albumId")
    private List<Song> songs;
}
