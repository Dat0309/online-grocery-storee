package com.dinhtrongdat.onlinegrocerystore.model;

import java.io.Serializable;

public class Recently implements Serializable {
    private String name;
    private String descrip;
    private double price;
    private String unit;
    private int imgResource;

    public Recently(String name, String descrip, double price, String unit, int imgResource) {
        this.name = name;
        this.descrip = descrip;
        this.price = price;
        this.unit = unit;
        this.imgResource = imgResource;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescrip() {
        return descrip;
    }

    public void setDescrip(String descrip) {
        this.descrip = descrip;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public int getImgResource() {
        return imgResource;
    }

    public void setImgResource(int imgResource) {
        this.imgResource = imgResource;
    }
}
