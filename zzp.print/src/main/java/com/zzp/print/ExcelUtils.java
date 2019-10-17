package com.zzp.print;

import com.zzp.print.exception.BusinessException;
import com.zzp.print.option.ExcelPrintSetupOption;
import net.sf.jxls.transformer.XLSTransformer;
import org.apache.poi.hssf.usermodel.HSSFPrintSetup;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

/**
 * @Description excel工具类
 * @Author zzp
 * @since 2019.10.16
 **/
public class ExcelUtils {

    private static Logger logger = LoggerFactory.getLogger(ExcelUtils.class);

    /**
     * 将数据导出到excel模板文件中
     * @param excelTemplateFilePath excel模板文件路径
     * @param exportExcelFilePath 导出的excel文件路径
     * @param exportData 导出的数据
     */
    public static boolean exportExcel(String excelTemplateFilePath, String exportExcelFilePath, Map<String, Object> exportData) throws BusinessException, InvalidFormatException, IOException {
        File excelTemplateFile = new File(excelTemplateFilePath);
        if (!excelTemplateFile.exists()) {
            throw new BusinessException("不存在导出excel模板文件");
        }

        if (exportData == null || exportData.size() == 0) {
            throw new BusinessException("不存在需要导出的数据");
        }

        XLSTransformer transformer = new XLSTransformer();
        transformer.transformXLS(excelTemplateFilePath, exportData, exportExcelFilePath);

        File exportExcelFile = new File(exportExcelFilePath);
        return exportExcelFile.exists();
    }

    public static void merge(String excelFolderPath, String destinationFile) throws Exception {
        merge(excelFolderPath, destinationFile, null, null);
    }

    public static void merge(String excelFolderPath, String destinationFile, String mergeSortType) throws Exception {
        merge(excelFolderPath, destinationFile, null, mergeSortType);
    }

    /**
     * 合并excel文件
     * @param excelFolderPath 要合并的excel文件目录
     * @param destinationFile 合并之后的excel文件名称
     * @param printSetupOption 合并之后的excel文件的打印参数
     * @param mergeSortType 合并的顺序，根据文件名来升序合并或者是降序合并，为null则表示按照默认的顺序
     * @throws Exception
     */
    public static void merge(String excelFolderPath, String destinationFile, ExcelPrintSetupOption printSetupOption, String mergeSortType) throws Exception {
        File folder = new File(excelFolderPath);
        if (!folder.exists()) {
            throw new FileNotFoundException(excelFolderPath + "找不到对应目录");
        }

        if (!folder.isDirectory()) {
            throw new FileNotFoundException(excelFolderPath + "不是目录");
        }

        // 获取文件夹下的excel文件
        List<File> excelFiles = FileUtils.getFiles(folder, mergeSortType);
        if (excelFiles == null || excelFiles.size() == 0) {
            throw new FileNotFoundException(excelFolderPath + "找不到excel文件");
        }

        // 合成后的excel文件
        HSSFWorkbook destinationExcel = new HSSFWorkbook();
        for (int i = 0; i < excelFiles.size(); i++) {
            File excelFile = excelFiles.get(i);
            InputStream in = new FileInputStream(excelFile);
            HSSFWorkbook excel = new HSSFWorkbook(in);
            for (int j = 0; j < excel.getNumberOfSheets(); j++) {
                HSSFSheet oldSheet = excel.getSheetAt(j);
                String sheetName = excelFile.getName().substring(0, excelFile.getName().lastIndexOf("."));
                HSSFSheet newSheet = destinationExcel.createSheet(sheetName);
                if (printSetupOption != null) {
                    setPrintOptions(newSheet, printSetupOption);
                }
                PoiUtils.copySheet(newSheet, oldSheet, destinationExcel, excel);
            }
        }

        FileOutputStream outputStream = new FileOutputStream(destinationFile);
        destinationExcel.write(outputStream);
        outputStream.flush();
        outputStream.close();

    }

    /**
     * 设置打印参数
     * @param newSheet
     * @param option
     */
    private static void setPrintOptions(HSSFSheet newSheet, ExcelPrintSetupOption option) {
        HSSFPrintSetup ps = newSheet.getPrintSetup();
        if (option.getLandscape() != null) {
            ps.setLandscape(option.getLandscape().booleanValue()); // 打印方向，true：横向，false：纵向
        }

        if (option.getPaperSize() != null) {
            ps.setPaperSize(option.getPaperSize().shortValue()); //纸张
        }

        if (option.getTopMargin() != null) {
            newSheet.setMargin(HSSFSheet.TopMargin, option.getTopMargin().doubleValue());// 页边距（上）
        }

        if (option.getBottomMargin() != null) {
            newSheet.setMargin(HSSFSheet.BottomMargin, option.getBottomMargin().doubleValue());// 页边距（下）
        }

        if (option.getLeftMargin() != null) {
            newSheet.setMargin(HSSFSheet.LeftMargin, option.getLeftMargin().doubleValue());// 页边距（左）
        }

        if (option.getRightMargin() != null) {
            newSheet.setMargin(HSSFSheet.RightMargin, option.getRightMargin().doubleValue());// 页边距（右）
        }

        if (option.getHeaderMargin() != null) {
            newSheet.setMargin(HSSFSheet.HeaderMargin, option.getHeaderMargin().doubleValue());// 页眉
        }

        if (option.getFooterMargin() != null) {
            newSheet.setMargin(HSSFSheet.FooterMargin, option.getFooterMargin().doubleValue());// 页脚
        }

        if (option.getHorizontallyCenter() != null) {
            newSheet.setHorizontallyCenter(option.getHorizontallyCenter().booleanValue());//设置打印页面为水平居中
        }

        if (option.getVerticallyCenter() != null) {
            newSheet.setVerticallyCenter(option.getVerticallyCenter().booleanValue());//设置打印页面为垂直居中使用POI输出Excel时打印页面的设置
        }

        if (option.getRepeatingRows() != null) {
            newSheet.setRepeatingRows(option.getRepeatingRows());// 设置打印标题
        }
    }

