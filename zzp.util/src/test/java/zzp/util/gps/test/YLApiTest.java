package zzp.util.gps.test;

import com.http.thread.HttpRequestThread;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description 易流查询车辆GPS信息API接口测试
 * @Author karyzeng
 * @since 2019.04.22
 **/
public class YLApiTest {

    public static void main(String[] args) {
        String vehicles = "粤ZBU11港/UL2612,粤ZYM25港/SU3046,粤ZYM75港/HE699,粤ZHN15港/UJ3086,粤ZBF25港/UJ2751,粤ZHS72港/TW3292,粤ZBU12港/KG1498,粤ZJE28港/UV8975,粤ZBX37港/JP990,粤ZCA91港/VE5523,粤ZCV65港/UB9123,粤ZCA94港/PE2579,粤ZCK12港/UL5055,粤ZBU88港/PV1922,粤ZYM29港/TE5185,粤ZYS67港/UY8212,粤ZJE43港/SN1782,粤ZBT74港/TG7817,粤ZHD03港/UL7976,粤ZBH31港/TB8470,粤ZCS84港/VP5279,粤ZGN43港/UT2922,粤ZCV86港/PV862,粤ZGT83港/TJ1832,粤ZCS81港/SG8291,粤ZCA96港/SN8166,粤ZHR61港/VG1310,粤ZCB01港/VF7643,粤ZBX84港/VK5609,粤ZYN41港/UJ7303,粤ZEG70港/VK7298,粤ZBU35港/VG3807,粤ZYM26港/HD2879,粤ZYM16港/UZ2189,粤ZBT78港/SL3791,粤ZCB03港/SL3162,粤ZYK37港/SL3267,粤ZBU61港/SM401,粤ZBX43港/LY5159,粤ZSC94港/SN3976,粤ZSU21港/SH3185,粤ZBD07港/EF772,粤ZYL95港/VA8810,粤ZJE46港/LV7028,粤ZGW55港/LR819,粤ZHG61港/RH236,粤ZGU86港/TP946,粤ZJE26港/TG1906,粤ZHK34港/PN1857,粤ZSZ35港/TU3865";
        String vehicles2 = "粤ZEW95港/UA3898";
        SimpleDateFormat smft = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");
        //4.2 获取车辆的最新位置信息
        Map<String, String> params = new HashMap<String, String>();
        params.put("method", "GetVehcileInfo");
        params.put("appkey", "959452f0-5b1d-4d21-8d4f-2ba91ad51209");
        params.put("timestamp", smft.format(new Date()));
        params.put("format", "json");
        params.put("isoffsetlonlat", "2");
        params.put("sessionid", "");
        params.put("vehicle", vehicles);
        HttpRequestThread httpRequestThread = new HttpRequestThread("http://api.e6gps.com/public/v3/Inface/Call", "62e62cc3-3778-4a37-a619-218153945568", params);
        Thread thread = new Thread(httpRequestThread);
        thread.start();
    }

}
