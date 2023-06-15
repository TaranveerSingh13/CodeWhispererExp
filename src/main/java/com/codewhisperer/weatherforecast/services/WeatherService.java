package com.codewhisperer.weatherforecast.services;

import java.net.URI;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriTemplate;
import com.codewhisperer.weatherforecast.Pojo.Weather;


@Service
public class WeatherService {

    private static final String WEATHER_URL =
            "http://api.openweathermap.org/data/2.5/weather?q={city},{country}&APPID={key}";
    private static final String API_KEY = "7e9ad5624bc8b72217fa9a98607f86f2";


    private static final String COUNTRY = "IN";

    private final RestTemplate restTemplate;

    public WeatherService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public Weather getWeather(String city) {
        URI uri = new UriTemplate(WEATHER_URL).expand(city, COUNTRY, API_KEY);
        return invoke(uri, Weather.class);
    }

    private <T> T invoke(URI url, Class<T> responseType) {
        RequestEntity<?> request = RequestEntity.get(url)
                .accept(MediaType.APPLICATION_JSON).build();
        ResponseEntity<T> response = restTemplate.exchange(request, responseType);
        return response.getBody();
    }

}
