package com.example.weatherapp.Backend.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;

    public City() {}

    public City(String name) {
        this.id = id;
        this.name = name;
    }

    public long getId() { return this.id; }

    public void setId(long id) { this.id = id; }

    public String getName() { return this.name; }

    public void setName(String name) { this.name = name; }
}
