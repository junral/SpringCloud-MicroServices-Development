package xyz.junral.spring.cloud.weather.service;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import xyz.junral.spring.cloud.weather.vo.City;
import xyz.junral.spring.cloud.weather.vo.WeatherResponse;

/**
 * �������ݵĿͻ���
 * @author Junral
 *
 */
@FeignClient("msa-weather-eureka-client-gateway")
public interface DataClient {

	/**
	 * ��ȡ�����б�
	 * @return
	 * @throws Exception
	 */
	@GetMapping("/city/cities")
	public List<City> listCity() throws Exception;

	/**
	 * ���ݳ���ID��ѯ��������
	 * @param cityId
	 * @return
	 */
	@GetMapping("/data/weather/cityId/{cityId}")
	public WeatherResponse getDataByCityId(@PathVariable("cityId") String cityId); 
}
