package com.zzp.print.resp;

import java.io.Serializable;

/**
 * @Description 合并文件响应
 * @Author zzp
 * @since 2019.10.15
 **/
public class MergeFileResp implements Serializable{

    private static final long serialVersionUID = -1L;

    /**
     * 合并的excel文件路径
     */
    private String mergeExcelFile;

    /**
     * 合并的pdf文件路径
     */
    private String mergePdfFile;

    public String getMergeExcelFile() {
        return mergeExcelFile;
    }

    public void setMergeExcelFile(String mergeExcelFile) {
        this.mergeExcelFile = mergeExcelFile;
    }

    public String getMergePdfFile() {
        return mergePdfFile;
    }

    public void setMergePdfFile(String mergePdfFile) {
        this.mergePdfFile = mergePdfFile;
    }
}
