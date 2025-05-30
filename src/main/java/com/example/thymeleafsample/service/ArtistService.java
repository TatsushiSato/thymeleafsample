package com.example.thymeleafsample.service;

import com.example.thymeleafsample.entity.Artist;
import com.example.thymeleafsample.repository.ArtistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ArtistService {

    private final ArtistRepository artistRepository;

    @Autowired
    public ArtistService(ArtistRepository artistRepository) {
        this.artistRepository = artistRepository;
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
    public void registerArtist(Artist artist) {
        artistRepository.save(artist);
    }
}
