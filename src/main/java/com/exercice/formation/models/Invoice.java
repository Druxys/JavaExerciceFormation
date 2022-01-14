package com.exercice.formation.models;


import com.exercice.formation.models.invoice.StatePayement;
import com.exercice.formation.models.invoice.TypeInvoice;
import com.exercice.formation.models.invoice.TypePayement;
import com.exercice.formation.models.invoice.TypeTVA;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

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
    @JoinColumn(name = "customer_id", referencedColumnName = "id")
    private Customer customer;
    private TypeTVA tva;
    private double tva2;
    private TypePayement typePayement;
    private double total;
    private double tvaPrice;
    private LocalDate date;

    public Invoice(double price, String description, Customer customer, TypeTVA tva, double tva2, double tvaPrice, double total, LocalDate date) {
        this.price = price;
        this.description = description;
        this.customer = customer;
        this.tva2 = tva2;
        this.tva = tva;
        this.total = total;
        this.tvaPrice = tvaPrice;
        this.date = date;
    }

    public Invoice(){}

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

    public TypeTVA getTva() {
        return tva;
    }

    public void setTva(TypeTVA tva) {
        this.tva = tva;
    }

    public TypePayement getTypePayement() {
        return typePayement;
    }

    public void setTypePayement(TypePayement typePayement) {
        this.typePayement = typePayement;
    }

    public double getTotal(){
        return total;
    }
    public void setTotal(double total){
        this.total = total;
    }

    public double getTva2(){
        return tva2;
    }
    public void setTva2(double tva2){
        this.tva2 = tva2;
    }

    public double getTvaPrice(){
        return tvaPrice;
    }
    public void setTvaPrice(double tvaPrice){
        this.tvaPrice = tvaPrice;
    }

    public LocalDate getDate(){
        return date;
    }
    public void setDate(LocalDate date){
        this.date = date;
    }
}
