package com.zzp.invt.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.zzp.invt.entity.InvtHead;
import com.zzp.invt.entity.vo.BaseDataVo;
import com.zzp.invt.entity.vo.InvtHeadVo;
import com.zzp.invt.mapper.InvtHeadMapper;
import com.zzp.invt.service.IInvtHeadService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 核注清单表头 服务实现类
 * </p>
 *
 * @author Garyzeng
 * @since 2020-06-07
 */
@Service
public class InvtHeadServiceImpl extends ServiceImpl<InvtHeadMapper, InvtHead> implements IInvtHeadService {

    @Value(value = "classpath:invtHead.json")
    private Resource invtHeadConfig;

    public void createInvtHeadSQL() {
        try {
            List<InvtHeadVo> invtHeads = this.init();
            for (int i = 0; i < invtHeads.size(); i++) {
                InvtHeadVo invtHead = invtHeads.get(i);
                System.out.println("-- " + invtHead.getBondInvtNo() + " " + invtHead.getCitDocNo() + " " + invtHead.getEntBillNo());
                System.out.println("INSERT INTO `essdb`.`dcl_invt_head`(`company_code`, `company_uid`, `creater_id`, `creater_name`, `updater_id`, `updater_name`, `create_time`, `update_time`, `group_uid`, `group_name`, `bond_invt_no`) ");
                System.out.println("VALUES ('" + invtHead.getCompanyCode() + "', '" + invtHead.getCompanyUid() + "', '" + invtHead.getCreatorId() + "', '" + invtHead.getCreatorName() + "', '" + invtHead.getCreatorId() + "', '" + invtHead.getCreatorName() + "', NOW(), NOW(), NULL, NULL, '" + invtHead.getBondInvtNo() + "');");
                System.out.println();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getResourceConfig(InputStream resourceInputStream) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(resourceInputStream));
        StringBuffer message=new StringBuffer();
        String line = null;
        while((line = br.readLine()) != null) {
            message.append(line);
        }
        String defaultString=message.toString();
        String result=defaultString.replaceAll("\r\n", "");
        return result;
    }

    private List<InvtHeadVo> init() throws IOException {
        List<InvtHeadVo> invtHeads = new ArrayList<InvtHeadVo>();
        String s = this.getResourceConfig(invtHeadConfig.getInputStream());
        JSONObject root = JSON.parseObject(s);
        JSONObject baseDataJson = root.getJSONObject("baseData");
        BaseDataVo baseData = JSON.parseObject(baseDataJson.toString(), BaseDataVo.class);
        JSONArray list = root.getJSONArray("list");
        for (int i = 0; i < list.size(); i++) {
            JSONObject jsonObject = list.getJSONObject(i);
            InvtHeadVo invtHead = JSON.parseObject(jsonObject.toString(), InvtHeadVo.class);
            invtHead.setCompanyUid(baseData.getCompanyUid());
            invtHead.setCompanyCode(baseData.getCompanyCode());
            invtHead.setCreatorId(baseData.getCreatorId());
            invtHead.setCreatorName(baseData.getCreatorName());
            invtHeads.add(invtHead);
        }
        return invtHeads;
    }
}
