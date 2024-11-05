package edu.miu.apsd.q3vegatablegarden.service;

import edu.miu.apsd.q3vegatablegarden.model.Garden;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface GardenService {
    public Optional<Garden> saveGarden(Garden garden);
    public Optional<Garden> updateGarden(Garden garden);
    public Optional<Garden> getGarden(Integer gardenId);
    public List<Garden> getAllGardens();
    public Boolean deleteGarden(Integer gardenId);
}
