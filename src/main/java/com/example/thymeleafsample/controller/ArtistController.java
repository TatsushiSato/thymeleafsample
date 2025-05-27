package com.example.thymeleafsample.controller;

import com.example.thymeleafsample.entity.Artist;
import com.example.thymeleafsample.service.ArtistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class ArtistController {

    private final ArtistService artistService;

    @Autowired
    public ArtistController(ArtistService artistService) {
        this.artistService = artistService;
    }

    @GetMapping("/artists")
    public String findAll(Model model) {
        var artists = artistService.findAll();

        model.addAttribute("artists", artists);
        return "artists";
    }
}
