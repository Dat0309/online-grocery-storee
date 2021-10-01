package com.dinhtrongdat.onlinegrocerystore.model;

import java.io.Serializable;

public class DiscounterProduct implements Serializable {
    int id;
    int img;

    public DiscounterProduct(int id, int img) {
        this.id = id;
        this.img = img;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }
}
