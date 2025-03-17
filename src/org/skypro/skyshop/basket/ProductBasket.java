package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductBasket {
    private final Map<String, List<Product>> products;

    public ProductBasket() {
        this.products = new HashMap<>();
    }

    public void addProduct(Product product) {
        products.computeIfAbsent(product.getProductName(), k -> new ArrayList<>()).add(product);
    }

    public int getTotalCost() {
        int totalCost = 0;
        for (List<Product> productList : products.values()) {
            for (Product product : productList) {
                totalCost += product.getProductPrice();
            }
        }
        return totalCost;
    }

    public void printBasket() {
        if (products.isEmpty()) {
            System.out.println("В корзине пусто");
        } else {
            int specialCount = 0;
            for (List<Product> productList : products.values()) {
                for (Product product : productList) {
                    System.out.println(product.toString());
                    if (product.isSpecial()) {
                        specialCount++;
                    }
                }
            }
            System.out.println("Итого: " + getTotalCost());
            System.out.println("Специальных товаров: " + specialCount);
        }
    }

    public boolean containsProduct(String productName) {
        return products.containsKey(productName);
    }

    public void clearBasket() {
        products.clear();
    }

    public List<Product> removeProductByName(String name) {
        List<Product> removedProducts = products.remove(name);
        return removedProducts != null ? removedProducts : Collections.emptyList();
    }
}