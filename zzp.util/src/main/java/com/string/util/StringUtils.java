package com.string.util;

import java.util.UUID;

/**
 * @Description 字符串工具类
 * @Author Garyzeng
 * @since 2019.12.02
 **/
public class StringUtils {

    /**
     * Java是基于Unicode编码的，因此，一个汉字的长度为1，而不是2
     * “123abc美丽中国”按字节长度计算是14，而按Unicode计算长度是10
     * 可以通过判断每一个字符Ascii码来获得具体的长度。如果是标准的字符，Ascii的范围是0至255，如果是汉字或其他全角字符，Ascii会大于255
     * @param str
     * @return
     */
    public static int strByteLength(String str) {
        int length = 0;
        for(int i = 0; i < str.length(); i++) {
            int ascii = Character.codePointAt(str, i);
            if(ascii >= 0 && ascii <=255)
                length++;
            else
                length += 2;
        }
        return length;
    }

    public static int strByteLengthByStream(String str) {
        try {
            if (str != null && !str.equals("")) {
                byte[] bytes = str.getBytes("GBK");
                return bytes.length;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    /**
     * 生成UUID
     * @return
     */
    public static String UUID() {
        return UUID.randomUUID().toString().replaceAll("-","");
    }

    public static void main(String[] args) {
        String content = "1|1|缶4|34好的没问题安安定定aadded中e是打卡机冷风机aa";
        System.out.println(content.length());
        System.out.println(strByteLengthByStream(content));
        System.out.println(UUID());
    }

}
