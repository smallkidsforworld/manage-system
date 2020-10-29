package com.transwrap.transwrap.utils;

import com.transwrap.transwrap.entity.FileInfo;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @author ：yml
 * @date ：Created in 2020/10/29 18:15
 * @description：文件工具类
 * @modified By：
 */
public class FileUtil {
    final static String split;

    static {
        if (SystemUtil.ISWINDOWS)
            split = "/";
        else
            split = "\\";
    }

    public static List<FileInfo> getAllFileAbsolutePath(String directoryPath) throws IOException {
        List<FileInfo> list = new ArrayList<>();
        File baseFile = new File(directoryPath);
        if (baseFile.isFile() || !baseFile.exists()) {
            return null;
        }
        File[] files = baseFile.listFiles();
        if (files == null)
            return null;
        for (File file : files) {
            if (file.isDirectory()) {
                list.addAll(Objects.requireNonNull(getAllFileAbsolutePath(file.getAbsolutePath())));
            } else {
                list.add(new FileInfo(absolutePathToRelativePath(file.getAbsolutePath()), String.valueOf(Files.size(file.toPath()))));
            }
        }
        return list;
    }

    public static List<FileInfo> getAllFileRelativePath(String directoryPath) throws IOException {
        return getAllFileAbsolutePath(directoryPath).stream()
                .map(single_file ->
                        {
                            single_file.setFile_name(absolutePathToRelativePath(single_file.getFile_name()));
                            return single_file;
                        }
                ).collect(Collectors.toList());
    }

    public static String absolutePathToRelativePath(String absolutepath) {

        if (SystemUtil.ISWINDOWS)
            return absolutepath.substring(absolutepath.lastIndexOf("\\") + 1);
        else
            return absolutepath.substring(absolutepath.lastIndexOf("/") + 1);
    }


    public static boolean downloadSingleFile(String filePath, HttpServletResponse response) throws IOException {
        File file = new File(filePath);
        if (!file.exists() || file.isDirectory())
            throw new IOException("文件不存在！");
        // 如果是一个文件夹，将文件夹下的所有文件打包
        response.setContentType("application/force-download");// 设置强制下载不打开
        response.addHeader("Content-Disposition", "attachment;fileName=" + FileUtil.absolutePathToRelativePath(filePath));


        return true;
    }

    public static void main(String[] args) {
        System.out.println("absolutePathToRelativePath(\"yml.zip\") = " + absolutePathToRelativePath("yml.zip"));
    }

    public static boolean upLoadFile() {


        return true;
    }
}
