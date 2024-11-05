package edu.miu.apsd.q3vegatablegarden.service;

import edu.miu.apsd.q3vegatablegarden.model.Plant;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface PlantService {
    public Optional<Plant> savePlant(Plant plant);
    public Optional<Plant> getPlant(Integer plantId);
    public List<Plant> getAllPlants();
    public Optional<Plant> updatePlant(Plant plant);
    public Boolean deletePlant(Integer plantId);
    public List<Plant> getAllPlantsOrderByName();
    public List<Plant> getAllPlantsOrderByPlantDate();
}
