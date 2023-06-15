package com.codewhisperer.weatherforecast.controllers;

import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;


public class WeatherForecastControllerTest {


    WeatherForecastController weatherForecastController = new WeatherForecastController();
    @Test
    public void testHomePage() {
        Assert.hasText(weatherForecastController.homePage(), "home");
    }



}
