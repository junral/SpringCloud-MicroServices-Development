package xyz.junral.spring.cloud.weather.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.junral.spring.cloud.weather.service.WeatherDataService;
import xyz.junral.spring.cloud.weather.vo.WeatherResponse;

@RestController
@RequestMapping("/weather")
public class WeatherController {

    @Autowired
    private WeatherDataService weatherDataService;

    @GetMapping("/cityId/{cityId}")
    public WeatherResponse getResponseByCityId(@PathVariable("cityId") String cityId) {
        return weatherDataService.getDataById(cityId);
    }

    @GetMapping("/cityName/{cityName}")
    public WeatherResponse getResponseByCityName(@PathVariable("cityName") String cityName) {
        return weatherDataService.getDataByCityName(cityName);
    }
}