    /**
     * 将导出的excel文件合并成一个excel文件
     * @param excelTemplateFilePath excel模板文件路径
     * @param exportFolderPath 导出合并文件文件夹路径
     * @param exportDatas 导出的数据集合
     * @param printSetupOption 合并后的excel文件的打印格式设置
     * @param mergeSortType 合并的顺序，根据文件名来升序合并或者是降序合并，为null则表示按照默认的顺序
     */
    public static String exportAndMerge(
            String excelTemplateFilePath,
            String exportFolderPath,
            Map<String, Map<String, Object>> exportDatas,
            ExcelPrintSetupOption printSetupOption,
            String mergeSortType
    ) throws Exception {
        String exportExcelFolderPath = exportFolderPath + File.separator + "excel";
        return exportAndMerge(excelTemplateFilePath, exportFolderPath, exportExcelFolderPath, exportDatas, printSetupOption, mergeSortType);
    }

    /**
     * 将导出的excel文件合并成一个excel文件
     * @param excelTemplateFilePath excel模板文件路径
     * @param exportFolderPath 导出合并文件文件夹路径
     * @param exportExcelFolderPath 导出excel文件夹路径
     * @param exportDatas 导出的数据集合
     * @param printSetupOption 合并后的excel文件的打印格式设置
     * @param mergeSortType 合并的顺序，根据文件名来升序合并或者是降序合并，为null则表示按照默认的顺序
     */
    public static String exportAndMerge(
            String excelTemplateFilePath,
            String exportFolderPath,
            String exportExcelFolderPath,
            Map<String, Map<String, Object>> exportDatas,
            ExcelPrintSetupOption printSetupOption,
            String mergeSortType
    ) throws Exception {
        logger.info("导出excel并合并excel文件，开始");
        long startTime = System.currentTimeMillis();
        File excelTemplateFile = new File(excelTemplateFilePath);
        if (!excelTemplateFile.exists()) {
            throw new BusinessException("不存在导出excel模板文件");
        }

        if (exportDatas == null || exportDatas.size() == 0) {
            throw new BusinessException("不存在需要导出的数据集合");
        }

        // 创建导出合并文件文件夹
        File exportFolder = new File(exportFolderPath);
        exportFolder.mkdirs();
        // 创建存放excel文件的文件夹
        File exportExcelFolder = new File(exportExcelFolderPath);
        exportExcelFolder.mkdirs();

        // 将数据导出到excel文件中
        logger.info("导出excel并合并excel文件，将数据导出到excel文件中，开始");
        long exportExcelStartTime = System.currentTimeMillis();
        for (Map.Entry<String, Map<String, Object>> entry : exportDatas.entrySet()) {
            String exportExcelFilePath = exportExcelFolder + File.separator + entry.getKey();
            ExcelUtils.exportExcel(excelTemplateFilePath, exportExcelFilePath, entry.getValue());
        }
        long exportExcelEndTime = System.currentTimeMillis();
        logger.info("导出excel并合并excel文件，将数据导出到excel文件中，结束，耗时：" + (exportExcelEndTime - exportExcelStartTime) + "毫秒");

        List<File> excelFiles = FileUtils.getFiles(exportExcelFolder);
        if (excelFiles == null || excelFiles.size() == 0) {
            throw new BusinessException("不存在导出的excel文件");
        }

        // 将导出的excel文件合并成一个excel文件
        logger.info("导出excel并合并excel文件，将导出的excel文件合并成一个excel文件，开始");
        long mergeExcelStartTime = System.currentTimeMillis();
        String destinationExcelFile = exportFolderPath + File.separator + "merge.xls";
        ExcelUtils.merge(exportExcelFolderPath, destinationExcelFile, printSetupOption, mergeSortType);
        long mergeExcelEndTime = System.currentTimeMillis();
        logger.info("导出excel并合并excel文件，将导出的excel文件合并成一个excel文件，结束，耗时：" + (mergeExcelEndTime - mergeExcelStartTime) + "毫秒");

        File mergeExcelFile = new File(destinationExcelFile);
        if (!mergeExcelFile.exists()) {
            throw new BusinessException("不存在合并的merge.xls文件");
        }
        long endTime = System.currentTimeMillis();
        logger.info("导出excel并合并excel文件，结束，耗时：" + (endTime - startTime) + "毫秒");

        return destinationExcelFile;

    }

}
