package com.codewhisperer.weatherforecast.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.codewhisperer.weatherforecast.Pojo.Weather;
import com.codewhisperer.weatherforecast.services.WeatherService;


/**
 *
 */
@Controller
public class WeatherForecastController {
    @Value("${spring.application.name}")
    String appName;

    @Autowired WeatherService weatherService;

    @GetMapping("/")
    public String homePage() {
        return "home";
    }

    /**
     * @param model Model
     * @param location String
     * @return page String
     */
    @PostMapping("weather/local")
    public String getWeatherFromOpenApi(Model model, @RequestParam(name="location") String location) {
      Weather weather = this.weatherService.getWeather(location);
      model.addAttribute("weather", weather);
      return "home";
    }
}
