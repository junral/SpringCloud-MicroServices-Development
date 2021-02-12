package xyz.junral.spring.cloud.weather;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

/**
 * 涓诲簲鐢ㄧ▼搴�
 */
@SpringBootApplication
@EnableDiscoveryClient
public class Application {

//	@Bean
//	public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
//		return builder.routes()
//			.route("route_micro_weather_eureka_client", r -> r.path("/hi/**")
//				.uri("lb://micro-weather-eureka-client"))
//			.build();
//	}

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
