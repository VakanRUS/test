package org.skypro.skyshop.product;

public class DiscountedProduct extends Product {
    private int productPrice;
    private int discountPercent;
    private int discountPrice;

    public DiscountedProduct(String name, int price, int discount) {
        super(name);
        productPrice = price;
        discountPercent = discount;
        discountPrice = calculateDiscount(price);
    }

    private int calculateDiscount(int price) {
        price = price - ((price * discountPercent) / 100);
        return price;
    }

    @Override
    public boolean isSpecial() {
        return true;
    }

    @Override
    public int getPrice() {
        return discountPrice;
    }

    public int getDiscountPercent() {
        return discountPercent;
    }

    public int getDiscountPrice() {
        return discountPrice;
    }

    @Override
    public String toString() {
        return productName + ": " + discountPrice + " (скидка -" + discountPercent + "%)";
    }
}