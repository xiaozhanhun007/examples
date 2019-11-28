package com.zzp.print;

import org.apache.poi.hssf.usermodel.HSSFClientAnchor;
import org.apache.poi.hssf.usermodel.HSSFPatriarch;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;

/**
 * @Description excel插入图片工具
 * @Author Garyzeng
 * @since 2019.11.21
 **/
public class ExcelImageUtils {

    public static void insertImageToExcel(String excelFilePath, String imgPath, String imgType) throws Exception{
        insertImageToExcel(excelFilePath, imgPath, imgType, 0, 0, 0, 0, (short) 38, 0, (short) 51, 1);
    }

    /**
     * 插入图片到excel文件中
     * @param excelFilePath excel文件路径
     * @param imgPath 图片路径
     * @param imgType 图片类型
     * @param dx1 起始单元格x坐标
     * @param dy1 起始单元格y坐标
     * @param dx2 结束单元格x坐标
     * @param dy2 结束单元格y坐标
     * @param col1 指定起始的单元格列，下标从0开始
     * @param row1 指定起始的单元格行，下标从0开始
     * @param col2 指定结束的单元格列，下标从0开始
     * @param row2 指定结束的单元格行，下标从0开始
     * @throws Exception
     */
    public static void insertImageToExcel(String excelFilePath, String imgPath, String imgType, int dx1, int dy1, int dx2, int dy2, short col1, int row1, short col2, int row2) throws Exception{
        int PICTURE_TYPE = 0;
        if (imgType.equals("png")) {
            PICTURE_TYPE = HSSFWorkbook.PICTURE_TYPE_PNG;
        } else if(imgType.equals("jpg")) {
            PICTURE_TYPE = HSSFWorkbook.PICTURE_TYPE_JPEG;
        }
        InputStream in = new FileInputStream(excelFilePath);
        HSSFWorkbook wb = new HSSFWorkbook(in);

        ByteArrayOutputStream byteArrayOut = new ByteArrayOutputStream();
        BufferedImage bufferImg = ImageIO.read(new File(imgPath));
        ImageIO.write(bufferImg, imgType, byteArrayOut);
        HSSFSheet sheet1 = wb.getSheetAt(0);
        HSSFPatriarch patriarch = sheet1.createDrawingPatriarch();
        HSSFClientAnchor anchor = new HSSFClientAnchor(dx1, dy1, dx2, dy2, col1, row1, col2, row2);
        patriarch.createPicture(anchor, wb.addPicture(byteArrayOut.toByteArray(), PICTURE_TYPE));
        FileOutputStream fileOut = new FileOutputStream(excelFilePath);
        wb.write(fileOut);
    }

    public static void main(String[] args) {
        try {
            System.out.println("插入开始");
            insertImageToExcel("E:\\zzp\\exceltest\\merge.xls", "E:\\zzp\\exceltest\\test.png", "png");
            System.out.println("插入完成");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
