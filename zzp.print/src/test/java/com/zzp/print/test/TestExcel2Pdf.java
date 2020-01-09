package com.zzp.print.test;

import com.zzp.print.PdfUtils;

/**
 * @Description 测试excel转pdf
 * @Author Garyzeng
 * @since 2020.01.06
 **/
public class TestExcel2Pdf {

    public static void main(String[] args) {
        try {
            PdfUtils.excel2pdf("E:\\scmtemp\\hlctest\\excel\\test.xls", "E:\\scmtemp\\hlctest\\excel\\test.pdf", 5);
            System.out.println("转换完成");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
