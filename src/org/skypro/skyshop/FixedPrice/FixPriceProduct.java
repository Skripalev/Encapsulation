package org.skypro.skyshop.FixedPrice;

import org.skypro.skyshop.product.Product;

public class FixPriceProduct extends Product {

    private static final int FIXED_PRICE = 100; // Пример фиксированной цены

    public FixPriceProduct(String productName) {
        super(productName);

    }

    @Override
    public boolean isSpecial() {
        return true;
    }


    @Override
    public int getProductPrice() {
        return FIXED_PRICE;
    }


    @Override
    public String toString() {
        return getProductName() + ": Фиксированная цена " + FIXED_PRICE;
    }
}