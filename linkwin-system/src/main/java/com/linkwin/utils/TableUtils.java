package com.linkwin.utils;

import com.linkwin.apply.domain.TableEnum;

import java.util.Calendar;

public class TableUtils {


    public static String getBoxTableByYear(int year){
        String suffix = String.valueOf(year).substring(2); //截掉年份前两位，取后面作为表后缀
        return TableEnum.BOX_CODE.getValue() + "_" + suffix;
    }

    public static String getBarTableByYear(int year){
        String suffix = String.valueOf(year).substring(2); //截掉年份前两位，取后面作为表后缀
        return TableEnum.QR_CODE.getValue() + "_" + suffix;
    }

    public static String getSubTableByYear(int year){
        String suffix = String.valueOf(year).substring(2); //截掉年份前两位，取后面作为表后缀
        return TableEnum.SUB_CODE.getValue() + "_" + suffix;
    }


    /**
     * 根据条码第一位获取生成条码的年份
     * @param code
     * @return
     */
    public static String getYearByCode(String code){
        String codeYearStr=code.substring(0,1);
        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        String yearStr = Integer.toString(year).substring(2);//当前年份
        String lastLatter = yearStr.substring(1);//
        String firtsLatter = yearStr.substring(0, 1);
        int codeYear = Integer.parseInt(codeYearStr);
        if (codeYear > Integer.parseInt(lastLatter)) {
            yearStr = Integer.toString(Integer.parseInt(firtsLatter) - 1) + codeYearStr;
        } else {
            yearStr = firtsLatter + codeYearStr;
        }
        return yearStr;
    }

    public static String getTableNameByQrCode(String barCode){
        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        String yearStr = Integer.toString(year).substring(2);
        String lastLatter = yearStr.substring(1);
        String firtsLatter = yearStr.substring(0, 1);
        String codeYearStr = barCode.substring(12, 13);
        int codeYear = Integer.parseInt(codeYearStr);
        if (codeYear > Integer.parseInt(lastLatter)) {
            yearStr = Integer.toString(Integer.parseInt(firtsLatter) - 1) + codeYearStr;
        } else {
            yearStr = firtsLatter + codeYearStr;
        }
        return yearStr;
    }






}
