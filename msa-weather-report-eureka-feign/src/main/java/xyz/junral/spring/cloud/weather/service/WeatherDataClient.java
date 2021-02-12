package xyz.junral.spring.cloud.weather.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import xyz.junral.spring.cloud.weather.vo.WeatherResponse;

/**
 * 访问天气数据客户端
 * @author Junral
 *
 */
@FeignClient("msa-weather-data-eureka")
public interface WeatherDataClient {

	@GetMapping("/weather/cityId/{cityId}")
	public WeatherResponse getDataByCityId(@PathVariable("cityId") String cityId);
}
