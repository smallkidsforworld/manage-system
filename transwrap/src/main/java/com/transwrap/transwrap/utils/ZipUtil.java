package com.transwrap.transwrap.utils;


import org.springframework.beans.factory.annotation.Value;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipOutputStream;

public class ZipUtil {

    public static void unZip(File zipPath, String descDir) throws IOException {
        if (SystemUtil.ISWINDOWS)
            unZipFilesWindows(zipPath, descDir);

    }



    /*
     * 压缩文件夹下的所有文件到压缩包
     * 返回生成的压缩包的文件路径
     */


    /*
     * list文件压缩
     */
    public static File zipFileList(String temp_name, String... paths) throws IOException {
        File zipFile = new File(temp_name);
        for (String path : paths) {
            File file = new File(path);
            if (!file.exists() || file.isDirectory())
                throw new IOException("路径异常，不存在文件或该目录不是文件夹");
            try (ZipOutputStream outputStream = new ZipOutputStream(new FileOutputStream(zipFile))) {
                outputStream.putNextEntry(new ZipEntry(FileUtil.absolutePathToRelativePath(path)));
                outputStream.write(Files.readAllBytes(file.toPath()));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return zipFile;
    }


    /**
     * 解压文件到指定目录
     */
    public static void unZipFilesWindows(File zipFile, String descDir) throws IOException {

////        获取除了文件后缀名的文件名
        descDir = descDir + zipFile.getName().split("\\.")[0] + "\\";
        File pathFile = new File(descDir);
        if (!pathFile.exists()) {
            pathFile.mkdirs();
        }
        //解决zip文件中有中文目录或者中文文件
        ZipFile zip = new ZipFile(zipFile, Charset.forName("GBK"));
        for (Enumeration entries = zip.entries(); entries.hasMoreElements(); ) {
            ZipEntry entry = (ZipEntry) entries.nextElement();
            String zipEntryName = entry.getName();
            InputStream in = zip.getInputStream(entry);
            String outPath = (descDir + zipEntryName).replaceAll("/", "\\");
            ;
            //判断路径是否存在,不存在则创建文件路径
            File file = new File(outPath.substring(0, outPath.lastIndexOf("\\")));
            if (!file.exists()) {
                file.mkdirs();
            }
            OutputStream out = new FileOutputStream(outPath);
            byte[] buf1 = new byte[1024];
            int len;
            while ((len = in.read(buf1)) > 0) {
                out.write(buf1, 0, len);
            }
            in.close();
            out.close();
        }
    }


    public static void main(String[] args) throws IOException {
        unZipFilesWindows(new File("C:\\yml.zip"), "C:\\Users\\hbwxc\\manual\\");
    }
}
