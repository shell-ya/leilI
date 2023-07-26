package com.linkwin.apply.mapper;

import com.linkwin.apply.domain.BarCodeSeed;

import java.util.List;

/**
 * 【请填写功能名称】Mapper接口
 * 
 * @author ruoyi
 * @date 2022-05-09
 */
public interface BarCodeSeedMapper 
{
    /**
     * 查询【请填写功能名称】
     * 
     * @param id 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    public BarCodeSeed selectBarCodeSeedById(Long id);

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param barCodeSeed 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<BarCodeSeed> selectBarCodeSeedList(BarCodeSeed barCodeSeed);

    /**
     * 新增【请填写功能名称】
     * 
     * @param barCodeSeed 【请填写功能名称】
     * @return 结果
     */
    public int insertBarCodeSeed(BarCodeSeed barCodeSeed);

    /**
     * 修改【请填写功能名称】
     * 
     * @param barCodeSeed 【请填写功能名称】
     * @return 结果
     */
    public int updateBarCodeSeed(BarCodeSeed barCodeSeed);

    /**
     * 删除【请填写功能名称】
     * 
     * @param id 【请填写功能名称】主键
     * @return 结果
     */
    public int deleteBarCodeSeedById(Long id);

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteBarCodeSeedByIds(String[] ids);

    /**
     * 获取一个子母码种子
     * @param barCodeSeed
     * @return
     * @Author qipeng.zheng
     * @Date 2022/5/19
     */
    BarCodeSeed getOneSeed(BarCodeSeed barCodeSeed);

}
