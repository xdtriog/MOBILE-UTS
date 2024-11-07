package com.example.mobileutskevindinata;

public class TouristSpot {
    private String name;
    private String location;
    private int image;
    private String description;  // Menambahkan deskripsi tempat wisata

    // Constructor
    public TouristSpot(String name, String location, int image, String description) {
        this.name = name;
        this.location = location;
        this.image = image;
        this.description = description;  // Menyimpan deskripsi
    }

    // Getter and Setter
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getDescription() {
        return description;  // Menambahkan getter untuk deskripsi
    }

    public void setDescription(String description) {
        this.description = description;  // Menambahkan setter untuk deskripsi
    }
}
