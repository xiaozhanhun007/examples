package com.zw.invt;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description 生成核注清单表体SQL
 * @Author karyzeng
 * @since 2020.06.05
 **/
public class CreateInvtDetailSQL {

    public static void main(String[] args) {
        List<InvtDetail> invtDetails = init();
        for (int i = 0; i < invtDetails.size(); i++) {
            InvtDetail invtDetail = invtDetails.get(i);
            System.out.println("-- " + invtDetail.getBondInvtNo() + " " + invtDetail.getCitDocNo() + " " + invtDetail.getEntBillNo());

            for (int j = 0; j < invtDetail.getDetailSize(); j++) {
                System.out.println("INSERT INTO `essdb`.`dcl_invt_detail`(`company_code`, `company_uid`, `creater_id`, `creater_name`, `updater_id`, `updater_name`, `create_time`, `update_time`, `group_uid`, `group_name`, `invt_head_id`, `gds_seqno`) ");
                System.out.println("VALUES ('" + invtDetail.getCompanyCode() + "', '" + invtDetail.getCompanyUid() + "', '" + invtDetail.getCreatorId() + "', '" + invtDetail.getCreatorName() + "', '" + invtDetail.getCreatorId() + "', '" + invtDetail.getCreatorName() + "', NOW(), NOW(), NULL, NULL, " + invtDetail.getId() + ", " + (j + 1) + ");");
            }

            System.out.println();
            System.out.println();
        }
    }

    public static List<InvtDetail> init() {
        List<InvtDetail> invtDetails = new ArrayList<InvtDetail>();
        String path = CreateInvtDetailSQL.class.getClassLoader().getResource("invtHead.json").getPath();
        String s = CommonReadJsonUtil.readJsonFile(path);
        JSONObject root = JSON.parseObject(s);
        JSONObject baseDataJson = root.getJSONObject("baseData");
        BaseData baseData = JSON.parseObject(baseDataJson.toString(), BaseData.class);
        JSONArray list = root.getJSONArray("list");
        for (int i = 0; i < list.size(); i++) {
            JSONObject jsonObject = list.getJSONObject(i);
            InvtDetail invtDetail = JSON.parseObject(jsonObject.toString(), InvtDetail.class);
            invtDetail.setCompanyUid(baseData.getCompanyUid());
            invtDetail.setCompanyCode(baseData.getCompanyCode());
            invtDetail.setCreatorId(baseData.getCreatorId());
            invtDetail.setCreatorName(baseData.getCreatorName());
            invtDetails.add(invtDetail);
        }
        return invtDetails;
    }

}
