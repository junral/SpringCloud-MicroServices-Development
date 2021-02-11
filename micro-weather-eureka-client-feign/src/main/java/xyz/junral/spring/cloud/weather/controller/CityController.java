package xyz.junral.spring.cloud.weather.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import xyz.junral.spring.cloud.weather.service.CityClient;

@RestController
public class CityController {

	@Autowired
	private CityClient cityClient;

	@GetMapping("/cities")
	public String listCity() {
		// ͨ��Feign�ͻ���������
		return cityClient.listCity();
	}

}
