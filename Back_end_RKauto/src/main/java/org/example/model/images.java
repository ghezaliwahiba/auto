package org.example.model;

import jakarta.persistence.*;

@Entity
@Table(name = "images")
public class images {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "path", nullable = false)
    private String path; // Chemin d'accès à l'image sur le disque

    @ManyToOne
    @JoinColumn(name = "vehicule_id", nullable = false)
    private Car car;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Car getVehicule() {
        return car;
    }

    public void setVehicule(Car car) {
        this.car = car;
    }
}