package com.linkwin.utils;

import com.linkwin.common.utils.DateUtils;
import com.linkwin.common.utils.StringUtils;

import com.linkwin.order.domain.BillOrder;
import com.linkwin.order.mapper.BillOrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;


@Component
public class GetOrderNoUtils {

    @Autowired
    private BillOrderMapper billOrderMapper;

    private static Object lock=new Object();

    /**
     * 4位流水号
     *
     * @param Type
     * @return
     */
    public  String serinalNo(Integer Type) {
        StringBuffer sb=new StringBuffer();
        String orderNo=null;
        synchronized (lock){
            orderNo = OrderNoUtils.getOrderNo(Type);
            sb.append("当前时间："+System.currentTimeMillis());
            sb.append("获取到的缓存单据编号:"+orderNo);
            if (StringUtils.isEmpty(orderNo)){
                orderNo = getOrderNo(Type,sb);
            }else {
                String date = DateUtils.parseDateToStr("yyyyMMdd", new Date());
                if (orderNo.indexOf(date)==-1){
                    orderNo = getOrderNo(Type,sb);
                }
            }
            String lastNum = orderNo.substring(orderNo.length() - 4);
            int nextNum=Integer.parseInt(lastNum) + 1;
            nextNum=nextNum+10000;
            String next=String.valueOf(nextNum).substring(1);
            String nextNo = orderNo.substring(0, orderNo.length() - 4);
            nextNo=nextNo+next;
//            String nextNo=orderNo.replace(lastNum,next);
            OrderNoUtils.replace(Type,nextNo);
            sb.append("更新下一个单据号："+nextNo);
            sb.append("最终单据号："+orderNo);
            System.out.println(sb.toString());
        }
        return orderNo;
    }

    public String getOrderNo(Integer Type,StringBuffer sb){
        String serinalNo = null;
        switch (Type) {
            case 0:
                serinalNo = "RK" + DateUtils.parseDateToStr("yyyyMMdd", new Date());
                break;
            case 1:
                serinalNo = "CK" + DateUtils.parseDateToStr("yyyyMMdd", new Date());
                break;
            case 2:
                serinalNo = "DJ" + DateUtils.parseDateToStr("yyyyMMdd", new Date());
                break;
            case 3:
                serinalNo = "SM" + DateUtils.parseDateToStr("yyyyMMdd", new Date());
                break;
            case 4:
                serinalNo = "OW" + DateUtils.parseDateToStr("yyyyMMdd", new Date());
                break;
            default:
                //...;
                break;
        }
        BillOrder billOrder = new BillOrder();
        billOrder.setOrderNo(serinalNo);
        List<BillOrder> exList = billOrderMapper.selectOrderNoList(billOrder);
        String max_code = exList.size() > 0 ? exList.get(0).getOrderNo() : null;
        String comment_code;
        if (max_code != null && max_code.contains(serinalNo)) {
            sb.append("从数据库获取到的单据号"+max_code);
//            System.out.println("获取到的单据号"+max_code+"当前时间戳："+System.currentTimeMillis());
            max_code=max_code.substring(0,14);
            String uid_end = max_code.substring(max_code.length() - 4);
            ; // 截取字符串最后四位，结果:0001
            // System.out.println("uid_end=" + uid_end);
            int endNum = Integer.parseInt(uid_end) + 1; // 把String类型的0001转化为int类型的1
            // System.out.println("endNum=" + endNum);
            int tmpNum = 10000 + endNum ; // 结果10002
            // System.out.println("tmpNum=" + tmpNum);
            comment_code = serinalNo + String.valueOf(tmpNum).substring(1);// 把10002首位的1去掉，再拼成1601260002字符串
        } else {
            comment_code = serinalNo + "0001";
        }
        return comment_code;
    }




    public String noBillSerinalNo(Integer type){
        String orderNo = serinalNo(type);
        return orderNo;
    }





}
