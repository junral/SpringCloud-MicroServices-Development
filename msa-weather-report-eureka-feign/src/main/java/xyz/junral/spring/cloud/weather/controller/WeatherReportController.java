package xyz.junral.spring.cloud.weather.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import xyz.junral.spring.cloud.weather.service.CityClient;
import xyz.junral.spring.cloud.weather.service.WeatherReportService;
import xyz.junral.spring.cloud.weather.vo.City;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/report")
public class WeatherReportController {

    private final static Logger logger = LoggerFactory.getLogger(WeatherReportController.class);

    @Autowired
    private WeatherReportService weatherReportService;

	@Autowired
	private CityClient cityClient;

    @GetMapping("/cityId/{cityId}")
    public ModelAndView getReportByCityId(@PathVariable("cityId") String cityId, Model model) throws Exception {
        // TODO 鏀逛负鐢卞煄甯傛暟鎹瓵PI寰湇鍔℃潵鎻愪緵鏁版嵁
        List<City> cityList = null;
        try{
            // TODO 璋冪敤鍩庡競鏁版嵁API
            cityList = cityClient.listCity();
        } catch (Exception e) {
            logger.error("鑾峰彇鍩庡競淇℃伅寮傚父锛�", e);
            throw new RuntimeException("鑾峰彇鍩庡競淇℃伅寮傚父锛�", e);
        }

        model.addAttribute("title", "鑰佸崼鐨勫ぉ姘旈鎶�");
        model.addAttribute("cityId", cityId);
        model.addAttribute("cityList", cityList);
        model.addAttribute("report", weatherReportService.getDataByCityId(cityId));
        return new ModelAndView("weather/report", "reportModel", model);
    }
}
