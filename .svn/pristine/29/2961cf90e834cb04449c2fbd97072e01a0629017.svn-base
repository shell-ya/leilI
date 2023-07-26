package com.linkwin.apply.service.impl;

import java.util.List;

import com.linkwin.apply.domain.BarCode;
import com.linkwin.apply.mapper.BarCodeMapper;
import com.linkwin.apply.service.IBarCodeService;
import com.linkwin.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.linkwin.common.core.text.Convert;

/**
 * 箱码申请Service业务层处理
 * 
 * @author ruoyi
 * @date 20-05-19
 */
@Service
public class BarCodeServiceImpl implements IBarCodeService 
{
    @Autowired
    private BarCodeMapper barCodeMapper;

    /**
     * 查询箱码申请
     * 
     * @param id 箱码申请主键
     * @return 箱码申请
     */
    @Override
    public BarCode selectBarCodeById(Long id)
    {
        return barCodeMapper.selectBarCodeById(id);
    }

    /**
     * 查询箱码申请列表
     * 
     * @param barCode 箱码申请
     * @return 箱码申请
     */
    @Override
    public List<BarCode> selectBarCodeList(BarCode barCode)
    {
        return barCodeMapper.selectBarCodeList(barCode);
    }

    /**
     * 新增箱码申请
     * 
     * @param barCode 箱码申请
     * @return 结果
     */
    @Override
    public int insertBarCode(BarCode barCode)
    {
        barCode.setCreateTime(DateUtils.getNowDate());
        return barCodeMapper.insertBarCode(barCode);
    }

    /**
     * 修改箱码申请
     * 
     * @param barCode 箱码申请
     * @return 结果
     */
    @Override
    public int updateBarCode(BarCode barCode)
    {
        return barCodeMapper.updateBarCode(barCode);
    }

    /**
     * 批量删除箱码申请
     * 
     * @param ids 需要删除的箱码申请主键
     * @return 结果
     */
    @Override
    public int deleteBarCodeByIds(String ids)
    {
        return barCodeMapper.deleteBarCodeByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除箱码申请信息
     * 
     * @param id 箱码申请主键
     * @return 结果
     */
    @Override
    public int deleteBarCodeById(Long id)
    {
        return barCodeMapper.deleteBarCodeById(id);
    }
}
