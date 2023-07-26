package com.linkwin.utils;

import java.util.HashMap;
import java.util.Map;

public class OrderNoUtils {

    private static Map<Integer,String> map=new HashMap<>();

    public static String getOrderNo(Integer type){
        return map.get(type);
    }

    public static void replace(Integer type, String orderNo){
        if (map.containsKey(type)){
            map.replace(type,orderNo);
        }else {
            map.put(type,orderNo);
        }
    }











}
