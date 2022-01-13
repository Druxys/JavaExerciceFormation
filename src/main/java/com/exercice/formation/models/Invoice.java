package com.exercice.formation.models;

import com.exercice.formation.models.invoice.StatePayement;
import com.exercice.formation.models.invoice.TypeInvoice;

import javax.persistence.*;

@Entity(name = "invoice")
public class Invoice {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private TypeInvoice type;
    private int numberCandidat;
    private double price;
    private StatePayement statePayement;
    private String description;
    private int reference;
    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    public Invoice() {
    }

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

    public int getNumberCandidat() {
        return numberCandidat;
    }

    public void setNumberCandidat(int numberCandidat) {
        this.numberCandidat = numberCandidat;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public StatePayement getStatePayement() {
        return statePayement;
    }

    public void setStatePayement(StatePayement statePayement) {
        this.statePayement = statePayement;
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

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
