package com.transwrap.transwrap.test;


import java.io.*;
import java.nio.file.Files;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author ：yml
 * @date ：Created in 2020/10/26 15:57
 * @description：将包含多个groovy的sql文件生成多个groovy脚本
 * @modified By：
 */
public class SqlToGroovy {

    static String base_url = "C:\\temp\\groovy\\";


    public static String readToFile(String fileName) {
        File file = new File(fileName);
        StringBuilder tempString = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            System.out.println("以行为单位读取文件内容，一次读一整行：");
            String temp = null;
            // 一次读入一行，直到读入null为文件结束
            while ((temp = reader.readLine()) != null) {
                tempString.append(temp);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return tempString.toString();
    }

    public static boolean writeToFile(String str, String fileName) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            writer.write(str);
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }


    public static void createManyFile(String str) {

        String reg = "import (.*?)return data";

        Pattern pattern = Pattern.compile(reg);
        Matcher file_info = pattern.matcher(str);
        List<String> file_detail = new ArrayList<>();


        String reg_file_name = "'CHDL_TH03-01(.*?)'";
        Pattern pattern_file_name = Pattern.compile(reg_file_name);
        Matcher file_name = pattern_file_name.matcher(str);
        List<String> file_title = new ArrayList<>();

        int i = 0;
        while (file_info.find())
            file_detail.add(file_info.group(i));
        while (file_name.find())
            file_title.add(file_name.group(i).replace("'", ""));
        for (int index = 0; index < file_detail.size(); ++index)
            writeToFile(file_detail.get(index), base_url + file_title.get(index) + ".groovy");
        System.out.println("file_detail.size() = " + file_detail.size());
        System.out.println("file_title.size() = " + file_title.size());
        file_title.stream().forEach(file -> System.out.println(file));
    }

    public static String[] split(String str, Character c) {
        int start = 0;
        boolean flag = true;
        List<String> result = new ArrayList<>();
        for (int i = 0; i < str.length(); ++i) {
            if (str.charAt(i) == '\'')
                flag = !flag;
            if (c == str.charAt(i) && i > 0 && flag) {
                result.add(str.substring(start, i));
                start = i + 1;
            }
        }
        String[] resultdd = new String[result.size()];
        result.toArray(resultdd);
        return resultdd;
    }

    public static void main(String[] args) {
        String str = readToFile("C:\\Users\\hbwxc\\Documents\\WeChat Files\\wxid_7bj8v6p006e722\\FileStorage\\File\\2020-10\\dataflow_db_meta_parse_config.sql");
        createManyFile(str);
    }


}
