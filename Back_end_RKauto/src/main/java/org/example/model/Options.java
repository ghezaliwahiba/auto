package org.example.model;

import jakarta.persistence.*;

@Entity
@Table(name = "options")
public class Options {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;

    @ManyToOne
    @JoinColumn(name = "vehicule_id")
    private Car car;

    // Getters and Setters


    public Long getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public Car getCar() {
        return car;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setCar(Car car) {
        this.car = car;
    }
}