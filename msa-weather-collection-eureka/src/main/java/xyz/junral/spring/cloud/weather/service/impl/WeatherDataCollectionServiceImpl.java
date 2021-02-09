package xyz.junral.spring.cloud.weather.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import xyz.junral.spring.cloud.weather.service.WeatherDataCollectionService;

import java.util.concurrent.TimeUnit;

/**
 * 数据采集服务
 */
@Service
public class WeatherDataCollectionServiceImpl implements WeatherDataCollectionService {

    private final static Logger logger = LoggerFactory.getLogger(WeatherDataCollectionServiceImpl.class);

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    private final String WEATHER_API = "http://wthrcdn.etouch.cn/weather_mini";

    /**
     * 缓存超时时间
     */
    private final Long TIME_OUT = 1800L;

    @Override
    public void syncDataByCityId(String cityId) {
        logger.info("Start 同步天气.cityId:" + cityId);

        String uri = WEATHER_API + "?citykey=" + cityId;
        this.saveWeatherData(uri);

        logger.info("End 同步天气");
    }

    private void saveWeatherData(String uri) {
        ValueOperations<String, String> ops = this.stringRedisTemplate.opsForValue();
        String key = uri;
        String strBody = null;

        ResponseEntity<String> response = restTemplate.getForEntity(uri, String.class);
        if (response.getStatusCodeValue() == 200) {
            strBody = response.getBody();
        }
        ops.set(key, strBody, TIME_OUT, TimeUnit.SECONDS);
    }
}
