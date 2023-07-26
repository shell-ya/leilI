package com.linkwin.apply.service;

import com.linkwin.apply.domain.BoxCodeSeed;

import java.util.List;

/**
 * 【请填写功能名称】Service接口
 * 
 * @author ruoyi
 * @date 2022-05-09
 */
public interface IBoxCodeSeedService 
{
    /**
     * 查询【请填写功能名称】
     * 
     * @param id 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    public BoxCodeSeed selectBoxCodeSeedById(Long id);

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param boxCodeSeed 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<BoxCodeSeed> selectBoxCodeSeedList(BoxCodeSeed boxCodeSeed);

    /**
     * 新增【请填写功能名称】
     * 
     * @param boxCodeSeed 【请填写功能名称】
     * @return 结果
     */
    public int insertBoxCodeSeed(BoxCodeSeed boxCodeSeed);

    /**
     * 修改【请填写功能名称】
     * 
     * @param boxCodeSeed 【请填写功能名称】
     * @return 结果
     */
    public int updateBoxCodeSeed(BoxCodeSeed boxCodeSeed);

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param ids 需要删除的【请填写功能名称】主键集合
     * @return 结果
     */
    public int deleteBoxCodeSeedByIds(String ids);

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param id 【请填写功能名称】主键
     * @return 结果
     */
    public int deleteBoxCodeSeedById(Long id);

    public BoxCodeSeed getSeedIfNullAdd(int seedLength);

}
