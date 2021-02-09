package xyz.junral.spring.cloud.weather.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.junral.spring.cloud.weather.service.WeatherDataService;
import xyz.junral.spring.cloud.weather.service.WeatherReportService;
import xyz.junral.spring.cloud.weather.vo.Weather;
import xyz.junral.spring.cloud.weather.vo.WeatherResponse;

/**
 * 天气预报服务
 */
@Service
public class WeatherReportServiceImpl implements WeatherReportService {

    @Autowired
    private WeatherDataService weatherDataService;

    @Override
    public Weather getDataByCityId(String cityId) {
        WeatherResponse result = weatherDataService.getDataById(cityId);
    return result.getData();
    }
}
