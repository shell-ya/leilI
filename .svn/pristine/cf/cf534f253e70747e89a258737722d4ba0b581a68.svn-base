package com.linkwin.apply.service.impl;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import com.linkwin.apply.domain.BoxCodeSeed;
import com.linkwin.apply.domain.BoxCodeSeedEnum;
import com.linkwin.apply.mapper.BoxCodeSeedMapper;
import com.linkwin.apply.service.IBoxCodeSeedService;
import com.linkwin.common.utils.DateUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.linkwin.common.core.text.Convert;

/**
 * 【请填写功能名称】Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-05-09
 */
@Service
@Slf4j
public class BoxCodeSeedServiceImpl implements IBoxCodeSeedService
{
    @Autowired
    private BoxCodeSeedMapper boxCodeSeedMapper;

    /**
     * 查询【请填写功能名称】
     * 
     * @param id 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    @Override
    public BoxCodeSeed selectBoxCodeSeedById(Long id)
    {
        return boxCodeSeedMapper.selectBoxCodeSeedById(id);
    }

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param boxCodeSeed 【请填写功能名称】
     * @return 【请填写功能名称】
     */
    @Override
    public List<BoxCodeSeed> selectBoxCodeSeedList(BoxCodeSeed boxCodeSeed)
    {
        return boxCodeSeedMapper.selectBoxCodeSeedList(boxCodeSeed);
    }

    /**
     * 新增【请填写功能名称】
     * 
     * @param boxCodeSeed 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int insertBoxCodeSeed(BoxCodeSeed boxCodeSeed)
    {
        boxCodeSeed.setCreateTime(DateUtils.getNowDate());
        return boxCodeSeedMapper.insertBoxCodeSeed(boxCodeSeed);
    }

    /**
     * 修改【请填写功能名称】
     * 
     * @param boxCodeSeed 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int updateBoxCodeSeed(BoxCodeSeed boxCodeSeed)
    {
        return boxCodeSeedMapper.updateBoxCodeSeed(boxCodeSeed);
    }

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param ids 需要删除的【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteBoxCodeSeedByIds(String ids)
    {
        return boxCodeSeedMapper.deleteBoxCodeSeedByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param id 【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteBoxCodeSeedById(Long id)
    {
        return boxCodeSeedMapper.deleteBoxCodeSeedById(id);
    }

    @Override
    public BoxCodeSeed getSeedIfNullAdd(int seedLength) {
        BoxCodeSeed boxCodeSeed=new BoxCodeSeed();
        try {
            boxCodeSeed.setSeedLength(seedLength);
            boxCodeSeed.setIsEnd(BoxCodeSeedEnum.IS_COMPLETED_NONE.getValue());
            boxCodeSeed = boxCodeSeedMapper.getOneSeed(boxCodeSeed);
            if (boxCodeSeed==null){
                List<BoxCodeSeed> boxCodeSeedList = boxCodeSeedMapper.selectBoxCodeSeedList(new BoxCodeSeed());
                Set<String> seedSet=new HashSet(boxCodeSeedList.stream().map(BoxCodeSeed::getSeed).collect(Collectors.toList()));
                String seed = RandomStringUtils.randomNumeric(seedLength);
                while (seedSet.contains(seed)){
                    seed = RandomStringUtils.randomAlphanumeric(seedLength);
                }
                seed=seed.toUpperCase();
                BoxCodeSeed add=new BoxCodeSeed();
                add.setSeed(seed);
                add.setStartNum(0L);
                add.setSeedLength(seedLength);
                add.setIsEnd(BoxCodeSeedEnum.IS_COMPLETED_NONE.getValue());
                add.setCreateTime(new Date());
                boxCodeSeedMapper.insertBoxCodeSeed(add);
                boxCodeSeed=add;
            }
        }catch (Exception e){
            e.printStackTrace();
            log.error("获取种子异常",e.getMessage());
        }
        return boxCodeSeed;
    }
}
