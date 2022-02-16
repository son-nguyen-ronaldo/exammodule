package com.example.kiemtramd4.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
//    @NotBlank
//    @Size(min = 3, max = 20)
    private String nameCity;
//    @NotBlank
//    @Min(0)
    private int area;
//    @NotBlank
//    @Min(0)
    private int population;
//    @NotBlank
//    @Min(0)
    private double gdp;
//    @NotBlank
    private String description;

    @ManyToOne
    private Nation nation;

}
