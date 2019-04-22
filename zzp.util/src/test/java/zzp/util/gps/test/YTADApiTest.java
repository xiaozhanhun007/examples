package zzp.util.gps.test;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.util.http.HttpRequest;
import org.apache.commons.lang3.StringUtils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description 易通安达GPS API接口测试
 * @Author karyzeng
 * @since 2019.04.22
 **/
public class YTADApiTest {

    private static SimpleDateFormat smft = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static void main(String[] args) {
        String vehicles = "粤ZDF15港/UP2643,粤ZDF19港/UP4056,粤ZDF18港/FP7277,粤ZDF12港/MP9621,粤ZDF17港/TZ6965,粤ZDF16港/MP9310,粤ZDF14港/FP7920,粤ZDF11港/MP8930,粤ZDF06港/UP3667,粤ZDF13港/MR483,粤ZCX28港/TL2272,粤ZCX36港/LM1886,粤ZGD88港/MJ992,粤ZSZ68港/SY2179,粤ZEC02港/TB420,粤ZEM67港/RE9880,粤ZYN82港/VB9200,粤ZYS70港/VP8699,粤ZBA34港/VL4299,粤ZBA37港/MV3566,粤ZEH43港/UL4393,粤ZBA21港/UX5593,粤ZJA76港/RD3496,粤ZJA43港/UL3236,粤ZBA26港/UX4765,粤ZEH45港/TU8852,粤ZCW01港/PS2889,粤ZHL93港/TY6460,粤ZCV96港/UJ8522,粤ZYK26港/ST7177,粤ZYK15港/TK6544,粤ZBB39港/HP6175,粤ZHW23港/ST1896,粤ZBZ35港/ST1896,粤ZEB60港/RK6242,粤ZBZ26港/TE1067,粤ZHW37港/RF8566,粤ZBZ27港/PM834,粤ZBZ32港/SN4469,粤ZYM91港/UH4988,粤ZFF29港/PH8911,粤ZFX49港/SC9913,粤ZHE53港/SC9913,粤ZGH71港/RU5348,粤ZYG52港/RX4540,粤ZYE67港/RY3908,粤ZJE61港/RY3908,粤ZHE37港/RY3908,粤ZYP62港/LE902,粤ZEH53港/SD8281,粤ZEH57港/SD7926,粤ZHA57港/NN6961,粤ZJB22港/RT8760,粤ZBA38港/LP2999,粤ZBA35港/SG9678,粤ZBA27港/PR1517,粤ZGC91港/PT7972,粤ZBA22港/SD427,粤ZBA30港/VE6173,粤ZJA86港/VE4877,粤ZGL81港/TL6209,粤ZJA53港/SX627,粤ZBA36港/TK6785,粤ZJB93港/SY1710,粤ZBJ05港/UA9004,粤ZJA65港/TL4151,粤ZJA72港/TX6930,粤ZJA48港/TJ7886,粤ZJC71港/SX4735,粤ZBC95港/UT8420,粤ZEH50港/SD7240,粤ZGP61港/US3241,粤ZEH07港/US2517,粤ZGX08港/TK4030,粤ZSW33港/HS4691,粤ZBA28港/UH9812,粤ZBA33港/RN7603,粤ZHZ37港/SZ5137,粤ZCU44港/SE8426,粤ZEH10港/LM9128,粤ZSQ92港/SA5898,粤ZYK49港/PW3299,粤ZFL11港/PE9860,粤ZSZ77港/LH3317,粤ZHA69港/NE462,粤ZDF95港/PM5103,粤ZDR44港/SR1726,粤ZYL50港/SG6779,粤ZGN09港/TM9820,粤ZBN11港/RW677,粤ZCN48港/NX641,粤ZGU47港/TV2835,粤ZFF94港/NX426,粤ZHE69港/RA9642,粤ZGC90港/SZ7407,粤ZFM97港/SC415,粤ZCS13港/PP3272,粤ZYA29港/JB6836,粤ZEU93港/UU3710,粤ZHA03港/NN5484,粤ZEC02港/TB420,粤ZGU63港/GL871,粤ZCW93港/RX4075,粤ZGD69港/KC2911,粤ZHN01港/UT2262,粤ZFD34港/GX3791,粤ZYX40港/VT1099,粵ZDF19港/UP4056,VD408/VD408,MV6318/MV6318,NL6318/NL6318,FV6318/FV6318,CY6318/CY6318,LL6318/LL6318,FD6318/FD6318,VB2202/VB2202,LD1879/LD1879,NM3601/NM3601,VW3228/VW3228,TL6209/TL6209,HH6318/HH6318,VS6318/VS6318,VY2678/VY2678,客户自提,寄快递,粵ZDU18港/SP2069,粤ZBT91港/HH6989,粤ZBU18港/SP2069,粵ZBT94港/PP8009";
        Map<String, String> params = new HashMap<String, String>();
        params.put("appId", "bc23903891");
        params.put("time", smft.format(new Date()));
        params.put("format", "json");
        params.put("vehicle", vehicles);

        String result = HttpRequest.sendGetBySHA1("https://gps.xinloo.cn/monit/getVehcilePos", "0e246f103676460287884a09568b3af2", params);

        if (StringUtils.isNotBlank(result)) {
            JSONObject jsonObject = JSONObject.parseObject(result);
            String code = jsonObject.getString("code");
            if (code.equals("1")) {
                JSONArray datas = jsonObject.getJSONArray("data");
                if (!datas.isEmpty() && datas.size() > 0) {
                    for (int i = 0; i < datas.size(); i++) {
                        JSONObject data = datas.getJSONObject(i);
                        String vehicle = data.getString("vehicle");
//						//易通安达返回的中港车车牌为“粤ZGL81港/TL6209”，只需要获取大陆车牌即可
//						if (vehicle.indexOf("/") != -1) {
//							vehicle = vehicle.substring(0, vehicle.lastIndexOf("/"));
//						}
                        String gpsTime = data.getString("gpsTime");
                        String placeName = data.getString("province") + data.getString("city") + data.getString("district");
                        String roadName = data.getString("roadName");
                        String lon = data.getString("bd09Lon");
                        String lat = data.getString("bd09Lat");
                        System.out.println("车牌号：" + vehicle + "，gpsTime：" + gpsTime + "，区域：" + placeName + "，道路：" + roadName + "，纬度：" + lat + "，经度：" + lon + "，来源：易通安达");
                    }
                }
            }
        }

    }

}
