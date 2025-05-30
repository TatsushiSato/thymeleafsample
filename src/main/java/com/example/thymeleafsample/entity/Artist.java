package com.example.thymeleafsample.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "artists")
@Data
@NoArgsConstructor
public class Artist {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer artistId;

    private String artistName;

    private String artistHiraganaName;

    private String artistArtUrl;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="artistId")
    private List<Member> members;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "artistId")
    private List<Album> albums;
}


