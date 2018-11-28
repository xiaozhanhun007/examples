package zzp.util.test;

import java.security.DomainCombiner;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import org.apache.commons.text.StringEscapeUtils;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.util.http.HttpRequest;

/**
 * 测试日滨接口
 * @author karyzeng
 * @since 2018.10.26
 *
 */
public class RBTestHttpRequest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		String result = "[{\"acc\":\"00000\",\"bd09Lat\":22.50598668087496,\"bd09Lon\":114.09663408925931,\"city\":\"香港特别行政区\",\"direction\":67.03,\"district\":\"元朗区\",\"gpsTime\":\"2018-10-13 13:02:42\",\"lastAddr\":\"香港特别行政区 香港特别行政区 元朗区 古洞路\",\"leaveTime\":\"2018-10-13 13:43:04\",\"mileage\":0,\"province\":\"香港特别行政区\",\"roadName\":\"古洞路\",\"speed\":0,\"stopMinutes\":\"40分钟\",\"vehicle\":\"粤ZGL81港/TL6209\",\"wgsLat\":22.502666666666666,\"wgsLon\":114.08500333333333},{\"acc\":\"01000\",\"bd09Lat\":22.50593281248033,\"bd09Lon\":114.09759051631247,\"city\":\"香港特别行政区\",\"direction\":325.9,\"district\":\"元朗区\",\"gpsTime\":\"2018-10-13 13:20:07\",\"lastAddr\":\"香港特别行政区 香港特别行政区 元朗区 古洞路\",\"leaveTime\":\"2018-10-13 13:42:57\",\"mileage\":0,\"province\":\"香港特别行政区\",\"roadName\":\"古洞路\",\"speed\":0,\"stopMinutes\":\"22分钟\",\"vehicle\":\"粤ZJA43港/UL3236\",\"wgsLat\":22.502595,\"wgsLon\":114.08596333333334}]";
//		String result = "[]";
//		JSONArray jsonArray = JSONArray.parseArray(result);
//		boolean b = jsonArray.isEmpty();
//		if (jsonArray != null) {
//			System.out.println(jsonArray);
//		}
//		
//		String aString = "粤ZGL81港/TL6209";
//		aString = aString.substring(0, aString.lastIndexOf("/"));
//		System.out.println(aString);
//		
//		for (int i = 0; i < 100; i++) {
//			System.out.println(ThreadLocalRandom.current().nextInt(3));
//		}
		
		String result = HttpRequest.sendGet("http://gps4.56pip.com/gpsservice/gpsservices.asmx/getLoginKey", "userName=hytpweb&userPsw=36115779");
		System.out.println("获取key返回结果：" + result);
		try {
			Document document = DocumentHelper.parseText(result);
			Element rootElement = document.getRootElement();
			String key = rootElement.getText();
			System.out.println(key);
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		
		String resultInfo = HttpRequest.sendGet("http://gps4.56pip.com/gpsservice/gpsservices.asmx/getCurrentVehicleInfo", "loginKey=aHl0cHdlYl8zNjExNTc3OV8xMC4yNTQuMC45MF8zODM=&numberPlateList=粤AH8A85");
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
		
		System.out.println(checkRBLoginKey("aHl0cHdlYl8zNjExNTc3OV8xMC4yNTQuMC45MF8zODM"));
		
		
		SimpleDateFormat smft = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date nowDate = new Date();
		System.out.println(smft.format(nowDate));
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(nowDate);
		calendar.add(Calendar.HOUR_OF_DAY, 2);
		Date tempDate = calendar.getTime();
		System.out.println(smft.format(tempDate));
		
		Calendar calendar2 = Calendar.getInstance();
		calendar2.add(Calendar.DAY_OF_MONTH, -29);
		Date tempDate2 = calendar2.getTime();
		System.out.println(smft.format(tempDate2));
		
	}
	
	private static boolean checkRBLoginKey(String loginKey) {
		String result = HttpRequest.sendGet("http://gps4.56pip.com/gpsservice/gpsservices.asmx/checkLoginKey", "sessionKey=" + loginKey);
		System.out.println("判断日滨登录凭证的有效性，返回数据为：" + result);
		try {
			Document document = DocumentHelper.parseText(result);
			Element rootElement = document.getRootElement();
			String sign = rootElement.getText();
			return sign.equals("true") ? true : false;
		} catch (DocumentException e) {
			e.printStackTrace();
			return false;
		}
	}

}
