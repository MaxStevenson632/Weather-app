package com.example.weatherapp.Backend.Models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class GeocodingResponse {

    private String location;

    @JsonProperty("lat")
    private float latitude;

    @JsonProperty("lon")
    private float longitude;

    public void setLocation(String location) {
        this.location = location;
    }

    public String getLocation() {
        return this.location;
    }

    public void setLatitude(float latitude) {
        this.latitude = latitude;
    }

    public float getLatitude() {
        return latitude;
    }

    public void setLongitude(float longitude) {
        this.longitude = longitude;
    }

    public float getLongitude() {
        return longitude;
    }
}
