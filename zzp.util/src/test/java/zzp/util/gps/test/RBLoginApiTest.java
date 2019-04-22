package zzp.util.gps.test;

import com.util.http.HttpRequest;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

/**
 * @Description 日滨GPS登录接口测试
 * @Author karyzeng
 * @since 2019.04.22
 **/
public class RBLoginApiTest {

    public static void main(String[] args) {
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
    }

}
