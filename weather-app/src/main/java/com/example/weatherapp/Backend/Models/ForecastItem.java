package com.example.weatherapp.Backend.Models;

import java.util.List;

public class ForecastItem {

    private MainData main;
    private List<WeatherData> weather;
    private WindData wind;
    private String dt_txt;

    public MainData getMain() {
        return main;
    }

    public void setMainData(MainData main) {
        this.main = main;
    }

    public List<WeatherData> getWeather() {
        return weather;
    }

    public void setWeatherData(List<WeatherData> weather) {
        this.weather = weather;
    }

    public WindData getWind() {
        return wind;
    }

    public void setWindData(WindData wind) {
        this.wind = wind;
    }

    public String getDt_txt() { return dt_txt; }

    public void setDt_txt(String dt_txt) { this.dt_txt = dt_txt; }
}
