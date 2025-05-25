package com.example.laba4.repository;

import com.example.laba4.model.Picture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PicRep extends JpaRepository<Picture, Long> {
}