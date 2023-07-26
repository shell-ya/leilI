package com.linkwin.apply.service.impl;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import com.linkwin.apply.domain.BarCodeSeed;
import com.linkwin.apply.domain.BoxCodeSeedEnum;
import com.linkwin.apply.mapper.BarCodeSeedMapper;
import com.linkwin.apply.service.IBarCodeSeedService;
import com.linkwin.common.utils.DateUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomStringUtils;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.linkwin.common.core.text.Convert;

/**
 * 【请填写功能名称】Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-05-09
 */
@Slf4j
@Service
public class BarCodeSeedServiceImpl implements IBarCodeSeedService
{
    @Autowired
    private BarCodeSeedMapper barCodeSeedMapper;

    /**
     * 查询【请填写功能名称】
     * 
     * @param id 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    @Override
    public BarCodeSeed selectBarCodeSeedById(Long id)
    {
        return barCodeSeedMapper.selectBarCodeSeedById(id);
    }

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param barCodeSeed 【请填写功能名称】
     * @return 【请填写功能名称】
     */
    @Override
    public List<BarCodeSeed> selectBarCodeSeedList(BarCodeSeed barCodeSeed)
    {
        return barCodeSeedMapper.selectBarCodeSeedList(barCodeSeed);
    }

    /**
     * 新增【请填写功能名称】
     * 
     * @param barCodeSeed 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int insertBarCodeSeed(BarCodeSeed barCodeSeed)
    {
        barCodeSeed.setCreateTime(DateUtils.getNowDate());
        return barCodeSeedMapper.insertBarCodeSeed(barCodeSeed);
    }

    /**
     * 修改【请填写功能名称】
     * 
     * @param barCodeSeed 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int updateBarCodeSeed(BarCodeSeed barCodeSeed)
    {
        return barCodeSeedMapper.updateBarCodeSeed(barCodeSeed);
    }

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param ids 需要删除的【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteBarCodeSeedByIds(String ids)
    {
        return barCodeSeedMapper.deleteBarCodeSeedByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param id 【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteBarCodeSeedById(Long id)
    {
        return barCodeSeedMapper.deleteBarCodeSeedById(id);
    }

    @Override
    public BarCodeSeed getSeedIfNullAdd() {
        BarCodeSeed barCodeSeed=new BarCodeSeed();
        try {
            int seedLength=5;
            barCodeSeed.setSeedLength(seedLength);
            barCodeSeed.setIsEnd(BoxCodeSeedEnum.IS_COMPLETED_NONE.getValue());
            barCodeSeed = barCodeSeedMapper.getOneSeed(barCodeSeed);
            if (barCodeSeed==null){
                List<BarCodeSeed> boxCodeSeedList = barCodeSeedMapper.selectBarCodeSeedList(new BarCodeSeed());
                Set<String> seedSet=new HashSet(boxCodeSeedList.stream().map(BarCodeSeed::getSeed).collect(Collectors.toList()));
                String seed = RandomStringUtils.randomNumeric(seedLength);
                while (seedSet.contains(seed)){
                    seed = RandomStringUtils.randomAlphanumeric(seedLength);
                }
                seed=seed.toUpperCase();
                BarCodeSeed add=new BarCodeSeed();
                add.setSeed(seed);
                add.setStartNum(0);
                add.setSeedLength(seedLength);
                add.setIsEnd(BoxCodeSeedEnum.IS_COMPLETED_NONE.getValue());
                add.setCreateTime(new Date());
                add.setYear(DateTime.now().getYear());
                barCodeSeedMapper.insertBarCodeSeed(add);
                barCodeSeed=add;
            }
        }catch (Exception e){
            e.printStackTrace();
            log.error("获取子母码种子异常",e.getMessage());
            throw new RuntimeException(e.getMessage());
        }
        return barCodeSeed;
    }
}
