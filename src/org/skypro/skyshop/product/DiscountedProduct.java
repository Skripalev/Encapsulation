package org.skypro.skyshop.product;


public class DiscountedProduct extends Product {
    private final int basePrice;
    private final int discount;

    public DiscountedProduct(String productName, int basePrice, int discount) {
        super(productName);
        if (basePrice <= 0) {
            throw new IllegalArgumentException("Введите корректное значение базовой цены!");
        }
        if (discount < 0 || discount > 100) {
            throw new IllegalArgumentException("Введите корректное значение скидки!");
        }
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

    @Override
    public String getName() {
        return getProductName();
    }

    @Override
    public String getStringRepresentation() {
        return super.getStringRepresentation();
    }
}

