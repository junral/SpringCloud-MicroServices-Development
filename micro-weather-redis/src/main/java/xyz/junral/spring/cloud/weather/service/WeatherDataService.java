package xyz.junral.spring.cloud.weather.service;

import xyz.junral.spring.cloud.weather.vo.WeatherResponse;

/**
 * 天气数据服务
 */
public interface WeatherDataService {

    /**
     * 根据城市ID来查询天气数据
     * @param cityId
     * @return
     */
    WeatherResponse getDataById(String cityId);

    /**
     * 根据城市名称来查询天气数据
     * @param cityName
     * @return
     */
    WeatherResponse getDataByCityName(String cityName);
}
