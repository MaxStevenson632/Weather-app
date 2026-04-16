package com.example.weatherapp.Backend.Repository;

import com.example.weatherapp.Backend.Entity.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CityRepository extends JpaRepository<City, String> {

    @Query("SELECT c.name, COUNT(c.name) as cityCount FROM City c GROUP BY c.name ORDER BY cityCount DESC")
    List<String> findTopCities(Pageable pageable);
}
