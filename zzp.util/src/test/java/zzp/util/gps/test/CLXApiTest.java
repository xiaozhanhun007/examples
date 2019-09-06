package zzp.util.gps.test;

import com.util.http.HttpRequest;
import org.apache.commons.lang3.time.DateUtils;
import org.apache.commons.text.StringEscapeUtils;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description 车联讯API对接测试
 * @Author karyzeng
 * @since 2019.08.27
 **/
public class CLXApiTest {

    public static void main(String[] args) {

        String vehicle = "粤BBJ031";
        String accessToken = "17cc2581-eaaf-4040-ba58-db3c83f5edec";

        String url = "http://vdppservice.v-infonet.com/GetPosition";
        String params = "{\"LicenceNumber\":\"" + vehicle + "\",\"AccessToken\":\"" + accessToken + "\"}";
        Map<String, String> requestPropertys = new HashMap<String, String>();
        requestPropertys.put("Content-Type", "application/json");

        String resultInfo = HttpRequest.sendPost(url, params, requestPropertys);
        resultInfo = StringEscapeUtils.unescapeXml(resultInfo);
        System.out.println("获取车辆信息返回结果：" + resultInfo);

        try {
            Document documentInfo = DocumentHelper.parseText(resultInfo);
            Element rootElementInfo = documentInfo.getRootElement();
            String success = rootElementInfo.elementText("Success");
            if (success.equals("true")) {
                String licenceNumber = rootElementInfo.elementText("LicenceNumber");
                String latitude = rootElementInfo.elementText("Latitude");
                String longitude = rootElementInfo.elementText("Longitude");
                String reportTime = rootElementInfo.elementText("ReportTime");
                Date date = DateUtils.parseDate(reportTime.replace("T", " "), "yyyy-MM-dd HH:mm:ss");
                System.out.println(licenceNumber + "，" + latitude + "，" + longitude + "，" + reportTime + "，" + date);
            } else {
                System.out.println("获取失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
