package com.example.laba4.control;

import com.example.laba4.model.Picture;
import com.example.laba4.repository.PicRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("pictures")
public class PicControl {


    @Autowired
    private PicRep pictureRepository;

    @GetMapping
    public String listPicture(Model model) {
        model.addAttribute("pictures", pictureRepository.findAll());
        return "picture-list";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("picture", new Picture());
        return "picture-form";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Picture picture = pictureRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Невірний ID картини: " + id));
        model.addAttribute("picture", picture);
        return "picture-form";
    }

    @PostMapping("/save")
    public String savePicture(@ModelAttribute("picture") Picture picture) {
        pictureRepository.save(picture);
        return "redirect:/pictures";
    }


    @GetMapping("/delete/{id}")
    public String deletePicture(@PathVariable Long id) {
        pictureRepository.deleteById(id);
        return "redirect:/pictures";
    }

}