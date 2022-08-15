package com.shamel.crudapplication;

import java.io.Serializable;

public class Product implements Serializable {
    private int id;
    private float price;
    private String name;

    public Product() {
        id = 0;
        price = 0.0f;
        name = "";
    }

    public Product(int id, float price, String name) {
        this.id = id;
        this.price = price;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
