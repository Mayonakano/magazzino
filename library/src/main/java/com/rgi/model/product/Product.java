package com.rgi.model.product;

import com.rgi.model.subcategory.Subcategory;
import javax.persistence.*;
@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    private String shortDescription;
    private Double basePrice;
    private int quantity;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name= "subcategory_id",nullable = false)
    private Subcategory subcategory;

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public void setBasePrice(Double basePrice) {
        this.basePrice = basePrice;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setSubcategory(Subcategory subcategory) {
        this.subcategory = subcategory;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public Double getBasePrice() {
        return basePrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public Subcategory getSubcategory() {
        return subcategory;
    }

}
