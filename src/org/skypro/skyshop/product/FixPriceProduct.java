package org.skypro.skyshop.product;

public class FixPriceProduct extends Product {

    private static final int FIXED_PRICE = 100;

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

    @Override
    public String getName() {
        return "";
    }

    @Override
    public String getStringRepresentation() {
        return super.getStringRepresentation();
    }

    public static class DiscountedProduct extends Product {

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

        @Override
        public String getName() {
            return "";
        }

        @Override
        public String getStringRepresentation() {
            return super.getStringRepresentation();
        }
    }
}