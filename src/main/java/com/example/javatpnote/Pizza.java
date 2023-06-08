package com.example.javatpnote;

public class Pizza {
    private String recette;
    private String id;
    private double prix;
    private int nb_ing;

    public Pizza(String recette, double prix, int nb_ing) {
        this.recette = recette;
        this.prix = prix;
        this.nb_ing = nb_ing;
    }

    public Pizza(){}

    public String getRecette() {
        return recette;
    }

    public void setRecette(String recette) {
        this.recette = recette;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public int getNb_ing() {
        return nb_ing;
    }

    public void setNb_ing(int nb_ing) {
        this.nb_ing = nb_ing;
    }
}
