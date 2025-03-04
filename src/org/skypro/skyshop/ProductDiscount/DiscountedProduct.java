package org.skypro.skyshop.ProductDiscount;

import org.skypro.skyshop.product.Product;

public class DiscountedProduct extends Product {

    private final int basePrice;
    private final int discount;

    public DiscountedProduct(String productName, int basePrice, int discount) {
        super(productName);
        this.basePrice = basePrice;
        this.discount = discount;
    }

    @Override
    public boolean isSpecial() {
        return true;
    }

    @Override
    public int getProductPrice() {
        return basePrice - (basePrice * discount / 100);
    }


    @Override
    public String toString() {
        return getProductName() + ": " + getProductPrice() + " (" + discount + "%)";
    }
}