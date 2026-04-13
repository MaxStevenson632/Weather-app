package com.example.weatherapp.Backend.Service;

import com.example.weatherapp.Backend.Models.ForecastWeatherResponse;
import com.example.weatherapp.Backend.Models.GeocodingResponse;
import com.example.weatherapp.Backend.Models.CurrentWeatherResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class WeatherService {

    @Value("${weather.api.key}")
    private String apiKey;

    @Value("${weather.api.current-url}")
    private String currentUrl;

    @Value("${weather.api.forecast-url}")
    private String forecastUrl;

    @Value("${weather.api.geo-url}")
    private String geoUrl;

    private final RestTemplate restTemplate;

    public WeatherService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public CurrentWeatherResponse getCurrentWeather(String location) {
        String url = UriComponentsBuilder.fromUriString(currentUrl)
                .queryParam("lat", getCoordinates(location).getLatitude())
                .queryParam("lon", getCoordinates(location).getLongitude())
                .queryParam("appid", apiKey)
                .queryParam("units", "metric")
                .toUriString();

        CurrentWeatherResponse response = restTemplate.getForObject(url, CurrentWeatherResponse.class);
        response.setName(location);
        return response;
    }

    public ForecastWeatherResponse getForecast(String location) {
        String url = UriComponentsBuilder.fromUriString(forecastUrl)
                .queryParam("lat", getCoordinates(location).getLatitude())
                .queryParam("lon", getCoordinates(location).getLongitude())
                .queryParam("appid", apiKey)
                .queryParam("units", "metric")
                .toUriString();

        ForecastWeatherResponse response = restTemplate.getForObject(url, ForecastWeatherResponse.class);
        response.setName(location);
        return response;
    }

    public GeocodingResponse getCoordinates(String location) {
        String url = UriComponentsBuilder.fromUriString(geoUrl)
                .queryParam("q", location)
                .queryParam("limit", 1)
                .queryParam("appid", apiKey)
                .toUriString();

        GeocodingResponse[] responses = new RestTemplate().getForObject(url, GeocodingResponse[].class);
        return responses[0];
    }
}
