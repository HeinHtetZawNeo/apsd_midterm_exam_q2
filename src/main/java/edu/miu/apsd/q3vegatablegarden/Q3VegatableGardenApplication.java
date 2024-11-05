package edu.miu.apsd.q3vegatablegarden;

import edu.miu.apsd.q3vegatablegarden.model.Garden;
import edu.miu.apsd.q3vegatablegarden.model.Plant;
import edu.miu.apsd.q3vegatablegarden.service.GardenService;
import edu.miu.apsd.q3vegatablegarden.service.PlantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@SpringBootApplication
public class Q3VegatableGardenApplication {

    @Autowired
    GardenService gardenService;

    @Autowired
    PlantService plantService;

    public static void main(String[] args) {
        SpringApplication.run(Q3VegatableGardenApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(ApplicationContext ctx) {
        return args -> {
            Optional<Garden> garden1 = gardenService.saveGarden(new Garden("Vegetable",50.0));
            plantService.savePlant(new Plant("Tomato","Vegetable", LocalDate.of(2024,3,10),garden1.get()));
            plantService.savePlant(new Plant("Carrot","Vegetable", LocalDate.of(2024,2,20),garden1.get()));

            Optional<Garden> garden2 = gardenService.saveGarden(new Garden("Herb Garden",20.0));
            plantService.savePlant(new Plant("Basil","Herb",LocalDate.of(2024,4,5),garden2.get()));

            System.out.println("Display All Gardens:");
            System.out.println("Gardens:");
            gardenService.getAllGardens().forEach(System.out::println);

            System.out.println("Display All Plants (Sort by Name):");
            System.out.println("Plants (Sorted by Name):");
            plantService.getAllPlantsOrderByName().forEach(System.out::println);

            System.out.println("Display All Plants (Sort By Plant Date):");
            System.out.println("Plants (Sorted by Plant Date):");
            plantService.getAllPlantsOrderByPlantDate().forEach(System.out::println);

            System.out.println("Add a new plant (Rosemary in Herb Garden)");
            plantService.savePlant(new Plant("Rosemary","Herb",LocalDate.of(2024,10,5),garden2.get()));
            plantService.getAllPlants().forEach(System.out::println);

            System.out.println("Change Tomato type to \"Fruit\"");
            plantService.getPlant(1).ifPresent(p->{p.setType("Fruit");plantService.updatePlant(p);});
            plantService.getAllPlants().forEach(System.out::println);

            System.out.println("Delete a plant (remove Carrot):");
            plantService.deletePlant(2);
            plantService.getAllPlants().forEach(System.out::println);
        };
    }

}
