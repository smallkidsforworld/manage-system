package com.transwrap.transwrap.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * @author ：yml
 * @date ：Created in 2020/10/26 11:04
 * @description：文件上传
 * @modified By：
 */
@Service
public class FileService {

    @Value("${store.path}")
    String file_store_path;

    public static List<String> getAllFile(String directoryPath, boolean isAddDirectory) {
        List<String> list = new ArrayList<String>();
        File baseFile = new File(directoryPath);
        if (baseFile.isFile() || !baseFile.exists()) {
            return list;
        }
        File[] files = baseFile.listFiles();
        for (File file : files) {
            if (file.isDirectory()) {
                if (isAddDirectory) {
                    list.add(absolutepathToRelativePath(file.getAbsolutePath()));
                }
                list.addAll(getAllFile(file.getAbsolutePath(), isAddDirectory));
            } else {
                list.add(absolutepathToRelativePath(file.getAbsolutePath()));
            }
        }
        return list;
    }

    public static String absolutepathToRelativePath(String absolutepath) {
        return absolutepath.substring(absolutepath.lastIndexOf("\\") + 1);
    }

}
