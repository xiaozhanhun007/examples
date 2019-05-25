package com.zzp.app.controller;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Base64;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

/**
 * @Description 文件操作controller
 * @Author karyzeng
 * @since 2019.04.29
 **/
@Controller
@RequestMapping(value = "/file")
public class FileController {

    @Autowired
    private Environment env;

    /**
     * 下载文件
     * @param request
     * @param response
     * @param fileName 文件名称
     */
    @RequestMapping(value = "/downloadFile/{fileName.*}")
    public void downloadFile(HttpServletRequest request, HttpServletResponse response, @PathVariable("fileName")String fileName) {
        String filePath = env.getProperty("image.filePath") + fileName;
        try {
            File fileTemp = new File(filePath);
            if (StringUtils.isNotBlank(fileName) && fileTemp.exists()) {
                Path file = Paths.get(filePath);
                String contentType = Files.probeContentType(Paths.get(filePath));
                response.setContentType(contentType);
                fileName = new String(fileName.getBytes("UTF-8"), "ISO-8859-1");
                response.addHeader("Content-Disposition","attachment; filename=" + fileName);
                Files.copy(file, response.getOutputStream());
            }else{
                response.setContentType("text/html");
                PrintWriter pw = response.getWriter();
                pw.write("404");
                pw.flush();
                pw.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
            response.setContentType("text/html");
            PrintWriter pw = null;
            try {
                pw = response.getWriter();
                pw.write("出现异常，异常信息为：" + e.getMessage());
                pw.flush();
            } catch (Exception e1) {
                e1.printStackTrace();
            } finally {
                if (pw != null) {
                    pw.close();
                }
            }
        }

    }

    /**
     * 查看图片
     * @param response
     * @param imageName 图片名称
     */
    @RequestMapping(value = "/image/{imageName.*}")
    public void getImage(HttpServletResponse response,@PathVariable("imageName")String imageName) {
        String path = env.getProperty("image.filePath") + imageName;
        try {
            File file = new File(path);
            if (file.exists()) {
                String contentType = Files.probeContentType(Paths.get(path));
                response.setContentType(contentType);
                InputStream in = new FileInputStream(file);// 用该文件创建一个输入流
                OutputStream os = response.getOutputStream(); // 创建输出流
                byte[] b = new byte[1024];
                while (in.read(b) != -1) {
                    os.write(b);
                }
                in.close();
                os.flush();
                os.close();
            } else {
                response.setContentType("text/html");
                PrintWriter pw = response.getWriter();
                pw.write("404");
                pw.flush();
                pw.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 生成二维码，将二维码以base64的格式输出
     */
    @ResponseBody
    @RequestMapping(value = "/qrCodeEncoderToBase64")
    public Object qrCodeEncoderToBase64() {
        Map<String,Object> response = new HashMap<String,Object>();
        String contents = "www.hoolinks.com";
        String formatName = "png";
        String base64Header = "data:image/" + formatName + ";base64,";
        Hashtable<EncodeHintType, String> hints = new Hashtable<EncodeHintType, String>();
        hints.put(EncodeHintType.CHARACTER_SET, "UTF-8");
        BitMatrix matrix = null;
        try {
            matrix = new MultiFormatWriter().encode(contents, BarcodeFormat.QR_CODE, 300, 300, hints);
            BufferedImage image = MatrixToImageWriter.toBufferedImage(matrix);
            ByteArrayOutputStream os = new ByteArrayOutputStream();
            ImageIO.write(image, formatName, os);//利用ImageIO类提供的write方法，将bi以png图片的数据模式写入流。
            byte b[] = os.toByteArray();//从流中获取数据数组
            String str = new Base64().encodeAsString(b);
            String base64Str = base64Header + str;
            response.put("status", 1);
            response.put("message", "SUCCESS");
            response.put("data", base64Str);
        } catch (Exception e) {
            e.printStackTrace();
            response.put("status", 2);
            response.put("message", "ERROR");
            response.put("data", null);
        }
        return response;
    }

}
