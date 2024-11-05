package edu.miu.apsd.q3vegatablegarden.repository;

import edu.miu.apsd.q3vegatablegarden.model.Plant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlantRepository extends JpaRepository<Plant, Integer> {
    public List<Plant> findAllByOrderByName();
    public List<Plant> findAllByOrderByPlantDate();
}
