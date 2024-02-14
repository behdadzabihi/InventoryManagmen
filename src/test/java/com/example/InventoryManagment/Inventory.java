package com.example.InventoryManagment;

import org.openqa.selenium.InvalidArgumentException;
import org.openqa.selenium.NotFoundException;

public class Inventory {

    private String product;

    private Double unitPrice;

    private Integer id;

    private Boolean available;


    public Inventory(Integer id,String product, Double unitPrice,Boolean available) {
    guardAgainstInvalidProduct(product);
    guardAgainstInvalidUnitPrice(unitPrice);
        this.id=id;
        this.product = product;
        this.unitPrice = unitPrice;
        this.available=available;
    }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Boolean getAvailable() {
        return available;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }


    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public Double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public void guardAgainstInvalidProduct(String product){
        if(product == null)
            throw new NullPointerException();
    }

    public void guardAgainstInvalidUnitPrice(Double unitPrice){
        if(unitPrice == null) {
            throw new NullPointerException();
        } else if (unitPrice <0) {
            throw new InvalidArgumentException("Invalid Unit Price");
        }
    }
}
