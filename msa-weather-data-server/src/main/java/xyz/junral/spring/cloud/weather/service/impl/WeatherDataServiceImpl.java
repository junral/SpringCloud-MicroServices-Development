package xyz.junral.spring.cloud.weather.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import xyz.junral.spring.cloud.weather.service.WeatherDataService;
import xyz.junral.spring.cloud.weather.vo.WeatherResponse;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * 天气数据服务
 */
@Service
public class WeatherDataServiceImpl implements WeatherDataService {

    private final static Logger logger = LoggerFactory.getLogger(WeatherDataServiceImpl.class);

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    private final String WEATHER_API = "http://wthrcdn.etouch.cn/weather_mini";

    /**
     * 缓存超时时间
     */
    private final Long TIME_OUT = 1800L;

    @Override
    public WeatherResponse getDataById(String cityId) {
        String uri = WEATHER_API + "?citykey=" + cityId;
        return this.doGetWeatherData(uri);
    }

    @Override
    public WeatherResponse getDataByCityName(String cityName) {
        String uri = WEATHER_API + "?city=" + cityName;
        return doGetWeatherData(uri);
    }

    private WeatherResponse doGetWeatherData(String uri) {
        ValueOperations<String, String> ops = this.stringRedisTemplate.opsForValue();
        String key = uri;
        String strBody = null;
        // 先查缓存，如果没有再查服务
        if (!this.stringRedisTemplate.hasKey(key)) {
            logger.info("未找到 key " + key);
            throw new RuntimeException("没有相应的天气信息");
        } else {
            logger.info("找到 key " + key + ", value=" + ops.get(key));
            strBody = ops.get(key);
        }

        ObjectMapper mapper = new ObjectMapper();
        WeatherResponse weather = null;
        try{
            weather = mapper.readValue(strBody, WeatherResponse.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return weather;
    }
}
