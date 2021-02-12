package xyz.junral.spring.cloud.weather.service;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import xyz.junral.spring.cloud.weather.vo.City;
import xyz.junral.spring.cloud.weather.vo.WeatherResponse;

/**
 * 访问数据的客户端
 * @author Junral
 *
 */
@FeignClient("msa-weather-eureka-client-gateway")
public interface DataClient {

	/**
	 * 获取城市列表
	 * @return
	 * @throws Exception
	 */
	@GetMapping("/city/cities")
	public List<City> listCity() throws Exception;

	/**
	 * 根据城市ID查询天气数据
	 * @param cityId
	 * @return
	 */
	@GetMapping("/data/weather/cityId/{cityId}")
	public WeatherResponse getDataByCityId(@PathVariable("cityId") String cityId); 
}
