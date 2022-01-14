package com.exercice.formation.models.invoice;

public enum TypeTVA {
    NORMAL(20), DIX(10), CINQ(5.5), DEUX(2), ZERO(0);

    private final double somme;

    TypeTVA(double somme) {
        this.somme = somme;
    }

    public double getSomme(){
        return somme;
    }
}
