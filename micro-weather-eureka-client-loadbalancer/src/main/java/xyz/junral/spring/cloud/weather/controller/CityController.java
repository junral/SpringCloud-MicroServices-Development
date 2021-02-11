package xyz.junral.spring.cloud.weather.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class CityController {

	@Autowired
	private LoadBalancerClient loadBalanceerClient;

	@Autowired
	private RestTemplate restTemplate;

	@GetMapping("/cities")
	public String listCity() {
		ServiceInstance serverInstance = loadBalanceerClient.choose("msa-weather-city-eureka");
		String url = "http://" + serverInstance.getHost() + ":" + serverInstance.getPort() + "/cities";
		return restTemplate.getForObject(url, String.class);
	}
}
