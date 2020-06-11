package com.zzp.invt.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zzp.invt.entity.EntBillDetail;
import com.zzp.invt.entity.EntBillHead;
import com.zzp.invt.entity.InvtDetail;
import com.zzp.invt.entity.InvtHead;
import com.zzp.invt.entity.vo.BaseDataVo;
import com.zzp.invt.entity.vo.InvtDetailVo;
import com.zzp.invt.entity.vo.InvtHeadVo;
import com.zzp.invt.mapper.InvtHeadMapper;
import com.zzp.invt.service.IEntBillDetailService;
import com.zzp.invt.service.IEntBillHeadService;
import com.zzp.invt.service.IInvtDetailService;
import com.zzp.invt.service.IInvtHeadService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private InvtHeadMapper invtHeadMapper;

    @Autowired
    private IEntBillHeadService entBillHeadService;

    @Autowired
    private IEntBillDetailService entBillDetailService;

    @Autowired
    private IInvtDetailService invtDetailService;

    public void createInvtHeadSQL() {
        try {
            List<InvtHeadVo> invtHeads = this.initInvtHead();
            if (invtHeads == null || invtHeads.size() <= 0) {
                System.out.println("核注清单表头信息为空，无法生成脚本SQL");
                return;
            }
            for (int i = 0; i < invtHeads.size(); i++) {
                InvtHeadVo invtHead = invtHeads.get(i);
                System.out.println("-- 清单编号：" + invtHead.getBondInvtNo() + "， 平台单证号：" + invtHead.getCitDocNo() + "， 计划单号：" + invtHead.getEntBillNo());
                System.out.println("INSERT INTO `essdb`.`dcl_invt_head`(`company_code`, `company_uid`, `creater_id`, `creater_name`, `updater_id`, `updater_name`, `create_time`, `update_time`, `group_uid`, `group_name`, `bond_invt_no`) ");
                System.out.println("VALUES ('" + invtHead.getCompanyCode() + "', '" + invtHead.getCompanyUid() + "', '" + invtHead.getCreatorId() + "', '" + invtHead.getCreatorName() + "', '" + invtHead.getCreatorId() + "', '" + invtHead.getCreatorName() + "', NOW(), NOW(), NULL, NULL, '" + invtHead.getBondInvtNo() + "');");
                System.out.println();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void createInvtDetailSQL() {
        try {
            List<InvtDetailVo> invtDetails = this.initInvtDetail();
            if (invtDetails == null || invtDetails.size() <= 0) {
                System.out.println("核注清单表体信息为空，无法生成脚本SQL");
                return;
            }
            for (int i = 0; i < invtDetails.size(); i++) {
                InvtDetailVo invtDetail = invtDetails.get(i);
                System.out.println("-- 清单编号：" + invtDetail.getBondInvtNo() + "， 平台单证号：" + invtDetail.getCitDocNo() + "， 计划单号：" + invtDetail.getEntBillNo());

                if (invtDetail.getId() == null) {
                    System.out.println("-- 核注清单表头id为空，无法生成脚本SQL");
                    continue;
                }

                for (int j = 0; j < invtDetail.getDetailSize(); j++) {
                    System.out.println("INSERT INTO `essdb`.`dcl_invt_detail`(`company_code`, `company_uid`, `creater_id`, `creater_name`, `updater_id`, `updater_name`, `create_time`, `update_time`, `group_uid`, `group_name`, `invt_head_id`, `gds_seqno`) ");
                    System.out.println("VALUES ('" + invtDetail.getCompanyCode() + "', '" + invtDetail.getCompanyUid() + "', '" + invtDetail.getCreatorId() + "', '" + invtDetail.getCreatorName() + "', '" + invtDetail.getCreatorId() + "', '" + invtDetail.getCreatorName() + "', NOW(), NOW(), NULL, NULL, " + invtDetail.getId() + ", " + (j + 1) + ");");
                }

                System.out.println();
                System.out.println();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void createRelationSQL() {
        try {
            List<InvtHeadVo> invtHeads = this.initInvtHead();
            if (invtHeads == null || invtHeads.size() <= 0) {
                System.out.println("核注清单表头信息为空，无法生成脚本SQL");
                return;
            }
            StringBuffer sql = new StringBuffer();
            for (int i = 0; i < invtHeads.size(); i++) {
                InvtHeadVo invtHead = invtHeads.get(i);
                sql.append("-- 清单编号：" + invtHead.getBondInvtNo() + "， 平台单证号：" + invtHead.getCitDocNo() + "， 计划单号：" + invtHead.getEntBillNo() + "\n");

                // 查找计划单表头
                EntBillHead entBillHeadVo = entBillHeadService.getEntBillHead(invtHead.getCompanyUid(), invtHead.getEntBillNo());
                if (entBillHeadVo == null) {
                    sql.append("-- 计划单表头为空，无法生成脚本SQL\n");
                    continue;
                }

                // 查找核注清单表头
                InvtHead invtHeadVo = this.getInvtHead(invtHead.getBondInvtNo(), invtHead.getCompanyUid());
                if (invtHeadVo == null) {
                    sql.append("-- 核注清单表头为空，无法生成脚本SQL\n");
                    continue;
                }

                sql.append("-- 表头关系\n");
                sql.append("INSERT INTO `essdb`.`dcl_ent_invt_head_relation`(`ent_bill_head_id`, `ent_invt_head_id`, `company_uid`, `company_code`, `creater_id`, `creater_name`, `updater_id`, `updater_name`, `create_time`, `update_time`, `group_uid`, `group_name`, `version`) \n");
                sql.append("VALUES (" + entBillHeadVo.getId() + ", " + invtHeadVo.getId() + ", '" + invtHead.getCompanyUid() + "', '" + invtHead.getCompanyCode() + "', '" + invtHead.getCreatorId() + "', '" + invtHead.getCreatorName() + "', '" + invtHead.getCreatorId() + "', '" + invtHead.getCreatorName() + "', NOW(), NOW(), NULL, NULL, NULL);\n");
                sql.append("\n");

                sql.append("-- 将计划单的是否已转核注清单状态设置为已转\n");
                sql.append("UPDATE dcl_ent_bill_detail AS t SET t.is_transform_invt = 1 WHERE t.ent_bill_head_id = " + entBillHeadVo.getId() + ";\n");
                sql.append("\n");

                // 根据计划单表头id查找计划单表体
                sql.append("-- 表体关系\n");
                List<EntBillDetail> entBillDetails = entBillDetailService.listEntBillDetails(entBillHeadVo.getId());
                if (entBillDetails == null || entBillDetails.size() <= 0) {
                    sql.append("-- 计划单表体为空，无法生成脚本SQL\n");
                    continue;
                }
                for (int j = 0; j < entBillDetails.size(); j++) {
                    EntBillDetail entBillDetail = entBillDetails.get(j);
                    Integer gdsSeqno = entBillDetail.getGdsSeqno();// 计划单表体备案序号

                    // 查找对应的核注清单表体
                    List<InvtDetail> invtDetails = invtDetailService.listInvtDetails(invtHead.getCitDocNo(), invtHead.getCompanyUid(), gdsSeqno);
                    if (CollectionUtils.isEmpty(invtDetails)) {
                        // 查询不到核注清单表体明细，需要人工进行判断
                        sql.append("-- 查询不到核注清单表体明细，需要人工进行判断，计划单表体备案序号：" + gdsSeqno);
                        continue;
                    } else if (invtDetails.size() > 1) {
                        // 计划单表体备案序号对应多个核注清单表体备案序号，需要人工进行判断
                        sql.append("-- 计划单表体备案序号对应多个核注清单表体备案序号，需要人工进行判断，计划单表体备案序号：" + gdsSeqno + "，核注清单表体备案序号：" + invtDetailService.filterPutrecSeqnos(invtDetails));
                        continue;
                    }

                    InvtDetail invtDetail = invtDetails.get(0);

                    sql.append("INSERT INTO `essdb`.`dcl_ent_invt_detail_relation`(`ent_bill_detail_id`, `ent_invt_detail_id`, `company_uid`, `company_code`, `creater_id`, `creater_name`, `updater_id`, `updater_name`, `create_time`, `update_time`, `group_uid`, `group_name`, `version`) \n");
                    sql.append("VALUES ('" + entBillDetail.getId() + "','" + invtDetail.getId() + "','" + invtHead.getCompanyUid() + "', '" + invtHead.getCompanyCode() + "', '" + invtHead.getCreatorId() + "', '" + invtHead.getCreatorName() + "', '" + invtHead.getCreatorId() + "', '" + invtHead.getCreatorName() + "', NOW(), NOW(), NULL, NULL, NULL);\n");
                }
                sql.append("\n\n\n\n\n");
            }
            System.out.println(sql.toString());
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

    private List<InvtHeadVo> initInvtHead() throws IOException {
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

    private List<InvtDetailVo> initInvtDetail() throws IOException {
        List<InvtDetailVo> invtDetails = new ArrayList<InvtDetailVo>();
        String s = this.getResourceConfig(invtHeadConfig.getInputStream());
        JSONObject root = JSON.parseObject(s);
        JSONObject baseDataJson = root.getJSONObject("baseData");
        BaseDataVo baseData = JSON.parseObject(baseDataJson.toString(), BaseDataVo.class);
        JSONArray list = root.getJSONArray("list");
        for (int i = 0; i < list.size(); i++) {
            JSONObject jsonObject = list.getJSONObject(i);
            InvtDetailVo invtDetail = JSON.parseObject(jsonObject.toString(), InvtDetailVo.class);
            invtDetail.setCompanyUid(baseData.getCompanyUid());
            invtDetail.setCompanyCode(baseData.getCompanyCode());
            invtDetail.setCreatorId(baseData.getCreatorId());
            invtDetail.setCreatorName(baseData.getCreatorName());

            // 查找核注清单表头id
            InvtHead invtHead = this.getInvtHead(invtDetail.getBondInvtNo(), invtDetail.getCompanyUid());
            if (invtHead != null) {
                invtDetail.setId(invtHead.getId());
            }

            invtDetails.add(invtDetail);
        }
        return invtDetails;
    }

    public InvtHead getInvtHead(String bondInvtNo, String companyUid) {
        QueryWrapper<InvtHead> queryWrapper = new QueryWrapper<InvtHead>();
        queryWrapper.eq("company_uid", companyUid);
        queryWrapper.eq("bond_invt_no", bondInvtNo);
        List<InvtHead> invtHeads = invtHeadMapper.selectList(queryWrapper);
        if (invtHeads == null || invtHeads.size() <= 0) {
            return null;
        }
        return invtHeads.get(0);
    }

    @Override
    public InvtHead getInvtHeadByInnerInvtNo(String etpsInnerInvtNo, String companyUid) {
        LambdaQueryWrapper<InvtHead> queryWrapper = new LambdaQueryWrapper<InvtHead>();
        queryWrapper.eq(InvtHead::getEtpsInnerInvtNo, etpsInnerInvtNo);
        queryWrapper.eq(InvtHead::getCompanyUid, companyUid);
        List<InvtHead> invtHeads = invtHeadMapper.selectList(queryWrapper);
        if (invtHeads == null || invtHeads.size() <= 0) {
            return null;
        }
        return invtHeads.get(0);
    }
}
