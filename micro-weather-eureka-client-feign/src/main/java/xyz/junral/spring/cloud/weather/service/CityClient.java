package xyz.junral.spring.cloud.weather.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * ���ʳ�����Ϣ�Ŀͻ���
 * @author Junral
 *
 */
@FeignClient("msa-weather-city-eureka")
public interface CityClient {

	@GetMapping("/cities")
	public String listCity();

}
