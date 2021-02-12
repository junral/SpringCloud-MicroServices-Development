package xyz.junral.spring.cloud.weather.job;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;

import xyz.junral.spring.cloud.weather.service.CityClient;
import xyz.junral.spring.cloud.weather.service.WeatherDataCollectionService;
import xyz.junral.spring.cloud.weather.vo.City;

import java.util.ArrayList;
import java.util.List;

/**
 * 澶╂皵鏁版嵁鍚屾浠诲姟
 */
public class WeatherDataSyncJob extends QuartzJobBean {

    private final static Logger logger = LoggerFactory.getLogger(WeatherDataSyncJob.class);

    @Autowired
    private WeatherDataCollectionService weatherDataCollectionService;
    
    @Autowired
    private CityClient cityClient;

    @Override
    protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
        logger.info("Start 澶╂皵鏁版嵁鍚屾浠诲姟");

        // 璇诲彇鍩庡競鍒楄〃
        List<City> cityList = null;
        try{
            // TODO 璋冩暣鍩庡競鏁版嵁API
        	cityList = cityClient.listCity();
        } catch (Exception e) {
            logger.error("鑾峰彇鍩庡競淇℃伅寮傚父锛�", e);
            throw new RuntimeException("鑾峰彇鍩庡競淇℃伅寮傚父锛�", e);
        }

        for (City city : cityList) {
            String cityId = city.getCityId();
            logger.info("澶╂皵鏁版嵁鍚屼换鍔′腑锛宑ityId:" + cityId);

            // 鏍规嵁鍩庡競ID鑾峰彇澶╂皵
            weatherDataCollectionService.syncDataByCityId(cityId);
        }

        logger.info("End 澶╂皵鏁版嵁鍚屾浠诲姟");
    }
}
