package com.example.weatherapp.Backend.Models;

import java.util.List;

public class CurrentWeatherResponse {

    private String name;
    private MainData main;
    private List<WeatherData> weather;
    private WindData wind;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setMain(MainData main) {
        this.main = main;
    }

    public MainData getMain() {
        return this.main;
    }

    public void setWeather(List<WeatherData> weather) {
        this.weather = weather;
    }

    public List<WeatherData> getWeather() {
        return this.weather;
    }

    public void setWind(WindData wind) {
        this.wind = wind;
    }

    public WindData getWind() {
        return this.wind;
    }

}
