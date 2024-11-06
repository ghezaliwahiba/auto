package org.example.model;

import jakarta.persistence.*;

@Entity
@Table(name = "vehicules")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String kilometrage;
    private double prix;
    private String etat;
    private String path;

    // Constructeurs, getters et setters
    public Car() {}

    public Car(Long id, String title, String kilometrage, double prix, String etat, String path) {
        this.id = id;
        this.title = title;
        this.kilometrage = kilometrage;
        this.prix = prix;
        this.etat = etat;
        this.path = path;
    }

    // Getters et Setters...


    public void setId(Long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setKilometrage(String kilometrage) {
        this.kilometrage = kilometrage;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getKilometrage() {
        return kilometrage;
    }

    public double getPrix() {
        return prix;
    }

    public String getEtat() {
        return etat;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
