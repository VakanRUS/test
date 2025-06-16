package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.product.SimpleProduct;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;

public class Basket {
    Product[] productBasket = new Product[5];
    int totalPrice = 0;
    int CheckIsBasketFull = 0;

    // Добавление товара в корзину
     public void addProduct(String name, int price, int discount) {
         if (price == 0) {
            FixPriceProduct addProduct = new FixPriceProduct(name);
            this.addFixedPriceProduct(addProduct);
        } else if (discount != 0) {
            DiscountedProduct addProduct = new DiscountedProduct(name, price, discount);
            this.addDiscountProduct(addProduct);
        } else {
            SimpleProduct addProduct = new SimpleProduct(name, price);
            this.addSimpleProduct(addProduct);
        }
    }

    // Добавление простого товара в корзину
    public void addSimpleProduct(SimpleProduct product) {
        for (byte i = 0; i < productBasket.length; i++) {
            if (productBasket[i] == null) {
                productBasket[i] = new SimpleProduct(product.getProductName(), product.getPrice());
                System.out.println("Продукт добавлен в корзину: " + product.getProductName() + ": " + product.getPrice());
                CheckIsBasketFull++;
                return;
            }
        }
        System.out.println("Невозможно добавить продукт");
    }

    // Добавление товара со скидкой в корзину
    public void addDiscountProduct(DiscountedProduct product) {
        for (byte i = 0; i < productBasket.length; i++) {
            if (productBasket[i] == null) {
                productBasket[i] = new DiscountedProduct(product.getProductName(), product.getDiscountPrice(), product.getDiscountPercent());
                System.out.println("Продукт добавлен в корзину: " + product.getProductName() + ": " + product.getDiscountPrice() + " (скидка " + product.getDiscountPercent() + ")");
                CheckIsBasketFull++;
                return;
            }
        }
        System.out.println("Невозможно добавить продукт");
    }

    // Добавление товара с фиксированной ценой в корзину
    public void addFixedPriceProduct(FixPriceProduct product) {
        for (byte i = 0; i < productBasket.length; i++) {
            if (productBasket[i] == null) {
                productBasket[i] = new FixPriceProduct(product.getProductName());
                System.out.println("Продукт добавлен в корзину: " + product.getProductName() + ": фиксированная цена");
                CheckIsBasketFull++;
                return;
            }
        }
        System.out.println("Невозможно добавить продукт");
    }

    // Распечатка содержимого корзины
    public void printBasket() {
        int numberOfSpecialProducts = 0;
        if (CheckIsBasketFull != 0) {
            System.out.println("Содержимое корзины:");
        }
        for (byte i = 0; i < productBasket.length; i++) {
            if (productBasket[i] != null) {
                System.out.println(productBasket[i].toString());
            }
            if (productBasket[i] != null && productBasket[i].isSpecial()){
                numberOfSpecialProducts++;
            }
        }
        if (CheckIsBasketFull == 0) {
            System.out.println("Корзина пуста");
        } else {
            System.out.println("Итого: " + countTotalPrice());
            System.out.println("Специальных товаров: " + numberOfSpecialProducts);
        }
    }

    // Расчет полной стоимости корзины
    public int countTotalPrice() {
        totalPrice = 0;
        for (byte i = 0; i < productBasket.length; i++) {
            if (productBasket[i] != null) {
                totalPrice += productBasket[i].getPrice();
            }
        }
        return totalPrice;
    }

    // Проверка наличия
    public boolean checkExistence(String name) {
        boolean check = false;
        for (byte i = 0; i < productBasket.length; i++) {
            if (productBasket[i] != null && productBasket[i].getProductName().equals(name)) {
                check = true;
                System.out.println("Поиск: " + name + " - товар уже добавлен в корзину");
                return check;
            }
        }
        System.out.println("Поиск: " + name + " - товар в корзине не найден");
        return check;
    }

    // Очистка корзины
    public void CleanBasket() {
        for (byte i = 0; i < productBasket.length; i++) {
            productBasket[i] = null;
            totalPrice = 0;
        }
        CheckIsBasketFull = 0;
        System.out.println("Корзина очищена");
    }
}