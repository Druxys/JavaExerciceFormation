package models;

import lombok.Getter;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name = "invoice")
public class Invoice implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private TypeInvoice type;
    private int number_candidat;
    private double price;
    private StatePayement statePayement;
    private String description;
    private int reference;
    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TypeInvoice getType() {
        return type;
    }

    public void setType(TypeInvoice type) {
        this.type = type;
    }

    public int getNumber_candidat() {
        return number_candidat;
    }

    public void setNumber_candidat(int number_candidat) {
        this.number_candidat = number_candidat;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getReference() {
        return reference;
    }

    public void setReference(int reference) {
        this.reference = reference;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public StatePayement getStatePayement() {
        return statePayement;
    }

    public void setStatePayement(StatePayement statePayement) {
        this.statePayement = statePayement;
    }
}
