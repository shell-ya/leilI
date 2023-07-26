package com.linkwin.apply.service;

import com.linkwin.apply.domain.BarCodeSeed;

import java.util.List;

/**
 * 【请填写功能名称】Service接口
 * 
 * @author ruoyi
 * @date 2022-05-09
 */
public interface IBarCodeSeedService 
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
     * 批量删除【请填写功能名称】
     * 
     * @param ids 需要删除的【请填写功能名称】主键集合
     * @return 结果
     */
    public int deleteBarCodeSeedByIds(String ids);

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param id 【请填写功能名称】主键
     * @return 结果
     */
    public int deleteBarCodeSeedById(Long id);


    BarCodeSeed getSeedIfNullAdd();


}
