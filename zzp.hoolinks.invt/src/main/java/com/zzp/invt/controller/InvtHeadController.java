package com.zzp.invt.controller;

import com.zzp.invt.service.IInvtHeadService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Description 核注清单表头controller
 * @Author Garyzeng
 * @since 2019.12.01
 **/
@Controller
@RequestMapping(value = "/invthead")
public class InvtHeadController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private IInvtHeadService invtHeadService;

    @RequestMapping(value = "/createInvtHeadSQL", method = RequestMethod.GET)
    @ResponseBody
    public String createInvtHeadSQL() {
        invtHeadService.createInvtHeadSQL();
        return "success";
    }

}
