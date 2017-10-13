package com.example.yangxp.materialdesigntest.model;


public class Fruit {

    public Fruit(String name, int imageId) {
        this.name = name;
        this.imageId = imageId;
    }

    private String name;

    private int imageId;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }
}
