package com.example.weatherapp.Backend.Controller;

import com.example.weatherapp.Backend.Entity.City;
import com.example.weatherapp.Backend.Repository.CityRepository;
import com.example.weatherapp.Backend.Service.CityService;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cities")
@CrossOrigin(origins = "http://localhost:63342")
public class CityController {

    private final CityService cityService;

    public CityController(CityService cityService) { this.cityService = cityService; }

    @GetMapping()
    public List<String> getTopFiveCities() {
        return cityService.getTopFiveCities();
    }
}
