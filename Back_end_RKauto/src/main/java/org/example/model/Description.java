package org.example.model;

import jakarta.persistence.*;
@Entity
@Table(name = "descriptions")
public class Description {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String texte;

    @ManyToOne
    @JoinColumn(name = "vehicule_id")
    private Car car;

    // Getters and Setters


    public Long getId() {
        return id;
    }

    public String getTexte() {
        return texte;
    }

    public Car getCar() {
        return car;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTexte(String texte) {
        this.texte = texte;
    }

    public void setCar(Car car) {
        this.car = car;
    }
}
