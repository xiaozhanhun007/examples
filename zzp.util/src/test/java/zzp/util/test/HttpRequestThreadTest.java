package zzp.util.test;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.http.thread.HttpRequestThread;

public class HttpRequestThreadTest {

	public static void main(String[] args) {
		int vehicleNoMax = 50;
		String vehicleNos = "‘¡BAD548,‘¡BAN575,‘¡BAN596,‘¡BAN803,‘¡BAP099,‘¡BAP161,‘¡BAX162,‘¡BAZ700,‘¡BAZ701,‘¡BB6273,‘¡BB6359,‘¡BBC747,‘¡BBN288,‘¡BBN295,‘¡BBN296,‘¡BBN305,‘¡BBQ421,‘¡BBQ540,‘¡BBQ649,‘¡BBQ689,‘¡BBQ705,‘¡BBT477,‘¡BBY091,‘¡BBY181,‘¡BBY262,‘¡BBY327,‘¡BBY369,‘¡BBY376,‘¡BBY378,‘¡BBY385,‘¡BBY388,‘¡BBY389,‘¡BBY395,‘¡BBY575,‘¡BBY608,‘¡BBY609,‘¡BBY611,‘¡BCG067,‘¡BCG087,‘¡BCG088,‘¡BCG091,‘¡BCG746,‘¡BDX743,‘¡BDZ318,‘¡BDZ802,‘¡BEA360,‘¡BEG142,‘¡BET599,‘¡BFH641–¬,‘¡BFP995,‘¡BFS372,‘¡BFS372±±∂∑,‘¡BFS626,‘¡BFS668,‘¡BFS688,‘¡BFT045,‘¡BFW682,‘¡BFW683,‘¡BFW683±±∂∑,‘¡BGD759–¬,‘¡BGE115–¬,‘¡BGG023,‘¡BGK915–¬,‘¡BGK977–¬,‘¡BGK999,‘¡BGQ083,‘¡BGS126,‘¡BGS195,‘¡BGT602,‘¡BJ5943,‘¡BL0769,‘¡BL4263,‘¡BL4442,‘¡BM1982,‘¡BM2180,‘¡BM4468,‘¡BM7115±±∂∑,‘¡BM7222,‘¡BP5091,‘¡BP6061,‘¡BR0533,‘¡BR2865,‘¡BR7665,‘¡BS0985,‘¡BS6035,‘¡BS8435,‘¡BT2096,‘¡BT2857,‘¡BT2886±±∂∑,‘¡BT2982,‘¡BT8380,‘¡BT8958±±∂∑,‘¡BU2775,‘¡BU4538,‘¡BU9026,‘¡BU9056,‘¡BU9059,‘¡BU9713,‘¡BV0400,‘¡BV0401,‘¡BV0528,‘¡BV8716,‘¡BW1840,‘¡BW1901,‘¡BW7298,‘¡BZ0152,‘¡BZ0153,‘¡BZ0166,‘¡BZ0168,‘¡BZ0169,‘¡BZ0170,‘¡BZ0171,‘¡BZ1278,‘¡BZ1291,‘¡BZ2437,‘¡BZ2683,‘¡BZ2689";
		String[] vehicleNoArr = vehicleNos.split(",");
		List<String> vehicleNoList = new ArrayList<String>();
		StringBuffer sBuffer = new StringBuffer();
		for (int i = 0; i < vehicleNoArr.length; i++) {
			sBuffer.append(vehicleNoArr[i] + ",");
			if ((i + 1) % vehicleNoMax == 0) {
				sBuffer.deleteCharAt(sBuffer.lastIndexOf(","));
				vehicleNoList.add(sBuffer.toString());
				sBuffer = new StringBuffer();
			}
		}
		if (sBuffer.length() > 0) {
			sBuffer.deleteCharAt(sBuffer.lastIndexOf(","));
			vehicleNoList.add(sBuffer.toString());
		}
		
		SimpleDateFormat smft = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");
		for (int i = 0; i < vehicleNoList.size(); i++) {
			//4.2 ªÒ»°≥µ¡æµƒ◊Ó–¬Œª÷√–≈œ¢ 
			Map<String, String> params = new HashMap<String, String>();
			params.put("method", "GetVehcileInfo");
			params.put("appkey", "30914b89-262a-4832-b8b9-fe33770b4b4d");
			params.put("timestamp", smft.format(new Date()));
			params.put("format", "json");
			params.put("isoffsetlonlat", "2");
			params.put("sessionid", "");
			params.put("vehicle", vehicleNoList.get(i));
			HttpRequestThread httpRequestThread = new HttpRequestThread("http://api.e6gps.com/public/v3/Inface/Call", "69411cff-d7be-4458-952f-2fca0267b408", params);
			Thread thread = new Thread(httpRequestThread);
			thread.start();
		}
	}

}
