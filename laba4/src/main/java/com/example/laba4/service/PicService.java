package com.example.laba4.service;

import com.example.laba4.model.Picture;
import com.example.laba4.repository.PicRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PicService {

    @Autowired
    private PicRep picRep;

    public List<Picture> getAllPicture() {
        return picRep.findAll();}

}