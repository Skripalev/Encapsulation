package org.skypro.skyshop.product;

public class SimpleProduct extends Product {

    public int productPrice;

    public SimpleProduct(String productName, int productPrice) {
        super(productName);
        this.productPrice = productPrice;
    }

    public int getProductPrice() {
        return productPrice;
    }

    @Override
    public boolean isSpecial() {

        return false;
    }

    @Override
    public String getProductName() {

        return super.getProductName();
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
