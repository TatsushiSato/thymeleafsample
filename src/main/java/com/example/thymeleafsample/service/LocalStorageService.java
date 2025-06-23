package com.example.thymeleafsample.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

@Service
@Profile("local")
public class LocalStorageService implements StorageService {


    @Override
    public String store(MultipartFile file) {
        try {
            Files.write(Paths.get("static/images/" + file.getOriginalFilename()),file.getBytes());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return "images/" + file.getOriginalFilename();
    }
}
