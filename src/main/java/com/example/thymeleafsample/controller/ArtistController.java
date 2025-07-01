package com.example.thymeleafsample.controller;

import com.example.thymeleafsample.entity.Artist;
import com.example.thymeleafsample.service.ArtistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.bind.BindResult;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

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
        return "/artist/artists";
    }

    @GetMapping("/artists/register")
    public String displayRegister(Model model){
        model.addAttribute("artist", new Artist());
        return "/artist/register";
    }
    @PostMapping("/artists")
    public String registerArtist(@ModelAttribute @Validated Artist artist, BindingResult result, @RequestParam("artist_cover") MultipartFile cover,Model model) {
        if(result.hasErrors()){
            return "/artist/register";
        }
        artistService.registerArtist(artist,cover);
        return "redirect:/artists";
    }

    @GetMapping("/artists/{id}")
    public String findById(Model model, @PathVariable int id) {
        var artist = artistService.findById(id).orElseGet(Artist::new);
        model.addAttribute("artist", artist);
        return "artist/artist";
    }

    @DeleteMapping("/artists/{id}")
    public String deleteById(Model model, @PathVariable int id){
        artistService.deleteById(id);
        return "redirect:/artists";
    }
}
