package com.example.weatherapp.Backend.Models;

import java.util.List;

public class ForecastWeatherResponse {

    private List<ForecastItem> list;
    public String name;

    public List<ForecastItem> getList() {
        return this.list;
    }

    public void setList(List<ForecastItem> list) {
        this.list = list;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
