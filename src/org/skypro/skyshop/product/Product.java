package org.skypro.skyshop.product;


import org.skypro.skyshop.search.Searchable;

import java.util.Objects;


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

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(productName, product.productName);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(productName);
    }

    public abstract int getProductPrice();

    public abstract boolean isSpecial();


}
