package org.skypro.skyshop;

import org.skypro.skyshop.basket.Basket;

public class App {
    public static void main(String[] args) {
        Basket basket = new Basket();

        System.out.println("1. Добавление продукта в корзину.");
        basket.addProduct("Вишня", 100, 0);
        basket.addProduct("Яблоки",0,0);
        basket.addProduct("Картошка", 60, 15);
        basket.addProduct("Кефир",0,0);
        basket.addProduct("Хлеб", 40, 15);
        System.out.println();

        System.out.println("2. Добавление продукта в заполненную корзину, в которой нет свободного места.");
        basket.addProduct("Тест", 1000, 0);
        System.out.println();

        System.out.println("3. Печать содержимого корзины с несколькими товарами.");
        basket.printBasket();
        System.out.println();

        System.out.println("4. Получение стоимости корзины с несколькими товарами.");
        System.out.println("Итого: " + basket.countTotalPrice());
        System.out.println();

        System.out.println("5. Поиск товара, который есть в корзине.");
        basket.checkExistence("Хлеб");
        System.out.println();

        System.out.println("6. Поиск товара, которого нет в корзине.");
        basket.checkExistence("Test");
        System.out.println();

        System.out.println("7. Очистка корзины.");
        basket.CleanBasket();
        System.out.println();

        System.out.println("8. Печать содержимого пустой корзины.");
        basket.printBasket();
        System.out.println();

        System.out.println("9. Получение стоимости пустой корзины.");
        System.out.println("Итого: " + basket.countTotalPrice());
        System.out.println();

        System.out.println("10. Поиск товара по имени в пустой корзине.");
        basket.checkExistence("Хлеб");
        System.out.println();
    }
}