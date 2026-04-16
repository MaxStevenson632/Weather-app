package com.example.weatherapp.Backend.Controller;

import com.example.weatherapp.Backend.Models.CurrentWeatherResponse;
import com.example.weatherapp.Backend.Models.ForecastWeatherResponse;
import com.example.weatherapp.Backend.Repository.CityRepository;
import com.example.weatherapp.Backend.Service.CityService;
import com.example.weatherapp.Backend.Service.WeatherService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:63342")
public class WeatherController {

    private final WeatherService weatherService;
    private final CityService cityService;

    public WeatherController(WeatherService weatherService, CityService cityService) {
        this.weatherService = weatherService;
        this.cityService = cityService;
    }

    public record WeatherDashboard(CurrentWeatherResponse current, ForecastWeatherResponse forecast) {}

    @GetMapping("/weather")
    public WeatherDashboard getCurrentAndForecast(@RequestParam String location) {
        CurrentWeatherResponse current = weatherService.getCurrentWeather(location);
        ForecastWeatherResponse forecast = weatherService.getForecast(location);
        cityService.saveCity(location);

        return new WeatherDashboard(current, forecast);
    }
}
