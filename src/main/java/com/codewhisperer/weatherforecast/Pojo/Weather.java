package com.codewhisperer.weatherforecast.Pojo;

import java.io.Serializable;
import java.time.Instant;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;


/**
 * weather api response object
 */
public class Weather implements Serializable {

    private Instant timestamp;

    private double temperature;

    private Integer weatherId;

    private String weatherIcon;

    @JsonProperty("timestamp")
    public Instant getTimestamp() {
        return timestamp;
    }

    @JsonSetter("dt")
    public void setTimestamp(final Instant timestamp) {
        this.timestamp = timestamp;
    }

    @JsonProperty("main")
    public void setMain(Map<String, Object> main) {
        setTemperature(Double.parseDouble(main.get("temp").toString()));
    }
    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(final double temperature) {
        this.temperature = temperature;
    }

    public Integer getWeatherId() {
        return weatherId;
    }

    public void setWeatherId(final Integer weatherId) {
        this.weatherId = weatherId;
    }

    public String getWeatherIcon() {
        return weatherIcon;
    }

    public void setWeatherIcon(final String weatherIcon) {
        this.weatherIcon = weatherIcon;
    }

    @JsonProperty("weather")
    public void setWeather(List<Map<String, Object>> weatherEntries) {
        Map<String, Object> weather = weatherEntries.get(0);
        setWeatherId((Integer) weather.get("id"));
        setWeatherIcon((String) weather.get("icon"));
    }
}
