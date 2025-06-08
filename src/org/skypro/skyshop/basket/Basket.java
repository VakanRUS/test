package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

public class Basket {
    static Product[] productBasket = new Product[5];
    static int totalPrice = 0;

    // добавить товар в корзину
    public static void addToBasket(String name, int price) {
        Product basket = new Product(name, price);
        for (int i = 0; i < productBasket.length; i++) {
            if (productBasket[i] == null) {
                productBasket[i] = basket;
                System.out.println("Продукт добавлен в корзину: " + name + ": " + price);
                break;
            } else if (i == productBasket.length - 1 && productBasket[i] != null) {
                System.out.println("Невозможно добавить продукт");
            } else continue;
        }
    }

    // распечатать содержимое корзины
    public static void printBasket() {
        System.out.println("Содержимое корзины:");
        for (int i = 0; i < productBasket.length; i++) {
            if (productBasket[i] != null) {
                System.out.println(productBasket[i].getProductName() + ": " + productBasket[i].getProductPrice());
            } else {
                continue;
            }
        }
        System.out.println("Итого: " + Basket.countTotalPrice());
    }

    // расчет полной стоимости корзины
    public static int countTotalPrice() {
        totalPrice = 0;
        for (int i = 0; i < productBasket.length; i++) {
            if (productBasket[i] != null) {
                totalPrice += productBasket[i].getProductPrice();
            } else continue;
        }
        return totalPrice;
    }

    // проверка наличия
    public static boolean checkExistence(String name) {
        boolean check = false;
        for (int i = 0; i < productBasket.length; i++) {
            if (productBasket[i] != null && productBasket[i].getProductName().equals(name)) {
                check = true;
                break;
            } else continue;
        }
        return check;
    }

    // очистка корзины
    public static void CleanBasket() {
        for (int i = 0; i < productBasket.length; i++) {
            productBasket[i] = null;
            totalPrice = 0;
        }
        System.out.println("Корзина очищена");
    }
}
