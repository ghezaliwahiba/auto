package org.example.service;
import org.example.model.Options;
import org.example.repository.OptionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class OptionsService {

    @Autowired
    private OptionsRepository optionRepository;

    // Récupérer toutes les options
    public List<Options> getAllOptions() {
        return optionRepository.findAll();
    }

    // Créer une nouvelle option
    public Options createOption(Options option) {
        try {
            return optionRepository.save(option);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Erreur lors de la création de l'option", e);
        }
    }

    // Mettre à jour une option existante
    public Options updateOption(Long id, Options
            optionDetails) {
        Options option = optionRepository.findById(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "Voiture non trouvée")
        );

        option.setNom(optionDetails.getNom());
        option.setCar(optionDetails.getCar());

        return optionRepository.save(option);
    }

    // Supprimer une option
    public void deleteOption(Long id) {
        try {
            optionRepository.deleteById(id);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Erreur lors de la suppression de l'option", e);
        }
    }
}