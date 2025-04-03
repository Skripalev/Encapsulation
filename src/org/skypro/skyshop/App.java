package org.skypro.skyshop;

import org.skypro.skyshop.content.Article;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.product.SimpleProduct;
import org.skypro.skyshop.search.BestResultNotFound;
import org.skypro.skyshop.search.SearchEngine;
import org.skypro.skyshop.search.Searchable;

import java.util.List;
import java.util.Set;


public class App {
    public static void main(String[] args) {
        Product product1 = new SimpleProduct("Яблоко", 200);
        Product product2 = new FixPriceProduct("Манго");
        Product product3 = new DiscountedProduct("Банан", 10, 50);
        ProductBasket basket = new ProductBasket();
        basket.addProduct(product1);
        basket.addProduct(product2);
        basket.addProduct(product3);
        basket.printBasket();
        System.out.println();
        Article article1 = new Article("Как выбрать Яблоко?", "Выбирайте яблоки по цвету, без вмятин.");
        Article article2 = new Article("Как выбрать Манго?", "Выбирайте наугад, я понятия не имею как.");
        Article article3 = new Article("Как выбрать Банан?", "Банан следует брать желтого цвета, желтый цвет свидетельствует о его спелости.");

        SearchEngine searchEngine = new SearchEngine();
        searchEngine.add(product1);
        searchEngine.add(product2);
        searchEngine.add(product3);
        searchEngine.add(article1);
        searchEngine.add(article2);
        searchEngine.add(article3);

        System.out.println("\n=== Демонстрация поиска продуктов ===");
        Product apple = new SimpleProduct("Яблоко", 200);
        Product mango = new FixPriceProduct("Манго");
        Product banana = new DiscountedProduct("Банан", 10, 50);

        SearchEngine productSearchEngine = new SearchEngine();
        productSearchEngine.add(apple);
        productSearchEngine.add(mango);
        productSearchEngine.add(banana);
        System.out.println("\nРезультаты поиска по запросу 'Яблоко':");
        Set<Searchable> appleResults = productSearchEngine.search("Яблоко");
        appleResults.forEach(result -> System.out.println("- " + result.getSearchTerm()));
        System.out.println("\nРезультаты поиска по запросу 'Манго':");
        Set<Searchable> mangoResults = productSearchEngine.search("Манго");
        mangoResults.forEach(result -> System.out.println("- " + result.getSearchTerm()));
        System.out.println("\nРезультаты поиска по запросу 'Банан':");
        Set<Searchable> bananaResults = productSearchEngine.search("Банан");
        bananaResults.forEach(result -> System.out.println("- " + result.getSearchTerm()));
        System.out.println("\nРезультаты поиска по запросу 'Апельсин':");
        Set<Searchable> orangeResults = productSearchEngine.search("Апельсин");
        if (orangeResults.isEmpty()) {
            System.out.println("- Ничего не найдено");
        } else {
            orangeResults.forEach(result -> System.out.println("- " + result.getSearchTerm()));
        }
        try {
            System.out.println("\nНаиболее релевантный продукт для запроса 'Яблоко':");
            Searchable mostRelevantApple = productSearchEngine.findMostRelevant("Яблоко");
            System.out.println("- " + mostRelevantApple.getSearchTerm());
        } catch (BestResultNotFound e) {
            System.out.println("- Ошибка: " + e.getMessage());
        }
        try {
            System.out.println("\nНаиболее релевантный продукт для запроса 'Ананас':");
            Searchable mostRelevantPineapple = productSearchEngine.findMostRelevant("Ананас");
            System.out.println("- " + mostRelevantPineapple.getSearchTerm());
        } catch (BestResultNotFound e) {
            System.out.println("- Ошибка: " + e.getMessage());
        }

        System.out.println("Общая стоимость корзины: " + basket.getTotalCost());
        System.out.println("Есть ли в корзине Банан? " + basket.containsProduct("Банан"));
        System.out.println("Есть ли в корзине Манго? " + basket.containsProduct("Манго"));
        List<Product> removedProducts = basket.removeProductByName("Банан");
        System.out.println("Удаленные продукты: " + removedProducts);
        basket.printBasket();

        List<Product> removedNonExistent = basket.removeProductByName("Апельсин");
        if (removedNonExistent.isEmpty()) System.out.println("Список пуст");
        basket.printBasket();
        basket.clearBasket();
        basket.printBasket();
        System.out.println("Общая стоимость пустой корзины: " + basket.getTotalCost());
        System.out.println("Есть ли в корзине Яблоко? " + basket.containsProduct("Яблоко"));

        try {
            Product product4 = new SimpleProduct("  ", 500);
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
        try {
            Product product5 = new FixPriceProduct("  ");
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
        try {
            Product product6 = new DiscountedProduct("Манго", 500, 101);
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }

        searchEngine.add(new SimpleProduct("Яблоко", 200));
        searchEngine.add(new Article("Как выбрать яблоко?", "Выбирайте яблоки по цвету."));
        searchEngine.add(new DiscountedProduct("Яблоко с скидкой", 100, 10));
        Searchable mostRelevant;
        try {
            mostRelevant = searchEngine.findMostRelevant("Яблоко");
            System.out.println("Наиболее подходящий объект: " + mostRelevant.getSearchTerm());
        } catch (BestResultNotFound e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
        try {
            mostRelevant = searchEngine.findMostRelevant("Апельсин");
            System.out.println("Наиболее подходящий объект: " + mostRelevant.getSearchTerm());
        } catch (BestResultNotFound e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }
}

