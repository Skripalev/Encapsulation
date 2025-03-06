package org.skypro.skyshop.product;


import org.skypro.skyshop.search.Searchable;


public abstract class Product implements Searchable {
    private final String productName;

    protected Product(String productName) {
        if (productName == null || productName.isBlank()) {
            throw new IllegalArgumentException("Введите корректное значение наименования!");
        }
        this.productName = productName;
    }


    public String getProductName() {

        return productName;
    }

    public String getSearchTerm() {
        return productName;
    }

    public String getContentType() {
        return "PRODUCT: ";
    }

    public abstract int getProductPrice();

    public abstract boolean isSpecial();


}
