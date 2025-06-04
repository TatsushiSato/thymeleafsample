package com.example.thymeleafsample.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name="songs")
@Data
public class Song {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long songId;

    private String albumId;

    private int trackNumber;

    private String songName;

    private int playTime;

}
