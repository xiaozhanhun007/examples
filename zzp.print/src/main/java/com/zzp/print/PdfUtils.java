package com.zzp.print;

import com.aspose.cells.License;
import com.aspose.cells.PdfSaveOptions;
import com.aspose.cells.Workbook;
import com.hlc.log.exception.BusinessException;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfCopy;
import com.itextpdf.text.pdf.PdfImportedPage;
import com.itextpdf.text.pdf.PdfReader;
import com.zzp.print.option.ExcelPrintSetupOption;
import com.zzp.print.resp.MergeFileResp;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

/**
 * @Description PDF工具类
 * @Author zzp
 * @since 2019.10.16
 **/
public class PdfUtils {

    private static Logger logger = LoggerFactory.getLogger(PdfUtils.class);

    /**
     * 将数据到excel文件中，并且将导出的excel文件合并成一个pdf文件
     * @param excelTemplateFilePath excel导出模板文件路径
     * @param exportFolderPath 导出合并文件的文件夹路径
     * @param exportDatas 要导出的数据集合
     */
    public static MergeFileResp merge(
            String excelTemplateFilePath,
            String exportFolderPath,
            Map<String, Map<String, Object>> exportDatas
    ) throws Exception {
        String exportExcelFolderPath = exportFolderPath + File.separator + "excel";
        String exportPdfFolderPath = exportFolderPath + File.separator + "pdf";
        return merge(excelTemplateFilePath, exportFolderPath, exportExcelFolderPath, exportPdfFolderPath, exportDatas, null, null, null);
    }

    /**
     * 将数据到excel文件中，并且将导出的excel文件合并成一个pdf文件
     * @param excelTemplateFilePath excel导出模板文件路径
     * @param exportFolderPath 导出合并文件的文件夹路径
     * @param exportDatas 要导出的数据集合
     * @param pageCountMap excel转换为pdf文件，pdf文件的页数，Map<K, V> K为对应的excel文件名，V为pdf文件的页数
     * @param printSetupOption 合并后excel文件的打印格式参数设置
     * @param mergeSortType 合并的顺序，根据文件名来升序合并或者是降序合并，为null则表示按照默认的顺序
     */
    public static MergeFileResp merge(
            String excelTemplateFilePath,
            String exportFolderPath,
            Map<String, Map<String, Object>> exportDatas,
            Map<String, Integer> pageCountMap,
            ExcelPrintSetupOption printSetupOption,
            String mergeSortType
    ) throws Exception {
        String exportExcelFolderPath = exportFolderPath + File.separator + "excel";
        String exportPdfFolderPath = exportFolderPath + File.separator + "pdf";
        return merge(excelTemplateFilePath, exportFolderPath, exportExcelFolderPath, exportPdfFolderPath, exportDatas, pageCountMap, printSetupOption, mergeSortType);
    }

    /**
     * 将数据到excel文件中，并且将导出的excel文件合并成一个pdf文件
     * @param excelTemplateFilePath excel导出模板文件路径
     * @param exportFolderPath 导出合并文件的文件夹路径
     * @param exportExcelFolderPath 导出excel文件夹路径
     * @param exportPdfFolderPath 导出pdf文件夹路径
     * @param exportDatas 要导出的数据集合
     * @param pageCountMap excel转换为pdf文件，pdf文件的页数，Map<K, V> K为对应的excel文件名，V为pdf文件的页数
     * @param printSetupOption 合并后excel文件的打印格式参数设置
     * @param mergeSortType 合并的顺序，根据文件名来升序合并或者是降序合并，为null则表示按照默认的顺序
     */
    public static MergeFileResp merge(
            String excelTemplateFilePath,
            String exportFolderPath,
            String exportExcelFolderPath,
            String exportPdfFolderPath,
            Map<String, Map<String, Object>> exportDatas,
            Map<String, Integer> pageCountMap,
            ExcelPrintSetupOption printSetupOption,
            String mergeSortType
    ) throws Exception {
        logger.info("导出excel文件并合并为pdf，开始");
        long startTime = System.currentTimeMillis();
        MergeFileResp resp = new MergeFileResp();

        // 先将数据导出到excel文件中，并且将其合并成一个excel文件
        String mergeExcelFilePath = ExcelUtils.exportAndMerge(excelTemplateFilePath, exportFolderPath, exportExcelFolderPath, exportDatas, printSetupOption, mergeSortType);
        resp.setMergeExcelFile(mergeExcelFilePath);

        // 创建存放pdf文件的文件夹
        File exportPdfFolder = new File(exportPdfFolderPath);
        exportPdfFolder.mkdirs();

        // 将导出的excel文件转换成pdf文件
        if (!getLicense()) {
            throw new BusinessException("excel转pdf文件的aspose工具验证错误");
        }
        logger.info("导出excel文件并合并为pdf，将导出的excel文件转换成pdf文件，开始");
        long convertPdfStartTime = System.currentTimeMillis();
        List<File> excelFiles = FileUtils.getFiles(new File(exportExcelFolderPath));
        for (int i = 0; i < excelFiles.size(); i++) {
            String excelName = excelFiles.get(i).getName();
            String pdfName = excelName.substring(0, excelName.lastIndexOf(".")) + ".pdf";
            // 获取转换为pdf文件的页数
            Integer pageCount = pageCountMap.get(excelName);
            excel2pdf(excelFiles.get(i).getPath(), exportPdfFolderPath + File.separator + pdfName, pageCount);
        }
        long convertPdfEndTime = System.currentTimeMillis();
        logger.info("导出excel文件并合并为pdf，将导出的excel文件转换成pdf文件，结束，耗时：" + (convertPdfEndTime - convertPdfStartTime) + "毫秒");

        // 将转换的pdf文件合并成一个pdf文件
        List<File> pdfFiles = FileUtils.getFiles(exportPdfFolder);
        if (pdfFiles == null || pdfFiles.size() == 0) {
            throw new BusinessException("不存在由excel转换的pdf文件");
        }

        logger.info("导出excel文件并合并为pdf，将转换的pdf文件合并成一个pdf文件，开始");
        long mergePdfStartTime = System.currentTimeMillis();
        String mergePdfFilePath = exportFolderPath + File.separator + "merge.pdf";
        merge(exportPdfFolderPath, mergePdfFilePath, mergeSortType);
        long mergePdfEndTime = System.currentTimeMillis();
        logger.info("导出excel文件并合并为pdf，将转换的pdf文件合并成一个pdf文件，结束，耗时：" + (mergePdfEndTime - mergePdfStartTime) + "毫秒");

        File mergePdfFile = new File(mergePdfFilePath);
        if (!mergePdfFile.exists()) {
            throw new BusinessException("不存在合并的merge.pdf文件");
        }
        resp.setMergePdfFile(mergePdfFilePath);

        long endTime = System.currentTimeMillis();
        logger.info("导出excel文件并合并为pdf，结束，耗时：" + (endTime - startTime) + "毫秒");

        return resp;
    }

