package xyz.junral.spring.cloud.weather.job;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;
import xyz.junral.spring.cloud.weather.service.CityDataService;
import xyz.junral.spring.cloud.weather.service.WeatherDataService;
import xyz.junral.spring.cloud.weather.vo.City;

import java.util.List;

/**
 * 天气数据同步任务
 */
public class WeatherDataSyncJob extends QuartzJobBean {

    private final static Logger logger = LoggerFactory.getLogger(WeatherDataSyncJob.class);

    @Autowired
    private CityDataService cityDataService;

    @Autowired
    private WeatherDataService weatherDataService;

    @Override
    protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
        logger.info("Start 天气数据同步任务");

        // 读取城市列表
        List<City> cityList = null;
        try{
            cityList = cityDataService.listCity();
        } catch (Exception e) {
            logger.error("获取城市信息异常！", e);
        }

        for (City city : cityList) {
            String cityId = city.getCityId();
            logger.info("天气数据同任务中，cityId:" + cityId);

            // 根据城市ID获取天气
            weatherDataService.syncDataByCityId(cityId);
        }

        logger.info("End 天气数据同步任务");
    }
}
