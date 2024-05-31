package edu.upc.dsa.models;

public class Badge {
    private String name;
    private String image;

    // Constructor
    public Badge(String name, String image) {
        this.name = name;
        this.image = image;
    }

    // Getters y Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Badge() {
    }
}
