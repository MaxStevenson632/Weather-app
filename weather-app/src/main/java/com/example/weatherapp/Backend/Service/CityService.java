package com.example.weatherapp.Backend.Service;

import com.example.weatherapp.Backend.Entity.City;
import com.example.weatherapp.Backend.Repository.CityRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityService {

    CityRepository cityRepository;

    public CityService(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    public void saveCity(String location)  {

        // Create new instance for a new row
        City city = new City();
        city.setName(location);
        cityRepository.save(city);
    }

    public List<String> getTopFiveCities() {
        return cityRepository.findTopCities(PageRequest.of(0, 5));
    }
}