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
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.List;

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
     * 批量将图片插入到对应的excel文件中
     * @param excelFileFolderPath
     * @param imgFolderPath
     * @param imgType
     * @param dx1
     * @param dy1
     * @param dx2
     * @param dy2
     * @param col1
     * @param row1
     * @param col2
     * @param row2
     * @throws Exception
     */
    public static void batchInsertImageToExcel(String excelFileFolderPath, String imgFolderPath, String imgType, int dx1, int dy1, int dx2, int dy2, short col1, int row1, short col2, int row2) throws Exception{
        File excelFileFolder = new File(excelFileFolderPath);
        if (!excelFileFolder.exists()) {
            throw new FileNotFoundException("找不到excelFileFolder文件夹");
        }
        File imgFolder = new File(imgFolderPath);
        if (!imgFolder.exists()) {
            throw new FileNotFoundException("找不到imgFolder文件夹");
        }
        List<String> imgNames = FileUtils.getFilePaths(imgFolder);
        if (imgNames == null || imgNames.size() == 0) {
            throw new FileNotFoundException("imgFolder文件夹不存在图片");
        }
        for (int i = 0; i < imgNames.size(); i++) {
            String imgName = imgNames.get(i);
            String imgNamePrefix = imgName.substring(0, imgName.lastIndexOf("."));
            String excelName = imgNamePrefix + ".xls";
            String imgPath = imgFolderPath + File.separator + imgName;
            String excelFilePath = excelFileFolderPath + File.separator + excelName;
            insertImageToExcel(excelFilePath, imgPath, imgType, dx1, dy1, dx2, dy2, col1, row1, col2, row2);
        }
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
        File excelFile = new File(excelFilePath);
        if (!excelFile.exists()) {
            throw new FileNotFoundException("找不到excelFile文件");
        }
        File imgFile = new File(imgPath);
        if (!imgFile.exists()) {
            throw new FileNotFoundException("找不到img文件");
        }
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
