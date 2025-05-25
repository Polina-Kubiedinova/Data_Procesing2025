package com.lab.variant;

public class Cosmetic {
    private int id;
    private String name;
    private String imageUrl;
    private String brand;
    private double price;
    private String composition;

    public Cosmetic(int id,String name, String imageUrl, String brand, double price, String composition)
    {
        this.id = id;
        this.name = name;
        this.imageUrl = imageUrl;
        this.brand = brand;
        this.price = price;
        this.composition = composition;
    }
    public int getId(){return id;}
    public void setId(int id){this.id = id;}
    public String getName(){return name;}
    public String getImageUrl(){return imageUrl;}
    public String getBrand(){return brand;}
    public double getPrice(){return price;}
    public String getComposition(){return composition;}
}
