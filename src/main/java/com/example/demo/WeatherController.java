package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping(path = "/weather")
@CrossOrigin(origins = "https://spring-training.azureedge.net")
public class WeatherController {

    private final WeatherRepository weatherRepository;

    public WeatherController(WeatherRepository weatherRepository) {
        this.weatherRepository = weatherRepository;
    }

    @GetMapping("/city")
    public @ResponseBody Weather getWeatherForCity(@RequestParam String name) {
        return weatherRepository.findById(name).map(weather -> {
            weather.setDescription("It's always sunny on Azure Spring Apps");
            weather.setIcon("weather-sunny");
            return weather;
        }).get();
    }
}