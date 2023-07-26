package com.linkwin.activity.service.impl;

import com.linkwin.activity.domain.ExchangePrize;
import com.linkwin.activity.mapper.ExchangePrizeMapper;
import com.linkwin.activity.service.IExchangePrizeService;
import com.linkwin.common.core.domain.entity.SysUser;
import com.linkwin.common.core.text.Convert;
import com.linkwin.common.exception.ServiceException;
import com.linkwin.common.json.JsonViewObject;
import com.linkwin.common.utils.DateUtils;
import com.linkwin.common.utils.MessageUtils;
import com.linkwin.system.service.ISysUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * 兑奖核销管理Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-06-01
 */
@Slf4j
@Service
public class ExchangePrizeServiceImpl implements IExchangePrizeService
{
    @Autowired
    private ExchangePrizeMapper exchangePrizeMapper;

    @Autowired
    private ISysUserService userService;

    /**
     * 查询兑奖核销管理
     * 
     * @param id 兑奖核销管理主键
     * @return 兑奖核销管理
     */
    @Override
    public ExchangePrize selectExchangePrizeById(Long id)
    {
        return exchangePrizeMapper.selectExchangePrizeById(id);
    }

    /**
     * 查询兑奖核销管理列表
     * 
     * @param exchangePrize 兑奖核销管理
     * @return 兑奖核销管理
     */
    @Override
    public List<ExchangePrize> selectExchangePrizeList(ExchangePrize exchangePrize)
    {
        return exchangePrizeMapper.selectExchangePrizeList(exchangePrize);
    }

    /**
     * 新增兑奖核销管理
     * 
     * @param exchangePrize 兑奖核销管理
     * @return 结果
     */
    @Override
    public int insertExchangePrize(ExchangePrize exchangePrize)
    {
        return exchangePrizeMapper.insertExchangePrize(exchangePrize);
    }

    /**
     * 修改兑奖核销管理
     * 
     * @param exchangePrize 兑奖核销管理
     * @return 结果
     */
    @Override
    public int updateExchangePrize(ExchangePrize exchangePrize)
    {
        return exchangePrizeMapper.updateExchangePrize(exchangePrize);
    }

    /**
     * 批量删除兑奖核销管理
     * 
     * @param ids 需要删除的兑奖核销管理主键
     * @return 结果
     */
    @Override
    public int deleteExchangePrizeByIds(String ids)
    {
        return exchangePrizeMapper.deleteExchangePrizeByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除兑奖核销管理信息
     * 
     * @param id 兑奖核销管理主键
     * @return 结果
     */
    @Override
    public int deleteExchangePrizeById(Long id)
    {
        return exchangePrizeMapper.deleteExchangePrizeById(id);
    }

    @Override
    public JsonViewObject exchange(ExchangePrize prize, SysUser user) throws ServiceException {
        JsonViewObject jsonViewObject=new JsonViewObject();
        try {
            ExchangePrize exchangePrize = exchangePrizeMapper.selectByCode(prize.getCode());
            if (exchangePrize==null){
//                jsonViewObject.fail("该兑奖码不存在");
                jsonViewObject.fail(MessageUtils.message("error.msg.redemptioncode"));
                return jsonViewObject;
            }
            if (exchangePrize.getExchange()==1){
                jsonViewObject.fail(MessageUtils.message("error.msg.codehasredeemed")+ DateUtils.parseDateToStr(DateUtils.YYYY_MM_DD_HH_MM_SS,exchangePrize.getCheckTime()));
//                jsonViewObject.fail("该码已经兑换过，兑换时间："+ DateUtils.parseDateToStr(DateUtils.YYYY_MM_DD_HH_MM_SS,exchangePrize.getCheckTime()));
                return jsonViewObject;
            }
            exchangePrize.setCheckAddress(prize.getCheckAddress());
            exchangePrize.setCheckPeople(user.getUserId());
            exchangePrize.setCheckPeopleName(user.getUserName());
            exchangePrize.setCheckTime(new Date());
            exchangePrize.setCheckPeople(user.getUserId());
            exchangePrize.setExchange(1);
            int i = exchangePrizeMapper.updateExchangePrize(exchangePrize);
            if (i==1){
//                jsonViewObject.success("核销成功");
                jsonViewObject.success(MessageUtils.message("error.msg.redeemsuccessful"));
            }else {
//                jsonViewObject.fail("核销失败");
                jsonViewObject.success(MessageUtils.message("error.msg.failedredeem="));
            }
        }catch (Exception e ){
            log.error("ExchangePrizeServiceImpl exchange is error",e.getMessage());
            e.printStackTrace();
            throw new ServiceException();
        }
        return jsonViewObject;
    }

    @Override
    public ExchangePrize selectByCode(String code) {
        return exchangePrizeMapper.selectByCode(code);
    }

    @Override
    public List<ExchangePrize> selectByOpenId(String openId) {
        return exchangePrizeMapper.selectByOpenId(openId);
    }

    @Override
    public List<ExchangePrize> selectExchangePrizeListByDeptIds(ExchangePrize exchangePrize, List<Long> deptIds) {
        return exchangePrizeMapper.selectExchangePrizeListByDeptIds(exchangePrize,deptIds);
    }


}
