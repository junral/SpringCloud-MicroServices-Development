package xyz.junral.spring.cloud.weather.service;

import xyz.junral.spring.cloud.weather.vo.Weather;

public interface WeatherReportService {

    public Weather getDataByCityId(String cityId);

}
