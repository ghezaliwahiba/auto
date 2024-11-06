package org.example.service;
import org.example.model.images;

import org.example.repository.ImagesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class ImagesService {

    @Autowired
    private ImagesRepository imagesRepository;

    // Récupérer toutes les images
    public List<images> getAllImages() {
        return imagesRepository.findAll();
    }

    // Créer une nouvelle image
    public images createImage(images image) {
        try {
            return imagesRepository.save(image);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Erreur lors de la création de l'image", e);
        }
    }

    // Mettre à jour une image existante
    public images updateImage(Long id, images imagesDetails) {
        images image = imagesRepository.findById(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "Image non trouvée")
        );

        image.setPath(imagesDetails.getPath());


        return imagesRepository.save(image);
    }

    // Supprimer une image
    public void deleteImage(Long id) {
        try {
            imagesRepository.deleteById(id);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Erreur lors de la suppression d'image", e);
        }
    }

}
