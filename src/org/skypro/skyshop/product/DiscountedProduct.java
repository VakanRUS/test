package org.skypro.skyshop.product;

public class DiscountedProduct extends Product {
    private final int productPrice;
    private final int discountPercent;

    public DiscountedProduct(String name, int price, int discount) {
        super(name);
        productPrice = price;
        discountPercent = discount;
    }

    @Override
    public boolean isSpecial() {
        return true;
    }

    @Override
    public int getPrice() {
        return productPrice - ((productPrice * discountPercent) / 100);
    }

    public int getDiscountPercent() {
        return discountPercent;
    }

    @Override
    public String toString() {
        return getProductName() + ": " + getPrice() + " (скидка -" + discountPercent + "%)";
    }
}