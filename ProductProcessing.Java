import java.util.*;
import java.util.stream.Collectors;

class Product {
    String name;
    String category;
    double price;

    public Product(String name, String category, double price) {
        this.name = name;
        this.category = category;
        this.price = price;
    }
}

public class ProductProcessing {
    public static void main(String[] args) {
        List<Product> products = Arrays.asList(
            new Product("Laptop", "Electronics", 1200),
            new Product("Phone", "Electronics", 800),
            new Product("TV", "Electronics", 1500),
            new Product("Shoes", "Fashion", 100),
            new Product("T-shirt", "Fashion", 30),
            new Product("Jeans", "Fashion", 60),
            new Product("Fridge", "Appliances", 900),
            new Product("Washing Machine", "Appliances", 1100)
        );

        // Grouping products by category
        Map<String, List<Product>> groupedByCategory = products.stream()
                .collect(Collectors.groupingBy(p -> p.category));

        System.out.println("\n--- Products Grouped by Category ---");
        groupedByCategory.forEach((category, productList) -> {
            System.out.println(category + ": " + productList.stream().map(p -> p.name).collect(Collectors.toList()));
        });

        // Finding the most expensive product in each category
        Map<String, Optional<Product>> mostExpensiveInEachCategory = products.stream()
                .collect(Collectors.groupingBy(
                        p -> p.category,
                        Collectors.maxBy(Comparator.comparingDouble(p -> p.price))
                ));

        System.out.println("\n--- Most Expensive Product in Each Category ---");
        mostExpensiveInEachCategory.forEach((category, product) ->
                product.ifPresent(p -> System.out.println(category + ": " + p.name + " ($" + p.price + ")"))
        );

        // Calculating the average price of all products
        double averagePrice = products.stream()
                .mapToDouble(p -> p.price)
                .average()
                .orElse(0);

        System.out.println("\nAverage Price of All Products: $" + averagePrice);
    }
}
