package com.example.weatherapp.Backend.Models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MainData {

    private float temp;
    private int humidity;
    private float feels_like;

    public void setTemp(float temp) {
        this.temp = temp;
    }

    public float getTemp() {
        return this.temp;
    }

    public void setHumidity(int humidity) {
        this.humidity = humidity;
    }

    public int getHumidity() {
        return this.humidity;
    }

    public void setFeels_like(float feels_like) {
        this.feels_like = feels_like;
    }

    public float getFeels_like() {
        return this.feels_like;
    }
}
