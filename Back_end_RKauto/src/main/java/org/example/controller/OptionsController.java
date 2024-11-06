package org.example.controller;

import org.example.model.Options; // Assurez-vous que le modèle Option est bien défini
import org.example.service.OptionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/options")
@CrossOrigin(origins = "*")
public class OptionsController {

    @Autowired
    private OptionsService optionsService;

    // Récupérer toutes les options
    @GetMapping
    public List<Options> getAllOptions() {
        return optionsService.getAllOptions();
    }

    // Créer une nouvelle option
    @PostMapping
    public Options createOption(@RequestBody Options option) {
        return optionsService.createOption(option);
    }

    // Mettre à jour une option existante
    @PutMapping("/{id}")
    public Options updateOption(@PathVariable Long id, @RequestBody Options optionDetails) {
        return optionsService.updateOption(id, optionDetails);
    }

    // Supprimer une option
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOption(@PathVariable Long id) {
        optionsService.deleteOption(id);
        return ResponseEntity.noContent().build(); // Retourner un code 204 No Content
    }
}
