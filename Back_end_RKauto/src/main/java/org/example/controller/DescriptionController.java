package org.example.controller;

import org.example.model.Car;
import org.example.model.Description;

import org.example.service.DescriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/descriptions")
@CrossOrigin(origins = "*")

public class DescriptionController {

    @Autowired
    private DescriptionService descriptionService;

    // Récupérer toutes les descriptions
    @GetMapping
    public List<Description> getAllDescriptions() {
        return descriptionService.getDescription();
    }

    // Créer une nouvelle description
    @PostMapping
    public ResponseEntity<Description> createCar(@RequestBody Description description) {
        Description savedDescription =descriptionService.createDescription(description);
        return new ResponseEntity<>(savedDescription, HttpStatus.CREATED);
    }

    // Mettre à jour une description existante
    @PutMapping("/{id}")
    public ResponseEntity<Description> updateCar(@PathVariable Long id, @RequestBody Description descriptionDetails) {
        Description updateDescription = descriptionService.updateDescription(id, descriptionDetails);
        return new ResponseEntity<>(updateDescription, HttpStatus.OK);
    }

    // Supprimer une description
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCar(@PathVariable Long id) {
        descriptionService.deleteDescription(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
