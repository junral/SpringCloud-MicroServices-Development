package xyz.junral.spring.cloud.weather.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import xyz.junral.spring.cloud.weather.service.CityClient;
import xyz.junral.spring.cloud.weather.service.WeatherDataClient;
import xyz.junral.spring.cloud.weather.service.WeatherReportService;
import xyz.junral.spring.cloud.weather.vo.Forecast;
import xyz.junral.spring.cloud.weather.vo.Weather;
import xyz.junral.spring.cloud.weather.vo.WeatherResponse;

import java.util.ArrayList;
import java.util.List;

/**
 * 澶╂皵棰勬姤鏈嶅姟
 */
@Service
public class WeatherReportServiceImpl implements WeatherReportService {

	@Autowired
	private WeatherDataClient weatherDataClient;

    @Override
    public Weather getDataByCityId(String cityId) {
        // TODO 鏀逛负鐢卞ぉ姘旀暟鎹瓵PI寰湇鍔℃潵鎻愪緵鏁版嵁
        WeatherResponse response = weatherDataClient.getDataByCityId(cityId);
        return response.getData();
    }
}
