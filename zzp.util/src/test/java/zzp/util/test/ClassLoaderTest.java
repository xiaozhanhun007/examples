package zzp.util.test;

import com.excel.util.ParseXMLUtil;
import com.util.http.MD5Util;

public class ClassLoaderTest {

    public static void main(String[] args) {
        StringBuffer stringBuffer = new StringBuffer();
        System.out.println(stringBuffer.getClass().getClassLoader());

        MD5Util md5Util = new MD5Util();
        System.out.println(md5Util.getClass().getClassLoader());

        System.out.println(ParseXMLUtil.class.getClassLoader().getResource(""));


    }
}
