package org.example.controller;
import org.example.model.Description;
import org.example.model.images;
import org.example.service.ImagesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/images")
@CrossOrigin(origins = "*")
public class ImagesController {


    @Autowired
    private ImagesService imagesService;

    // Récupérer toutes les images
    @GetMapping
    public List<images> getAllImages() {
        return imagesService.getAllImages();
    }

    // Créer une nouvelle image
    @PostMapping
    public ResponseEntity<images> createImage(@RequestBody images image) {
        images savedImage = imagesService.createImage(image);
        return new ResponseEntity<>(savedImage, HttpStatus.CREATED);
    }


    // Mettre à jour une image existante
    @PutMapping("/{id}")
    public ResponseEntity<images> updateCar(@PathVariable Long id, @RequestBody images imageDetails) {
        images updateDescription = imagesService.updateDescription(id, imageDetails);
        return new ResponseEntity<>(updateDescription, HttpStatus.OK);
    }

    // Supprimer une images
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCar(@PathVariable Long id) {
        imagesService.deleteDescription(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
