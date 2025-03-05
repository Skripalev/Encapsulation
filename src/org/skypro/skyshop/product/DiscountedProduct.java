package org.skypro.skyshop.product;


public class DiscountedProduct extends Product {
    private final int basePrice;
    private final int discount;

    public DiscountedProduct(String productName, int basePrice, int discount) {
        super(productName);
        this.basePrice = basePrice;
        this.discount = discount;
        if (basePrice >= 1) {
        } else {
            throw new IllegalArgumentException("Введите корректное значение базовой цены!");
        }
        if (discount >= 0 && discount <= 100) {
        } else {
            throw new IllegalArgumentException("Введите корректное значение скидки!");
        }
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

    @Override
    public String getName() {
        return "";
    }

    @Override
    public String getStringRepresentation() {
        return super.getStringRepresentation();
    }
}