    /**
     * 获取aspose工具的注册文件
     * @return
     */
    public static boolean getLicense() {
        boolean result = false;
        try {
            InputStream is = PdfUtils.class.getClassLoader().getResourceAsStream("license.xml");// license.xml文件存放在resources资源文件下
            License aposeLic = new License();
            aposeLic.setLicense(is);
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * excel转PDF
     *
     * @param excelAllPath excel文件路径
     * @param pdfAllPath 转换后的pdf文件路径
     * @param pageCount 转换后的pdf文件页数
     */
    public static void excel2pdf(String excelAllPath, String pdfAllPath, Integer pageCount) throws Exception{
        File pdfFile = new File(pdfAllPath);

        File file = new File(excelAllPath);
        if (file.exists()) {
            logger.info("Excel转PDF开始, Excel文件大小为:{} kb", file.length()/1024);
        }

        try (FileOutputStream fileOS = new FileOutputStream(pdfFile)){
            Workbook wb = new Workbook(excelAllPath);
            PdfSaveOptions saveOptions = new PdfSaveOptions();
            saveOptions.setAllColumnsInOnePagePerSheet(true);
            if (pageCount != null) {
                saveOptions.setPageCount(pageCount.intValue());
            }
            wb.save(fileOS, saveOptions);
            fileOS.flush();
            if (pdfFile.exists()) {
                logger.info("Excel转PDF成功, 文件路径:{}, PDF文件大小为:{} kb", excelAllPath,  pdfFile.length()/1024);
            } else {
                logger.warn("Excel转PDF失败, PDF文件不存在, 文件路径:{}", pdfAllPath);
            }
        } catch (Exception e) {
            logger.error("Excel转PDF异常", e);
            throw e;
        }
    }

    /**
     * 合并文件夹下的pdf文件，并将合并后的内容输出到目标文件
     * @param fileDir 存放pdf文件的文件夹
     * @param destinationFile 合并后的pdf文件
     * @param mergeSortType 合并的顺序，根据文件名来升序合并或者是降序合并，为null则表示按照默认的顺序
     * @throws Exception
     */
    public static void merge(String fileDir, String destinationFile, String mergeSortType) throws Exception {
        File folder = new File(fileDir);
        if (!folder.exists()) {
            throw new FileNotFoundException(fileDir + "找不到对应目录");
        }

        if (!folder.isDirectory()) {
            throw new FileNotFoundException(fileDir + "不是目录");
        }

        List<String> files = FileUtils.getFilePaths(folder, mergeSortType);

        mergePdfFiles(files, destinationFile);

    }

    public static void mergePdfFiles(List<String> files, String savepath){
        String[] strs = new String[files.size()];
        files.toArray(strs);
        mergePdfFiles(strs, savepath);
    }

    public static void mergePdfFiles(String[] files, String savepath){
        try {
            PdfReader firstPdfReader = new PdfReader(files[0]);
            Document document = new Document(firstPdfReader.getPageSize(1));
            PdfCopy copy = new PdfCopy(document, new FileOutputStream(savepath));
            document.open();
            for(int i=0; i<files.length; i++) {
                PdfReader reader = new PdfReader(files[i]);
                int n = reader.getNumberOfPages();
                for(int j=1; j<=n; j++) {
                    document.newPage();
                    PdfImportedPage page = copy.getImportedPage(reader, j);
                    copy.addPage(page);
                }
                reader.close();
            }
            firstPdfReader.close();
            document.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch(DocumentException e) {
            e.printStackTrace();
        }
    }

}
