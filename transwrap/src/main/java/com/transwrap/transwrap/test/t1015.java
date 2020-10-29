package com.transwrap.transwrap.test;

import lombok.Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
public class t1015 {


    public static void test(int... he){
        for(int i:he){
            System.out.println("i = " + i);
        }
    }

    private String str;

    public static void main(String[] args) {
        List<Map<String,String>> result = new ArrayList<>();
        result.add((Map<String, String>) (new HashMap<>()).put("1","2"));
        System.out.println("result.size() = " + result.size());
        System.out.println("result.get(0) = " + result.get(0));
        System.out.println("result.get(1).get(\"1\") = " + result.get(0).get("1"));
    }

}
