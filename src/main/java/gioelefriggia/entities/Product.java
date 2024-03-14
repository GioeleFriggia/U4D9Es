
package gioelefriggia.entities;


public class Product {
    // Attributi della classe Product
    private long id; // ID del prodotto
    private String name; // Nome del prodotto
    private String category; // Categoria del prodotto
    private double price; // Prezzo del prodotto

    // Costruttore per inizializzare un oggetto Product con i dati forniti
    public Product(long id, String name, String category, double price) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.price = price;
    }

    // Metodi getter per ottenere i valori degli attributi
    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public double getPrice() {
        return price;
    }

    // Metodo toString per rappresentare l'oggetto Product come una stringa
    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", category='" + category + '\'' +
                ", price=" + price +
                '}';
    }
}
