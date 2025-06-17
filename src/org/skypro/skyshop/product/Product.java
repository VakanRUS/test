package org.skypro.skyshop.product;

public abstract class Product {
    private final String productName;

    public Product(String productName) {
        this.productName = productName;
    }

    public boolean isSpecial() {
        return false;
    }

    public String getProductName() {
        return productName;
    }

    public abstract int getPrice();
}