package com.dinhtrongdat.onlinegrocerystore.model;

import java.io.Serializable;

public class Category implements Serializable {
    private int id;
    private int imgResource;

    public Category(int id, int imgResource) {
        this.id = id;
        this.imgResource = imgResource;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getImgResource() {
        return imgResource;
    }

    public void setImgResource(int imgResource) {
        this.imgResource = imgResource;
    }
}
