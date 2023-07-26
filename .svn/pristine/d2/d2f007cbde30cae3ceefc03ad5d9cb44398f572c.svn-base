package com.linkwin.openInterface;

import com.linkwin.activity.domain.CodeActivityLog;
import com.linkwin.activity.domain.ExchangePrize;
import com.linkwin.common.exception.ServiceException;
import com.linkwin.common.json.JsonViewObject;
import com.linkwin.trace.domain.ConsumerLog;

import java.util.List;

public interface IMobileInterfaceService {

    /**
     * 上传消费者信息
     * @param consumerLogList
     * @return
     * @Author qipeng.zheng
     * @Date 2022/5/26
     */
    JsonViewObject uploadConsumer(List<ConsumerLog> consumerLogList) throws ServiceException;


    /**
     * 上传码参加活动日志
     * @param codeActivityLog
     * @return
     * @Author qipeng.zheng
     * @Date 2022/6/1
     */
    JsonViewObject uploadActivityLog(CodeActivityLog codeActivityLog) throws ServiceException;

    /**
     * 查询条码是否参与过活动
     * @param code
     * @return
     * @Author qipeng.zheng
     * @Date 2022/6/1
     */
    JsonViewObject queryActivityLog(String openId,String code) throws ServiceException;

    /**
     * 上传大转盘中奖信息
     * @param exchangePrize
     * @return
     * @Author qipeng.zheng
     * @Date 2022/6/14
     */
    JsonViewObject uploadExchangePrize(ExchangePrize exchangePrize) throws ServiceException;

    /**
     * 根据openId 查询中奖及是否兑换记录
     * @param openId
     * @return
     * @Author qipeng.zheng
     * @Date 20220708
     */
    JsonViewObject queryExchangePrizeLog(String openId);

    /**
     * 获取一个中奖码
     * @return
     * @Author qipeng.zheng
     * @Date 20220708
     */
    JsonViewObject getPrizeCode() throws ServiceException;

    /**
     * 根据中奖码绑定中奖信息
     * @return
     */
    JsonViewObject bindPrizeMsg(String markCode,
                                String code,
                                String prize,
                                String openId,
                                String address,
                                String activityType,
                                Long luckdrawPrizeId
    ) throws ServiceException;


    /**
     * 根据营销码查询活动及配置
     * @param markCode
     * @return
     */
    JsonViewObject getActivityByMarkCode(String markCode,String activityType);




}
