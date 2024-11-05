package edu.miu.apsd.q3vegatablegarden.service;

import edu.miu.apsd.q3vegatablegarden.model.Plant;
import edu.miu.apsd.q3vegatablegarden.repository.PlantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlantServiceImpl implements PlantService {

    @Autowired
    private PlantRepository plantRepo;
    @Override
    public Optional<Plant> savePlant(Plant plant) {
        return Optional.of(plantRepo.save(plant));
    }

    @Override
    public Optional<Plant> getPlant(Integer plantId) {
        return plantRepo.findById(plantId);
    }

    @Override
    public List<Plant> getAllPlants() {
        return plantRepo.findAll();
    }

    @Override
    public Optional<Plant> updatePlant(Plant plant) {
        return Optional.of(plantRepo.save(plant));
    }

    @Override
    public Boolean deletePlant(Integer plantId) {
        try{
            Optional<Plant> plant = plantRepo.findById(plantId);
            if(plant.isPresent()) {
                plantRepo.deleteById(plantId);
                return true;
            }
        }catch (Exception e){
            return false;
        }
        return false;
    }

    @Override
    public List<Plant> getAllPlantsOrderByName() {
        return plantRepo.findAllByOrderByName();
    }

    @Override
    public List<Plant> getAllPlantsOrderByPlantDate() {
        return plantRepo.findAllByOrderByPlantDate();
    }
}
