package com.linkwin.activity.service.impl;

import java.util.List;

import com.linkwin.activity.domain.IntegralCodeStatus;
import com.linkwin.activity.mapper.IntegralCodeStatusMapper;
import com.linkwin.activity.service.IIntegralCodeStatusService;
import com.linkwin.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.linkwin.common.core.text.Convert;

/**
 * 营销码状态Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-06-15
 */
@Service
public class IntegralCodeStatusServiceImpl implements IIntegralCodeStatusService
{
    @Autowired
    private IntegralCodeStatusMapper integralCodeStatusMapper;

    /**
     * 查询营销码状态
     * 
     * @param id 营销码状态主键
     * @return 营销码状态
     */
    @Override
    public IntegralCodeStatus selectIntegralCodeStatusById(Long id)
    {
        return integralCodeStatusMapper.selectIntegralCodeStatusById(id);
    }

    /**
     * 查询营销码状态列表
     * 
     * @param integralCodeStatus 营销码状态
     * @return 营销码状态
     */
    @Override
    public List<IntegralCodeStatus> selectIntegralCodeStatusList(IntegralCodeStatus integralCodeStatus)
    {
        return integralCodeStatusMapper.selectIntegralCodeStatusList(integralCodeStatus);
    }

    /**
     * 新增营销码状态
     * 
     * @param integralCodeStatus 营销码状态
     * @return 结果
     */
    @Override
    public int insertIntegralCodeStatus(IntegralCodeStatus integralCodeStatus)
    {
        integralCodeStatus.setCreateTime(DateUtils.getNowDate());
        return integralCodeStatusMapper.insertIntegralCodeStatus(integralCodeStatus);
    }

    /**
     * 修改营销码状态
     * 
     * @param integralCodeStatus 营销码状态
     * @return 结果
     */
    @Override
    public int updateIntegralCodeStatus(IntegralCodeStatus integralCodeStatus)
    {
        return integralCodeStatusMapper.updateIntegralCodeStatus(integralCodeStatus);
    }

    /**
     * 批量删除营销码状态
     * 
     * @param ids 需要删除的营销码状态主键
     * @return 结果
     */
    @Override
    public int deleteIntegralCodeStatusByIds(String ids)
    {
        return integralCodeStatusMapper.deleteIntegralCodeStatusByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除营销码状态信息
     * 
     * @param id 营销码状态主键
     * @return 结果
     */
    @Override
    public int deleteIntegralCodeStatusById(Long id)
    {
        return integralCodeStatusMapper.deleteIntegralCodeStatusById(id);
    }

    @Override
    public IntegralCodeStatus selectByMarkCode(String markCode) {
        return integralCodeStatusMapper.selectByMarkCode(markCode);
    }
}
