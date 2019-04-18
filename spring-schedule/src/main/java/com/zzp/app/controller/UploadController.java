package com.zzp.app.controller;

import com.alibaba.fastjson.JSON;
import com.excel.util.ParseExcelUtil;
import com.util.convert.ConvertUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

/**
 * @Description 上传测试接口
 * @Author karyzeng
 * @since 2019.04.17
 **/
@Controller
@RequestMapping(value = "/upload")
public class UploadController {

    @RequestMapping(value = "/importTest",method = RequestMethod.POST)
    @ResponseBody
    public String importTest(HttpServletRequest request, HttpServletResponse response, MultipartFile[] uploadFile){
        String entityName = "服务商导入";
        if (null != uploadFile && uploadFile.length > 0) {
            try {
                for (MultipartFile uploadFile_temp : uploadFile) {
                    ParseExcelUtil excel = new ParseExcelUtil(uploadFile_temp.getInputStream(), 0, 1, entityName, 0);
                    if (excel.getErrorString().length() == 0) {
                        List<Map<String, Object>> listDatas = excel.getListDatas();
                        String json = JSON.toJSONString(listDatas);
                        return json;
                    } else {
                        if (excel.getErrorString().toString().contains("<br><br>")) {
                            return  JSON.toJSONString(ConvertUtil.convertImportResult(excel.getErrorString().toString()));
                        } else {
                            return  ConvertUtil.replaceHtmlLabel(excel.getErrorString().toString());
                        }
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
                return "上传失败，出现异常，异常信息为：" + e.getMessage();
            }

        } else {
            return "请选择上传文件";
        }
        return "form";
    }

}
