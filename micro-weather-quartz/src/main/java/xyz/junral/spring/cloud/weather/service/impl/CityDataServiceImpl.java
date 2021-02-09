package xyz.junral.spring.cloud.weather.service.impl;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import xyz.junral.spring.cloud.weather.service.CityDataService;
import xyz.junral.spring.cloud.weather.util.XmlBuilder;
import xyz.junral.spring.cloud.weather.vo.City;
import xyz.junral.spring.cloud.weather.vo.CityList;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

/**
 * 城市数据服务
 */
@Service
public class CityDataServiceImpl implements CityDataService {

    @Override
    public List<City> listCity() throws Exception {
        // 读取XML文件
        Resource resource = new ClassPathResource("citylist.xml");
        InputStream in;
        BufferedReader br = new BufferedReader(
                new InputStreamReader(
                        resource.getInputStream(), "utf-8"));
        StringBuffer buffer = new StringBuffer();
        String line = "";
        while ((line = br.readLine()) != null) {
            buffer.append(line);
        }
        br.close();

        // XML转为Java对象
        CityList cityList = (CityList) XmlBuilder.xmlStrToObject(CityList.class, buffer.toString());
        return cityList.getCityList();
    }
}
