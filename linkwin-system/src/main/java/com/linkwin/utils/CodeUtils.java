package com.linkwin.utils;

import com.linkwin.apply.domain.BarCode;
import com.linkwin.common.utils.StringUtils;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CodeUtils {


    public static final int BAR_CODE_LENGTH=23;
    public static final int SUB_CODE_LENGTH=20;
    public static final int BOX_CODE_LENGTH=19;
    public static final int INTEGRAL_CODE_LENGTH=26;


    /**
     * 根据母码获取开始流水号和结束流水号
     */
    public static BarCode getStartAndEndNumByCode(String barCode){
        if (StringUtils.isEmpty(barCode)){
            return null;
        }
        String serial = barCode.substring(barCode.length() - 6);
        Integer startNum = Integer.valueOf(serial.substring(0,3));
        Integer endNum = Integer.valueOf(serial.substring(3));
        BarCode barCode1=new BarCode();
        barCode1.setStartNum(startNum);
        barCode1.setEndNum(endNum);
        barCode1.setSeed(barCode.substring(1,6));
        return barCode1;
    }


    public static void verifyCode(String code) throws Exception{
        if (StringUtils.isEmpty(code)){
            throw new NullPointerException("码格式错误或为空");
        }
        if (!(code.length()==CodeUtils.BAR_CODE_LENGTH||code.length()==CodeUtils.SUB_CODE_LENGTH||code.length()==CodeUtils.BOX_CODE_LENGTH)){
            throw new Exception("码格式错误");
        }
    }


    public static String getCodeTypeByCode(String code) throws Exception{
        if (StringUtils.isEmpty(code)){
            throw new NullPointerException("码数据为空");
        }
        String res=null;
        int length = code.length();
        switch (length){
            case BAR_CODE_LENGTH://母码
                res= CodeEnum.BAR_CODE.getValue();
                break;
            case SUB_CODE_LENGTH://子码
                res= CodeEnum.SUB_CODE.getValue();
                break;
            case BOX_CODE_LENGTH://箱码
                res= CodeEnum.BOX_CODE.getValue();
                break;
            case INTEGRAL_CODE_LENGTH://箱码
                res= CodeEnum.INTEGRAL_CODE.getValue();
            default:
        }
        return res;
    }

    public static String randomCode(int len){

        char[] c=new char[len];
            for (int j = 0; j < len; j++) {
                double rand = Math.random();
                double randTri = Math.random() * 2;
                if (randTri >= 0 && randTri < 1) {
                    c[j]=(char) (rand * ('Z' - 'A') + 'A');
                } else {
                    c[j]=(char) (rand * ('z' - 'a') + 'a');
                }
            }
        return String.valueOf(c);
    }

    /**
     * 获取随机码
     * @param len
     * @return
     */
    public static String getIntegralCode(int len){
        StringBuffer sb=new StringBuffer();
        int digit = (int) Math.pow(10, len - 1);
        int rs = new Random().nextInt(digit * 10);
        if (rs < digit) {
            rs += digit;
        }
        sb.append(String.valueOf(rs));
        for (char c:randomCode(len).toCharArray()){
            int num= (int)(Math.random()*sb.length()+1);
            sb.insert(num,c);
        }
        return sb.toString();
    }



    /**
     * 解析地址
     * @author lin
     * @param address
     * @return
     */
    public static List<Map<String,String>> addressResolution(String address){
        String regex="(?<province>[^省]+自治区|.*?省|.*?行政区|.*?市)(?<city>[^市]+自治州|.*?地区|.*?行政单位|.+盟|市辖区|.*?市|.*?县)(?<county>[^县]+县|.+区|.+市|.+旗|.+海域|.+岛)?(?<town>[^区]+区|.+镇)?(?<village>.*)";
        Matcher m= Pattern.compile(regex).matcher(address);
        String province=null,city=null,county=null,town=null,village=null;
        List<Map<String,String>> table=new ArrayList<Map<String,String>>();
        Map<String,String> row=null;
        while(m.find()){
            row=new LinkedHashMap<String,String>();
            province=m.group("province");
            row.put("province", province==null?"":province.trim());
            city=m.group("city");
            row.put("city", city==null?"":city.trim());
            county=m.group("county");
            row.put("county", county==null?"":county.trim());
            town=m.group("town");
            row.put("town", town==null?"":town.trim());
            village=m.group("village");
            row.put("village", village==null?"":village.trim());
            table.add(row);
        }
        return table;
    }

    public static boolean verifyAddress(String sourceAddress,String targetAddress){




        boolean b=true;
        for (char c:sourceAddress.toCharArray()){
            int i = targetAddress.indexOf(String.valueOf(c));
            if (i==-1){
                b=false;
                return b;
            }
        }
        return b;
    }


    public static String getPrefixCode(String code) throws Exception{
        return code.substring(0,17);
    }


    public static String getSeed(String code){
        return code.substring(1,6);
    }




    public static void main(String[] args) {
//        System.out.println(getIntegralCode(10));
        System.out.println(addressResolution("贵州省毕节市织金县"));
//        Integer type = 2;
//        boolean equals = type.equals("2");
//        System.out.println(equals);
//        String code = "23478900532493985000001";
//        BarCode startAndEndNumByCode = getStartAndEndNumByCode(code);
//        try {
//            testException();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }


    }

    public static void testException() throws Exception{
        try {
            String code1=null;
            code1.equals("1");
        }catch (Exception e){
            System.out.println("捕获到异常");
            throw new NullPointerException(e.getMessage());
        }finally {
            System.out.println("finally");
        }
    }








}
