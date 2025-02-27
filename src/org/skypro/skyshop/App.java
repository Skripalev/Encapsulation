package org.skypro.skyshop;
import org.skypro.skyshop.content.Article;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.product.SimpleProduct;
import org.skypro.skyshop.search.SearchEngine;
import org.skypro.skyshop.search.Searchable;
import java.util.Arrays;

public class App {

    public static void main(String[] args) {

        Product product1 = new SimpleProduct("Яблоко", 200);
        Product product2 = new FixPriceProduct("Манго");
        Product product3 = new FixPriceProduct.DiscountedProduct("Банан", 1000, 10);

        ProductBasket basket = new ProductBasket();

        Article article1 = new Article("Как выбрать Яблоко", "Выбирайте яблоки по цвету, без вмятин.");
        Article article2 = new Article("Как выбрать Манго", "Выбирайте наугад, я понятия не иммею как.");
        Article article3 = new Article("Как выбрать Банан", "Банан следует брать желтого цвета, желтый цвет сведетельствует о его спелости.");

        basket.addProduct(product1);
        basket.addProduct(product2);
        basket.addProduct(product3);

        basket.printBasket();

        SearchEngine searchEngine = new SearchEngine(10);

        searchEngine.add(product1);
        searchEngine.add(product2);
        searchEngine.add(product3);
        searchEngine.add(article1);
        searchEngine.add(article2);
        searchEngine.add(article3);


        System.out.println("=== Поиск по запросу \"яблок\" ===");
        Searchable[] results1 = searchEngine.search("яблок");
        System.out.println(Arrays.toString(results1));

        System.out.println("\n=== Поиск по запросу \"Банан\" ===");
        Searchable[] results2 = searchEngine.search("Банан");
        System.out.println(Arrays.toString(results2));


        System.out.println("Общая стоимость корзины: " + basket.getTotalCost());


        System.out.println("Есть ли в корзине Банан? " + basket.containsProduct("Банан"));


        System.out.println("Есть ли в корзине Манго? " + basket.containsProduct("Манго"));


        basket.clearBasket();


        basket.printBasket();


        System.out.println("Общая стоимость пустой корзины: " + basket.getTotalCost());


        System.out.println("Есть ли в корзине Яблоко? " + basket.containsProduct("Яблоко"));


    }


}

