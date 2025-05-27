package com.example.thymeleafsample.repository;

import com.example.thymeleafsample.entity.Artist;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArtistRepository extends CrudRepository<Artist, Integer> {

    public List<Artist> findAll();
}
