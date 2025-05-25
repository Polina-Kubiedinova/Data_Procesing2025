package com.example.laba4.model;

import jakarta.persistence.*;

@Entity
@Table(name = "picture")
public class Picture {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "author")
    private String author;

    @Column(name = "image_url")
    private String image_url;

    public Picture() {}

    public Picture(String name, String author, String image_url) {
        this.name = name;
        this.author = author;
        this.image_url = image_url;
    }

    public Long getId() {return id;}

    public void setId(Long id) {this.id = id;}

    public String getName() {return name;}

    public void setName(String name) {this.name = name;}

    public String getAuthor() {return author;}

    public void setAuthor(String author) {this.author = author;}

    public String getImage_url() {return image_url;}

    public void setImage_url(String image_url) {this.image_url = image_url;}

}
