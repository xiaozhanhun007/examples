package com.zw.invt;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

/**
 * @Description 生成核注清单表头SQL
 * @Author karyzeng
 * @since 2020.06.05
 **/
public class CreateInvtHeadSQL {

    public static void main(String[] args) {
        List<InvtHead> invtHeads = init();
        for (int i = 0; i < invtHeads.size(); i++) {
            InvtHead invtHead = invtHeads.get(i);
            System.out.println("-- " + invtHead.getBondInvtNo() + " " + invtHead.getCitDocNo() + " " + invtHead.getEntBillNo());
            System.out.println("INSERT INTO `essdb`.`dcl_invt_head`(`company_code`, `company_uid`, `creater_id`, `creater_name`, `updater_id`, `updater_name`, `create_time`, `update_time`, `group_uid`, `group_name`, `bond_invt_no`) ");
            System.out.println("VALUES ('" + invtHead.getCompanyCode() + "', '" + invtHead.getCompanyUid() + "', '8736', 'Chery', '8736', 'Chery', NOW(), NOW(), NULL, NULL, '" + invtHead.getBondInvtNo() + "');");
            System.out.println();
        }
    }

    public static List<InvtHead> init() {
        List<InvtHead> invtHeads = new ArrayList<InvtHead>();
        String path = CreateInvtHeadSQL.class.getClassLoader().getResource("invtHead.json").getPath();
        String s = readJsonFile(path);
        JSONArray jsonArray = JSON.parseArray(s);
        for (int i = 0; i < jsonArray.size(); i++) {
            JSONObject jsonObject = jsonArray.getJSONObject(i);
            InvtHead invtHead = JSON.parseObject(jsonObject.toString(), InvtHead.class);
            invtHeads.add(invtHead);
        }
        return invtHeads;
    }

    //读取json文件
    public static String readJsonFile(String fileName) {
        String jsonStr = "";
        try {
            File jsonFile = new File(fileName);
            FileReader fileReader = new FileReader(jsonFile);
            Reader reader = new InputStreamReader(new FileInputStream(jsonFile),"utf-8");
            int ch = 0;
            StringBuffer sb = new StringBuffer();
            while ((ch = reader.read()) != -1) {
                sb.append((char) ch);
            }
            fileReader.close();
            reader.close();
            jsonStr = sb.toString();
            return jsonStr;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

}
