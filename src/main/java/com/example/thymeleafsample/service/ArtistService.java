package com.example.thymeleafsample.service;

import com.example.thymeleafsample.entity.Artist;
import com.example.thymeleafsample.repository.ArtistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;

@Service
public class ArtistService {

    private final ArtistRepository artistRepository;

    private final StorageService localStorageService;

    @Autowired
    public ArtistService(ArtistRepository artistRepository, LocalStorageService localStorageService) {
        this.artistRepository = artistRepository;
        this.localStorageService = localStorageService;
    }

    /**
     * 全件検索
     * @return テーブル内にある全レコード
     */
    public List<Artist> findAll() {
        return artistRepository.findAll();
    }

    /**
     * ID指定の検索処理
     * @param id 検索条件のID
     * @return 検索条件に一致したレコード
     */
    public Optional<Artist> findById(int id) {
        return artistRepository.findById(id);
    }

    /**
     * ID指定の削除処理
     * @param id 削除条件のID
     */
    public void deleteById(int id){
        artistRepository.deleteById(id);
    }

    /**
     * 新規登録処理
     * @param artist 登録レコード情報
     */
    public void registerArtist(Artist artist, MultipartFile cover) {
        //Files.write(Paths.get("static/images/" + cover.getOriginalFilename()),cover.getBytes());
        var filePath = localStorageService.store(cover);

        //artist.setArtistArtUrl("images/" + cover.getOriginalFilename());
        artist.setArtistArtUrl(filePath);
        artistRepository.save(artist);
    }
}
