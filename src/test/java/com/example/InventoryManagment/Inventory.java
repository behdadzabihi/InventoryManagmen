package com.example.InventoryManagment;

public class Inventory {

    private String product;

    private Double unitPrice;

    public Inventory(String product, Double unitPrice) {
        this.product = product;
        this.unitPrice = unitPrice;
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
}
