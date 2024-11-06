package org.example.service;
import org.example.model.Description;
import org.example.repository.DescriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service

public class DescriptionService {


    @Autowired
    private DescriptionRepository descriptionRepository;

    // Récupérer toutes les descritpion
    public List<Description> getDescription() {
        return descriptionRepository.findAll();
    }

    // Créer une nouvelle description
    public Description createDescription(Description description) {
        try {
            return descriptionRepository.save(description
            );
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Erreur lors de la création de la voiture", e);
        }
    }

    // Mettre à jour une description existante
    public Description updateDescription(Long id, Description descriptionDetails) {
        Description description = descriptionRepository.findById(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "Description non trouvée")
        );

        description.setTexte(descriptionDetails.getTexte());

        return descriptionRepository.save(description);
    }

    // Supprimer une description
    public void deleteDescription(Long id) {
        try {
            descriptionRepository.deleteById(id);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Erreur lors de la suppression de la description", e);
        }
    }

}
