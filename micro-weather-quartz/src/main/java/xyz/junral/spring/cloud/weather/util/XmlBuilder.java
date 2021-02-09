package xyz.junral.spring.cloud.weather.util;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import java.io.Reader;
import java.io.StringReader;

/**
 * XML工具
 */
public class XmlBuilder {

    /**
     * 将XML字符串转为指定类型的POJO
     * @param clazz
     * @param xmlStr
     * @return
     * @throws Exception
     */
    public static Object xmlStrToObject(Class<?> clazz, String xmlStr) throws Exception {
        Object  xmlObject = null;
        Reader reader = null;

        Class[] classesToBeBound;
        JAXBContext context = JAXBContext.newInstance(clazz);

        // 将Xml转成对象的核心接口
        Unmarshaller unmarshaller = context.createUnmarshaller();

        reader = new StringReader(xmlStr);
        xmlObject = unmarshaller.unmarshal(reader);

        if (reader != null) {
            reader.close();
        }

        return xmlObject;
    }
}
