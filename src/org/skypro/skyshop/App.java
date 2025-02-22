package org.skypro.skyshop;

import org.skypro.skyshop.FixedPrice.FixPriceProduct;
import org.skypro.skyshop.ProductDiscount.DiscountedProduct;
import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.product.SimpleProduct;

public class App {

    public static void main(String[] args) {

        Product product1 = new SimpleProduct("Яблоко", 200);
        Product product2 = new FixPriceProduct("Манго");
        Product product3 = new DiscountedProduct("Банан", 1000, 10);

        ProductBasket basket = new ProductBasket();

        basket.addProduct(product1);
        basket.addProduct(product2);
        basket.addProduct(product3);

        basket.printBasket();

        System.out.println("Общая стоимость корзины: " + basket.getTotalCost());


        System.out.println("Есть ли в корзине Банан? " + basket.containsProduct("Банан"));


        System.out.println("Есть ли в корзине Манго? " + basket.containsProduct("Манго"));


        basket.clearBasket();


        basket.printBasket();


        System.out.println("Общая стоимость пустой корзины: " + basket.getTotalCost());


        System.out.println("Есть ли в корзине Яблоко? " + basket.containsProduct("Яблоко"));


    }


}

