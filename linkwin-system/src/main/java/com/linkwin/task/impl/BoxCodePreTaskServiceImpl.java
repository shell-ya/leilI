package com.linkwin.task.impl;

import com.linkwin.apply.domain.BoxCodePre;
import com.linkwin.apply.mapper.BoxCodePreMapper;
import com.linkwin.apply.service.IBoxCodePreService;
import com.linkwin.system.service.ISysConfigService;
import com.linkwin.task.IBoxCodePreTaskService;
import com.linkwin.utils.ConfConst;
import lombok.extern.slf4j.Slf4j;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@Slf4j
public class BoxCodePreTaskServiceImpl implements IBoxCodePreTaskService {

    @Autowired
    private BoxCodePreMapper boxCodePreMapper;

    @Autowired
    private IBoxCodePreService boxCodePreService;

    @Autowired
    private ISysConfigService configService;


    @Override
    public void generateCode() {
        try {
            Integer preMax=Integer.valueOf(configService.selectConfigByKey(ConfConst.BOX_PRE_NUM));
//            int preMax=100000;
            int count = boxCodePreMapper.getCount();
            if (count>=preMax){
                return;
            }
            int seedLength=6;
            int randomCodeLength = 18; //随机码长度
            int step = 10000; //随机码步长
            BoxCodePre codePre=new BoxCodePre();
            final int year =  DateTime.now().getYear();
            //获取种子预留
            List<String> codeList = boxCodePreService.generateRandomCode(codePre,seedLength, randomCodeLength, step,year);
            if (codeList!=null&&codeList.size()>0){
                BoxCodePre boxCodePre=new BoxCodePre();
                boxCodePre.setCodeList(codeList);
                boxCodePre.setCreateTime(new Date());
                boxCodePre.setSeed(codePre.getSeed());
                boxCodePre.setYear(year);
                //更新到数据库batchInsert
                boxCodePreMapper.batchInsert(boxCodePre);
                log.info("本次预先生成数量："+codeList.size());
                int total = codeList.size()+count;
                log.info("箱码码池数量："+total);
            }
        }catch (Exception e){
            e.printStackTrace();
            log.error("预生成码失败："+e.getMessage());
        }
    }
}
