package gioelefriggia;

import gioelefriggia.entities.Order;
import gioelefriggia.entities.OrderCustomer;
import gioelefriggia.entities.Product;

import java.util.*;
import java.util.stream.Collectors;

public class Application {

    public static void main(String[] args) {
        // Creazione di un elenco di ordini di esempio
        List<Order> orders = createSampleOrders();

        // Esercizio #1: Raggruppare gli ordini per cliente
        Map<OrderCustomer, List<Order>> ordersByCustomer = groupOrdersByCustomer(orders);
        System.out.println("Esercizio #1 - Raggruppamento degli ordini per cliente:");
        ordersByCustomer.forEach((customer, orderList) -> {
            System.out.println("Cliente: " + customer.getName() + ", Numero di ordini: " + orderList.size());
        });
        System.out.println();

        // Esercizio #2: Calcolare il totale delle vendite per ogni cliente
        Map<Long, Double> totalSalesPerCustomer = calculateTotalSalesPerCustomer(orders);
        System.out.println("Esercizio #2 - Totale delle vendite per cliente:");
        totalSalesPerCustomer.forEach((customerId, totalSales) -> {
            System.out.println("Cliente ID: " + customerId + ", Totale vendite: " + totalSales);
        });
        System.out.println();

        // Esercizio #3: Trovare il prodotto più costoso
        Optional<Product> mostExpensiveProduct = findMostExpensiveProduct(orders);
        System.out.println("Esercizio #3 - Prodotto più costoso:");
        mostExpensiveProduct.ifPresent(product -> System.out.println("Prodotto: " + product.getName() + ", Prezzo: " + product.getPrice()));
        System.out.println();

        // Esercizio #4: Calcolare la media degli importi degli ordini
        double averageOrderAmount = calculateAverageOrderAmount(orders);
        System.out.println("Esercizio #4 - Media degli importi degli ordini: " + averageOrderAmount);
        System.out.println();

        // Esercizio #5: Raggruppare i prodotti per categoria e calcolare il totale delle vendite per ogni categoria
        Map<String, Double> totalSalesPerCategory = calculateTotalSalesPerCategory(orders);
        System.out.println("Esercizio #5 - Totale delle vendite per categoria:");
        totalSalesPerCategory.forEach((category, totalSales) -> {
            System.out.println("Categoria: " + category + ", Totale vendite: " + totalSales);
        });
    }

    private static List<Order> createSampleOrders() {
        // Questo è solo un esempio di dati di input
        List<Order> orders = new ArrayList<>();

        // Creazione di alcuni ordini di esempio
        Order order1 = new Order(1, "Completed", null, null, Arrays.asList(
                new Product(1, "Tastiera meccanica", "Accessori informatici", 99.99),
                new Product(2, "Mouse wireless", "Accessori informatici", 29.99)
        ), 1, "John Doe", 1);

        Order order2 = new Order(2, "Completed", null, null, Arrays.asList(
                new Product(3, "Monitor 27 pollici", "Monitor", 299.99),
                new Product(4, "Webcam HD", "Accessori informatici", 49.99)
        ), 2, "Jane Smith", 2);

        Order order3 = new Order(3, "Completed", null, null, Arrays.asList(
                new Product(5, "Laptop ultraleggero", "Computer portatili", 799.99),
                new Product(6, "Stampante multifunzione", "Stampanti", 199.99)
        ), 1, "John Doe", 1);
        Order order4 = new Order(4, "Completed", null, null, Arrays.asList(
                new Product(5, "Cavo USB-c", "Accessori informatici", 8.99),
                new Product(6, "Stampante multifunzione", "Stampanti", 199.99)
        ), 1, "John Doe", 1);

        orders.add(order1);
        orders.add(order2);
        orders.add(order3);

        return orders;
    }

    private static Map<OrderCustomer, List<Order>> groupOrdersByCustomer(List<Order> orders) {
        return orders.stream()
                .collect(Collectors.groupingBy(
                        order -> new OrderCustomer(order.getCustomerId(), order.getCustomerName(), order.getCustomerTier())
                ));
    }

    private static Map<Long, Double> calculateTotalSalesPerCustomer(List<Order> orders) {
        return orders.stream()
                .collect(Collectors.groupingBy(Order::getCustomerId,
                        Collectors.summingDouble(order -> order.getProducts().stream()
                                .mapToDouble(Product::getPrice).sum())));
    }

    private static Optional<Product> findMostExpensiveProduct(List<Order> orders) {
        return orders.stream()
                .flatMap(order -> order.getProducts().stream())
                .max(Comparator.comparingDouble(Product::getPrice));
    }

    private static double calculateAverageOrderAmount(List<Order> orders) {
        OptionalDouble average = orders.stream()
                .mapToDouble(order -> order.getProducts().stream()
                        .mapToDouble(Product::getPrice).sum())
                .average();
        return average.orElse(0);
    }

    private static Map<String, Double> calculateTotalSalesPerCategory(List<Order> orders) {
        return orders.stream()
                .flatMap(order -> order.getProducts().stream())
                .collect(Collectors.groupingBy(Product::getCategory,
                        Collectors.summingDouble(Product::getPrice)));
    }
}
