package xyz.junral.spring.cloud.weather.service;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import xyz.junral.spring.cloud.weather.vo.City;

/**
 * 访问城市信息的客户端
 * @author Junral
 *
 */
@FeignClient("msa-weather-city-eureka")
public interface CityClient {

	@GetMapping("/cities")
	public List<City> listCity() throws Exception;

}
