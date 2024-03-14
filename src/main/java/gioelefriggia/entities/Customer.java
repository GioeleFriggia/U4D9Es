package gioelefriggia.entities;

// Definizione della classe Customer
public class Customer {
    // Attributi della classe Customer
    private long id; // ID del cliente
    private String name; // Nome del cliente
    private Integer tier; // Livello del cliente

    // Costruttore per inizializzare un oggetto Customer con i dati forniti
    public Customer(long id, String name, Integer tier) {
        this.id = id;
        this.name = name;
        this.tier = tier;
    }

    // Metodi getter per ottenere i valori degli attributi
    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getTier() {
        return tier;
    }
}
