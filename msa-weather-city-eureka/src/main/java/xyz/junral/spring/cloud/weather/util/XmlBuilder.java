package xyz.junral.spring.cloud.weather.util;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import java.io.Reader;
import java.io.StringReader;

/**
 * XML宸ュ叿
 */
public class XmlBuilder {

    /**
     * 灏哫ML瀛楃涓茶浆涓烘寚瀹氱被鍨嬬殑POJO
     * @param clazz
     * @param xmlStr
     * @return
     * @throws Exception
     */
    public static Object xmlStrToObject(Class<?> clazz, String xmlStr) throws Exception {
        Object xmlObject = null;
        Reader reader = null;

        JAXBContext context = JAXBContext.newInstance(clazz);

        // 灏哫ml杞垚瀵硅薄鐨勬牳蹇冩帴鍙�
        Unmarshaller unmarshaller = context.createUnmarshaller();

        reader = new StringReader(xmlStr);
        xmlObject = unmarshaller.unmarshal(reader);

        if (reader != null) {
            reader.close();
        }

        return xmlObject;
    }
}
