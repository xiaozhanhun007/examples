package zzp.util.gps.test;

import com.util.http.HttpRequest;
import org.apache.commons.text.StringEscapeUtils;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import java.util.List;

/**
 * @Description 日滨GPS API接口测试
 * @Author karyzeng
 * @since 2019.04.22
 **/
public class RBApiTest {

    public static void main(String[] args) {
        String vehicles = "粤AH8A85,粤A5V3R0,粤AM4636,粤AAM476,粤AP7346,粤AAM463,粤AJ4543,粤AD1135,粤AD1148,粤AP7831,粤AP7679,粤AN0893,粤AP7856,粤AS1615,粤A90336,粤AH8550,粤AH8558,粤AN0871,粤AM7696,粤A0FK59,湘D34335,粤AW9167,粤AU8349,粤AAD098,粤BGG019,赣AAS393,粤AK5685,湘G25288,浙HC7639,粤AAS393,粤AAX012,鄂AMB258,粤ABA908,粤A6X5H8,粤AD13960, 粤A6Q9D2 ,赣D89A19 ,粤A2NW48,粤AN0010,粤AE8400,粤BEC907,粤A5Q4H9,粤A1B8D4,粤BCZ133,粤BT7442,粤B1N1M9,粤AM9887,粤ABJ266,粤AP3806,粤AH9A10";
        String resultInfo = HttpRequest.sendGet("http://gps4.56pip.com/gpsservice/gpsservices.asmx/getCurrentVehicleInfo", "loginKey=aHl0cHdlYl8zNjExNTc3OV8xNC4yMy4xNjUuOTNfMzgz&numberPlateList=" + vehicles);
        resultInfo = StringEscapeUtils.unescapeXml(resultInfo);
//		String resultInfo = "<string xmlns=\"http://soap.56pip.com/\"><NewDataSet><Table><ObjectCode>654055</ObjectCode><VehicleNum>测试123123</VehicleNum><SerialNo>13609020330</SerialNo><SIM>13609020330</SIM><GPSTime>2018-09-21 12:13:36</GPSTime><RcvTime>2018-09-21 12:28:00</RcvTime><Lon>113.435643</Lon><Lat>23.150973</Lat><Speed>0</Speed><Direct>0</Direct><Mileage>0</Mileage><StatusDes>ACC开,定位,信号强度:18,</StatusDes><OilNum>-1</OilNum><IsOnline>0</IsOnline><IsAlarm>0</IsAlarm><Status>0</Status><ICCID /><StopTime>2018-09-20T08:47:24.943+08:00</StopTime><Address>广东省广州市天河区东圃镇,南云一路玉树新村以东南818米</Address></Table><Table><ObjectCode>654055</ObjectCode><VehicleNum>测试123123</VehicleNum><SerialNo>13609020330</SerialNo><SIM>13609020330</SIM><GPSTime>2018-09-21 12:13:36</GPSTime><RcvTime>2018-09-21 12:28:00</RcvTime><Lon>113.435643</Lon><Lat>23.150973</Lat><Speed>0</Speed><Direct>0</Direct><Mileage>0</Mileage><StatusDes>ACC开,定位,信号强度:18,</StatusDes><OilNum>-1</OilNum><IsOnline>0</IsOnline><IsAlarm>0</IsAlarm><Status>0</Status><ICCID /><StopTime>2018-09-20T08:47:24.943+08:00</StopTime><Address>广东省广州市天河区东圃镇,南云一路玉树新村以东南818米</Address></Table></NewDataSet></string>";
        System.out.println("获取车辆信息返回结果：" + resultInfo);
        try {
            Document documentInfo = DocumentHelper.parseText(resultInfo);
            Element rootElementInfo = documentInfo.getRootElement();
            Element newDataSet = rootElementInfo.element("NewDataSet");
            String newDataSetText = newDataSet.getText();
            System.out.println(newDataSetText);
            if (newDataSetText.equals("Error:Access denied")) {
                System.out.println("登录凭证无效");
            } else {
                System.out.println("登录凭证有效");
                List<Element> tables = newDataSet.elements("Table");
                if (tables != null && tables.size() > 0) {
                    System.out.println("存在数据");
                    for (int i = 0; i < tables.size(); i++) {
                        Element table = tables.get(i);
                        Element vehicle = table.element("VehicleNum");
                        System.out.println(vehicle.getText());
                    }
                } else {
                    System.out.println("不存在数据");
                }
            }
//			Element table = newDataSet.element("Table");
//			Element vehicle = table.element("VehicleNum");
//			System.out.println(vehicle.getText());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
