package com.example.laba4.control;

import com.example.laba4.model.Picture;
import com.example.laba4.service.PicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@RestController
@RequestMapping("/api/items")
@CrossOrigin(origins = "http://localhost:5173")
public class PicControl{
    private final PicService picService;

    public PicControl(PicService picService) {
        this.picService = picService;
    }

    @GetMapping
    public List<Picture> getAllDestinations() {
        return picService.getAllPicture();
    }
}