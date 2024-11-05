package edu.miu.apsd.q3vegatablegarden.service;

import edu.miu.apsd.q3vegatablegarden.model.Garden;
import edu.miu.apsd.q3vegatablegarden.repository.GardenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GardenServiceImpl implements GardenService {
    @Autowired
    GardenRepository gardenRepo;

    @Override
    public Optional<Garden> saveGarden(Garden garden) {
        return Optional.of(gardenRepo.save(garden));
    }

    @Override
    public Optional<Garden> updateGarden(Garden garden) {
        return Optional.of(gardenRepo.save(garden));
    }

    @Override
    public Optional<Garden> getGarden(Integer gardenId) {
        return gardenRepo.findById(gardenId);
    }

    @Override
    public List<Garden> getAllGardens() {
        return gardenRepo.findAll();
    }

    @Override
    public Boolean deleteGarden(Integer gardenId) {
        try{
            Optional<Garden> garden = gardenRepo.findById(gardenId);
            if(garden.isPresent()) {
                gardenRepo.deleteById(gardenId);
                return true;
            }
        }catch (Exception e) {
            return false;
        }
        return false;
    }
}
