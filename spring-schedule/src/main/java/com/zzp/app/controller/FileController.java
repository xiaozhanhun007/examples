package com.zzp.app.controller;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

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

}
