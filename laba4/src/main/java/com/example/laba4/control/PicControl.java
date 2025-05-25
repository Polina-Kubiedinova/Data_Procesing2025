package com.example.laba4.control;

import com.example.laba4.model.Picture;
import com.example.laba4.repository.PicRep;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

@RestController
@RequestMapping("/api/picture")
public class PicControl{
    @Autowired
    private PicRep pictureRepository;

    @GetMapping
    public List<Picture> getAllDestinations() {
        return pictureRepository.findAll();
    }

    @PostMapping
    public Picture createPicture(@RequestBody Picture picture) {
        return pictureRepository.save(picture);
    }

    @PutMapping("/{id}")
    public Picture updatePicture(@PathVariable Long id, @RequestBody Picture pictureDetails) {
        Picture picture = pictureRepository.findById(id).orElseThrow();
        picture.setName(pictureDetails.getName());
        picture.setAuthor(pictureDetails.getAuthor());
        picture.setImage_url(pictureDetails.getImage_url());
        return pictureRepository.save(picture);
    }

    @DeleteMapping("/{id}")
    public void deletePicture(@PathVariable Long id) {
        pictureRepository.deleteById(id);
    }
}