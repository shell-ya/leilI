package com.linkwin.apply.service.impl;

import java.util.*;

import com.linkwin.apply.domain.BoxCodePre;
import com.linkwin.apply.domain.BoxCodeSeed;
import com.linkwin.apply.domain.BoxCodeSeedEnum;
import com.linkwin.apply.mapper.BoxCodePreMapper;
import com.linkwin.apply.mapper.BoxCodeSeedMapper;
import com.linkwin.apply.service.IBoxCodePreService;
import com.linkwin.apply.service.IBoxCodeSeedService;
import com.linkwin.common.utils.DateUtils;
import com.linkwin.common.utils.MessageUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.linkwin.common.core.text.Convert;

/**
 * 箱袋码预生成Service业务层处理
 * 
 * @author qipeng.zheng
 * @date 2022-05-12
 */
@Slf4j
@Service
public class BoxCodePreServiceImpl implements IBoxCodePreService
{
    @Autowired
    private BoxCodePreMapper boxCodePreMapper;

    @Autowired
    private BoxCodeSeedMapper boxCodeSeedMapper;

    @Autowired
    private IBoxCodeSeedService boxCodeSeedService;

    /**
     * 查询箱袋码预生成
     * 
     * @param id 箱袋码预生成主键
     * @return 箱袋码预生成
     */
    @Override
    public BoxCodePre selectBoxCodePreById(Long id)
    {
        return boxCodePreMapper.selectBoxCodePreById(id);
    }

    /**
     * 查询箱袋码预生成列表
     * 
     * @param boxCodePre 箱袋码预生成
     * @return 箱袋码预生成
     */
    @Override
    public List<BoxCodePre> selectBoxCodePreList(BoxCodePre boxCodePre)
    {
        return boxCodePreMapper.selectBoxCodePreList(boxCodePre);
    }

    /**
     * 新增箱袋码预生成
     * 
     * @param boxCodePre 箱袋码预生成
     * @return 结果
     */
    @Override
    public int insertBoxCodePre(BoxCodePre boxCodePre)
    {
        boxCodePre.setCreateTime(DateUtils.getNowDate());
        return boxCodePreMapper.insertBoxCodePre(boxCodePre);
    }

    /**
     * 修改箱袋码预生成
     * 
     * @param boxCodePre 箱袋码预生成
     * @return 结果
     */
    @Override
    public int updateBoxCodePre(BoxCodePre boxCodePre)
    {
        return boxCodePreMapper.updateBoxCodePre(boxCodePre);
    }

    /**
     * 批量删除箱袋码预生成
     * 
     * @param ids 需要删除的箱袋码预生成主键
     * @return 结果
     */
    @Override
    public int deleteBoxCodePreByIds(String ids)
    {
        return boxCodePreMapper.deleteBoxCodePreByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除箱袋码预生成信息
     * 
     * @param id 箱袋码预生成主键
     * @return 结果
     */
    @Override
    public int deleteBoxCodePreById(Long id)
    {
        return boxCodePreMapper.deleteBoxCodePreById(id);
    }

    @Override
    public List<String> generateRandomCode(BoxCodePre boxCodePre,int seedLength, int randomCodeLength, int step ,int year) throws Exception {
        List<String> randomCodes=new ArrayList<>();
        try {
            //获取种子
            //
            BoxCodeSeed boxCodeSeed=boxCodeSeedService.getSeedIfNullAdd(seedLength);
            int randomLength=randomCodeLength-seedLength;//随机部分长度
            final long randomMax = (long) Math.pow(10, randomLength);//随机数最大值
            Random random = new Random();
            int generateNum=1000;//每次生成码数量
            StringBuilder randomVal = new StringBuilder();
            BoxCodeSeed updateSeed=new BoxCodeSeed();
            HashSet<String> set=new HashSet<>();
            updateSeed.setId(boxCodeSeed.getId());
            long start = boxCodeSeed.getStartNum();
            String s=String.valueOf(year);
            String prefix=s.substring(s.length()-1,s.length());
            for (int i=0;i<generateNum;i++){
                start+= random.nextInt(step);
                if (start>=randomMax){
                    updateSeed.setIsEnd(BoxCodeSeedEnum.IS_COMPLETED_COMPLETED.getValue());
                    break;
                }
                randomVal.append(start);
                //长度不足补0
                while(randomVal.length() < randomLength){
                    randomVal.insert(0, "0");
                }
                randomVal.insert(0,boxCodeSeed.getSeed());
                randomVal.insert(0,prefix);
                set.add(randomVal.toString());
                randomVal.setLength(0);
                start++;
            }
            updateSeed.setStartNum(start);
            updateSeed.setModifyTime(new Date());
            updateSeed.setYear(boxCodeSeed.getYear());
            boxCodePre.setSeed(boxCodeSeed.getSeed());
            int i = boxCodeSeedMapper.updateBoxCodeSeed(updateSeed);
            randomCodes.addAll(set);
        }catch (Exception e){
            e.printStackTrace();
        }
        return randomCodes;
    }

    @Override
    public void updateBoxCodePreApplyId(long applyId, int year, int count) throws RuntimeException {
        int row = boxCodePreMapper.updateBoxCodePreApplyId(applyId, year, count);
        if (row!=count){
            log.error("标记预生成箱码异常，申请编号id="+applyId);
//            throw new RuntimeException("标记预生成箱码异常，申请编号id="+applyId);
            throw new RuntimeException(MessageUtils.message("error.msg.markgeneratedbox") +applyId);
        }
    }

    @Override
    public int deleteByApplyId(long applyId) {
        return boxCodePreMapper.deleteByApplyId(applyId);
    }

    @Override
    public int insertBoxCode(long applyId, int year, String tableName) {
        return boxCodePreMapper.insertBoxCode(applyId,year,tableName);
    }


}
