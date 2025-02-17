package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.Product;

public class Main {

    public static Product[] products = new Product[5];

    public static void main(String[] args) {


        products[0] = new Product("Картофель", 100);
        products[1] = new Product("Помидоры", 250);
        products[2] = new Product("Огурцы", 270);
        products[3] = new Product("Бананы", 170);
        products[4] = new Product("Мандарины", 160);

        ProductBasket basket = new ProductBasket();

        basket.addProduct(products[0]);
        basket.addProduct(products[1]);
        basket.addProduct(products[2]);
        basket.addProduct(products[3]);
        basket.addProduct(products[4]);
        basket.addProduct(products[4]);

        basket.printBasket();

        System.out.println("Есть ли в корзине Картофель? " + basket.containsProduct("Картофель"));

        System.out.println("Есть ли в корзине Бананы? " + basket.containsProduct("Бананы"));

        basket.clearBasket();

        basket.printBasket();

        System.out.println("Есть ли в корзине Картофель? " + basket.containsProduct("Картофель"));


    }


}

