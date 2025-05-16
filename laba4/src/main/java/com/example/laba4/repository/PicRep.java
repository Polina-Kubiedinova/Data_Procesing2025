package com.example.laba4.repository;

import com.example.laba4.model.Picture;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PicRep extends JpaRepository<Picture, Long> {
    List<Picture> findByName(String name);
}