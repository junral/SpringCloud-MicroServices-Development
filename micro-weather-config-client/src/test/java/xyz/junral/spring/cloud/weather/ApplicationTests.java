package xyz.junral.spring.cloud.weather;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ApplicationTests {

	@Value("${auther}")
	private String auther;

	@Test
	void contextLoads() {
		assertEquals("waylau.com", auther);
	}

}
