package gioelefriggia.entities;

public class OrderCustomer {
    // Attributi della classe OrderCustomer
    private long id; // ID del cliente dell'ordine
    private String name; // Nome del cliente dell'ordine
    private Integer tier; // Livello del cliente dell'ordine

    // Costruttore per inizializzare un oggetto OrderCustomer con i dati forniti
    public OrderCustomer(long id, String name, Integer tier) {
        this.id = id;
        this.name = name;
        this.tier = tier;
    }

    // Metodo getter per ottenere il nome del cliente dell'ordine
    public String getName() {
        return name;
    }

    // Metodo getter per ottenere il livello del cliente dell'ordine
    public Integer getTier() {
        return tier;
    }
}
