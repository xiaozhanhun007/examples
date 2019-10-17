package com.zzp.print;

import com.zzp.print.enums.SortTypeEnum;
import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @Description 文件工具类
 * @Author zzp
 * @since 2019.10.16
 **/
public class FileUtils {

    /**
     * 获取文件夹下的所有文件
     * @param folder
     * @return
     */
    public static List<String> getFilePaths(File folder) {
        List<String> files = new ArrayList<String>();
        File[] subs = folder.listFiles();
        if (subs != null && subs.length > 0) {
            for (int i = 0; i < subs.length; i++) {
                File sub = subs[i];
                if (sub.isFile()) {
                    files.add(sub.getPath());
                }
            }
            return files;
        }
        return null;
    }

    /**
     * 获取文件夹下的所有文件
     * @param folder
     * @param sortType 排序类型，ASC升序，DESC降序，null表示默认
     * @return
     */
    public static List<String> getFilePaths(File folder, String sortType) {
        List<String> filePaths = getFilePaths(folder);

        if (filePaths == null || filePaths.size() == 0) {
            return filePaths;
        }

        if (StringUtils.isNotBlank(sortType) && sortType.equals(SortTypeEnum.ASC.getCode())){
            // 表示升序
            Collections.sort(filePaths);
        }

        if (StringUtils.isNotBlank(sortType) && sortType.equals(SortTypeEnum.DESC.getCode())){
            // 表示降序
            Collections.sort(filePaths, Collections.<String>reverseOrder());
        }

        return filePaths;
    }

    /**
     * 获取文件夹下的所有文件
     * @param folder
     * @return
     */
    public static List<File> getFiles(File folder) {
        List<File> files = new ArrayList<File>();
        File[] subs = folder.listFiles();
        if (subs != null && subs.length > 0) {
            for (int i = 0; i < subs.length; i++) {
                File sub = subs[i];
                if (sub.isFile()) {
                    files.add(sub);
                }
            }
            return files;
        }
        return null;
    }

    /**
     * 获取文件夹下的所有文件
     * @param folder
     * @param sortType 排序类型，ASC升序，DESC降序，null表示默认
     * @return
     */
    public static List<File> getFiles(File folder, String sortType) {
        List<File> files = getFiles(folder);

        if (files == null || files.size() == 0) {
            return files;
        }

        if (StringUtils.isNotBlank(sortType) && sortType.equals(SortTypeEnum.ASC.getCode())){
            // 表示升序
            Collections.sort(files, new Comparator<File>() {
                @Override
                public int compare(File o1, File o2) {
                    return o1.getName().compareTo(o2.getName());
                }
            });
        }

        if (StringUtils.isNotBlank(sortType) && sortType.equals(SortTypeEnum.DESC.getCode())){
            // 表示降序
            Collections.sort(files, new Comparator<File>() {
                @Override
                public int compare(File o1, File o2) {
                    return o2.getName().compareTo(o1.getName());
                }
            });
        }

        return files;
    }

}
