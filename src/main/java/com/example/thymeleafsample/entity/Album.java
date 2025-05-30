package com.example.thymeleafsample.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Table(name="albums")
@Data
public class Album {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    private Integer artistId;

    private String albumTitle;

    private LocalDate releaseDate;
}
