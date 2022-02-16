package com.example.kiemtramd4.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
public class Nation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idNation;
    private String nameNation;

}
