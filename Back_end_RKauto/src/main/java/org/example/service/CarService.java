package org.example.service;

import org.example.model.Car;
import org.example.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class CarService {

    @Autowired
    private CarRepository carRepository;

    // Récupérer toutes les voitures
    public List<Car> getAllCars() {
        return carRepository.findAll();
    }

    // Créer une nouvelle voiture
    public Car createCar(Car car) {
        try {
            return carRepository.save(car);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Erreur lors de la création de la voiture", e);
        }
    }

    // Mettre à jour une voiture existante
    public Car updateCar(Long id, Car carDetails) {
        Car car = carRepository.findById(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "Voiture non trouvée")
        );

        car.setTitle(carDetails.getTitle());
        car.setKilometrage(carDetails.getKilometrage());
        car.setPrix(carDetails.getPrix());
        car.setEtat(carDetails.getEtat());

        return carRepository.save(car);
    }

    // Supprimer une voiture
    public void deleteCar(Long id) {
        try {
            carRepository.deleteById(id);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Erreur lors de la suppression de la voiture", e);
        }
    }
}

