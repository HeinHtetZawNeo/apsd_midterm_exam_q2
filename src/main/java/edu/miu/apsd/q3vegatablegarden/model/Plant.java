package edu.miu.apsd.q3vegatablegarden.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Plant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String type;
    private LocalDate plantDate;

    @ManyToOne
    @JoinColumn(name="garden_id")
    private Garden garden;

    public Plant(String name, String type, LocalDate plantDate,Garden garden) {
        this.name = name;
        this.type = type;
        this.plantDate = plantDate;
        this.garden = garden;
    }

    @Override
    public String toString() {
        return "ID: " + id +
                ", Name: " + name +
                ", Type: " + type +
                ", Plant Date: " + plantDate +
                ", Garden: " + garden.getName();
    }
}
