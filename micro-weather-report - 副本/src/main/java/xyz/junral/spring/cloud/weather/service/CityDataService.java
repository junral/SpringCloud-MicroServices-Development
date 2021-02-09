package xyz.junral.spring.cloud.weather.service;

import xyz.junral.spring.cloud.weather.vo.City;

import java.util.List;

public interface CityDataService {

    /**
     * 获取城市列表
     * @return
     * @throws Exception
     */
    List<City> listCity() throws Exception;
}
