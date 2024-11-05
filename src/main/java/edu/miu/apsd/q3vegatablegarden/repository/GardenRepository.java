package edu.miu.apsd.q3vegatablegarden.repository;

import edu.miu.apsd.q3vegatablegarden.model.Garden;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GardenRepository extends JpaRepository<Garden,Integer> {
}
