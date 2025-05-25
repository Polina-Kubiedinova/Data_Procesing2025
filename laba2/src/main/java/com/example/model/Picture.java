package com.example.model;
import jakarta.persisteence.*;
@Entity
@Table(name ="items")
public class Picture {

    @ID
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "image_url")
    private String image_url;

    public Picture() {}

    public Picture(String name, String description, String image_url)
    {
        this.name = name;
        this.description = description;
        this.image_url = image_url;
    }
    public Long getId() {return id;}
    public void setId(Long id){this.id = id;}

    public String getName() {return name;}
    public void setName(String name){this.name = name;}

    public String getDescription() {return description;}
    public void setDescription(String description){this.description = description;}

    public String getImage_url() {return image_url;}
    public void setImage_url(String image_url){this.image_url = image_url;}

    @Override
    public String toString(){
        return "Picture{id="+id+",name='"+name+"', description ='" + description + "', image url='"+image_url+"'}";
    }
}
