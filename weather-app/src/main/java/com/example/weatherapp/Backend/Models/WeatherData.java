package com.example.weatherapp.Backend.Models;

public class WeatherData {

    private String main;
    private String description;

    public void setMain(String main) {
        this.main = main;
    }

    public String getMain() {
        return this.main;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return this.description;
    }

}
