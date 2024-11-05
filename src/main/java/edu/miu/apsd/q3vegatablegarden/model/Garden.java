package edu.miu.apsd.q3vegatablegarden.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Garden {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private Double size;
//
//    @OneToMany
//    @JoinColumn(name="garden_id")
//    private List<Plant> plants;

//    public Garden(String name, Double size, List<Plant> plants) {
//        this.name = name;
//        this.size = size;
//        this.plants = plants;
//    }

    public Garden(String name, Double size) {
        this.name = name;
        this.size = size;
    }

    @Override
    public String toString() {
        return "ID: " + id +
                ", Name: " + name +
                ", Size:" + size +
                "m\u00B2";
    }
}
