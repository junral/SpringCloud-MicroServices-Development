package xyz.junral.spring.cloud.weather.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import xyz.junral.spring.cloud.weather.service.WeatherDataService;
import xyz.junral.spring.cloud.weather.vo.WeatherResponse;

import java.io.IOException;

/**
 * 天气数据服务
 */
@Service
public class WeatherDataServiceImpl implements WeatherDataService {

    @Autowired
    private RestTemplate restTemplate;

    private final String WEATHER_API = "http://wthrcdn.etouch.cn/weather_mini";

    @Override
    public WeatherResponse getDataById(String cityId) {
        String uri = WEATHER_API + "?citykey=" + cityId;
        return this.doGetWeatherData(uri);
    }

    @Override
    public WeatherResponse getDataByCityName(String cityName) {
        String uri = WEATHER_API + "?city=" + cityName;
        return doGetWeatherData(uri);
    }

    private WeatherResponse doGetWeatherData(String uri) {
        ResponseEntity<String> response = restTemplate.getForEntity(uri, String.class);
        String strBody = null;
        if (response.getStatusCodeValue() == 200) {
            strBody = response.getBody();
        }
        ObjectMapper mapper = new ObjectMapper();
        WeatherResponse weather = null;
        try{
            weather = mapper.readValue(strBody, WeatherResponse.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return weather;
    }
}
