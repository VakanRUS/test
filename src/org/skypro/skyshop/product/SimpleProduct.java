package org.skypro.skyshop.product;

import java.util.Objects;

public class SimpleProduct extends Product {
    private final int simplePrice;

    public SimpleProduct(String name, int price) {
        super(name);

        if (price <= 0) {
            throw new IllegalArgumentException("Цена не может быть меньше либо равна 0!");
        } else simplePrice = price;
    }

    @Override
    public int getPrice() {
        return simplePrice;
    }

    @Override
    public boolean isSpecial() {
        return false;
    }

    @Override
    public String toString() {
        return getName() + ": " + simplePrice;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        SimpleProduct that = (SimpleProduct) o;
        return getName().equals(that.getName()) && getPrice() == that.getPrice();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getPrice());
    }
}