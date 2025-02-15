package org.skypro.skyshop;

public class ProductBasket {

    private final Product[] products;
    private int count;

    public ProductBasket() {
        this.products = new Product[5];
        this.count = 0;
    }

    public void addProduct(Product product) {
        if (count < products.length) {
            products[count] = product;
            count++;
        } else {
            System.out.println("Невозможно добавить продукт!");
        }
    }

    public int getTotalCost() {
        int totalCost = 0;
        for (int i = 0; i < count; i++) {
            totalCost += products[i].getProductPrice();
        }
        return totalCost;
    }

    public void printBasket() {
        if (count == 0) {
            System.out.println("В корзине пусто!");
            return;
        }
        for (int i = 0; i < count; i++) {
            System.out.println(products[i].getProductName() + ": " + products[i].getProductPrice());
        }
        System.out.println("Итого: " + getTotalCost());
    }

    public boolean containsProduct(String productName) {
        for (int i = 0; i < count; i++) {
            if (products[i].getProductName().equals(productName)) {
                return true;
            }
        }
        return false;
    }

    public void clearBasket() {
        for (int i = 0; i < count; i++) {
            products[i] = null;
        }
        count = 0;
    }

}