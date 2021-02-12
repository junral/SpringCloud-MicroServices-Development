package xyz.junral.spring.cloud.weather.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import xyz.junral.spring.cloud.weather.service.DataClient;
import xyz.junral.spring.cloud.weather.service.WeatherReportService;
import xyz.junral.spring.cloud.weather.vo.Weather;
import xyz.junral.spring.cloud.weather.vo.WeatherResponse;

/**
 * 澶╂皵棰勬姤鏈嶅姟
 */
@Service
public class WeatherReportServiceImpl implements WeatherReportService {

	@Autowired
	private DataClient dataClient;

    @Override
    public Weather getDataByCityId(String cityId) {
        // TODO 鏀逛负鐢卞ぉ姘旀暟鎹瓵PI寰湇鍔℃潵鎻愪緵鏁版嵁
        WeatherResponse response = dataClient.getDataByCityId(cityId);
        return response.getData();
    }
}
