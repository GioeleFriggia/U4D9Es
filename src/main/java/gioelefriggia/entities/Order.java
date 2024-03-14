package entities;

import java.time.LocalDate;
import java.util.List;

// Definizione della classe Order
public class Order {
    // Attributi della classe Order
    private long id; // ID dell'ordine
    private String status; // Stato dell'ordine
    private LocalDate orderDate; // Data di creazione dell'ordine
    private LocalDate deliveryDate; // Data di consegna dell'ordine
    private List<Product> products; // Elenco dei prodotti nell'ordine
    private long customerId; // ID del cliente associato all'ordine
    private String customerName; // Nome del cliente associato all'ordine
    private Integer customerTier; // Livello del cliente associato all'ordine

    // Costruttore per inizializzare un oggetto Order con i dati forniti
    public Order(long id, String status, LocalDate orderDate, LocalDate deliveryDate, List<Product> products, long customerId, String customerName, Integer customerTier) {
        this.id = id;
        this.status = status;
        this.orderDate = orderDate;
        this.deliveryDate = deliveryDate;
        this.products = products;
        this.customerId = customerId;
        this.customerName = customerName;
        this.customerTier = customerTier;
    }

    // Metodi getter per ottenere i valori degli attributi
    public long getId() {
        return id;
    }

    public String getStatus() {
        return status;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public LocalDate getDeliveryDate() {
        return deliveryDate;
    }

    public List<Product> getProducts() {
        return products;
    }

    public long getCustomerId() {
        return customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public Integer getCustomerTier() {
        return customerTier;
    }

    // Metodo toString per rappresentare l'oggetto Order come una stringa
    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", status='" + status + '\'' +
                ", orderDate=" + orderDate +
                ", deliveryDate=" + deliveryDate +
                ", products=" + products +
                ", customerId=" + customerId +
                ", customerName='" + customerName + '\'' +
                ", customerTier=" + customerTier +
                '}';
    }
}
