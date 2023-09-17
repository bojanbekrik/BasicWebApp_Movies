package com.example.crudmovies.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
public class Movies {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String mainActor;

    public Movies(int id, String name, String mainActor) {
        this.id = id;
        this.name = name;
        this.mainActor = mainActor;
    }

    public Movies() {
    }
}
