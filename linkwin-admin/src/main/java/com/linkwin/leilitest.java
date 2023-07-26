package com.linkwin;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.linkwin.common.utils.http.HttpUtil;
import org.joda.time.DateTime;

import java.util.HashMap;
import java.util.Map;

public class leilitest {

    public static void main(String[] args) {
//        String url = "http://www.leiliyx.stoload.com/api/getdrawresult";
//        Map<String,Object> param=new HashMap<>();
//        param.put("activityid",8);
//        param.put("is_test_backend_liyun_____",1);
//        test(url,param);
        final int year =  DateTime.now().getYear();
        String s=String.valueOf(year);
        String prefix=s.substring(s.length()-1,s.length());
        System.out.println(prefix);


    }

    public static void test(String url, Map<String,Object> map){

        Map<String,Integer> result=new HashMap<>();
        for (int i=0;i<500;i++){
            String s = HttpUtil.doPost(url, map);
            JSONObject jsonObject = JSON.parseObject(s);
            JSONObject prizedata = jsonObject.getJSONObject("prizedata");
            String prize = prizedata.getString("prize");
            if (!result.containsKey(prize)){
                result.put(prize, 1);
            }else {
                result.replace(prize,result.get(prize)+1);
            }
        }

        for (Map.Entry entry: result.entrySet()){
            System.out.println(entry.getKey()+":"+entry.getValue());
        }







    }

}
