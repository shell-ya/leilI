package com.linkwin.task.impl;

import com.linkwin.apply.domain.BarCode;
import com.linkwin.apply.domain.BoxCodePre;
import com.linkwin.apply.domain.QrCodePre;
import com.linkwin.apply.mapper.QrCodePreMapper;
import com.linkwin.apply.service.IQrCodePreService;
import com.linkwin.common.exception.ServiceException;
import com.linkwin.system.service.ISysConfigService;
import com.linkwin.task.IBarCodePreTaskService;
import com.linkwin.utils.ConfConst;
import lombok.extern.slf4j.Slf4j;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Slf4j
@Service
public class BarCodePreTaskServiceImpl implements IBarCodePreTaskService {

    @Autowired
    private QrCodePreMapper qrCodePreMapper;

    @Autowired
    private IQrCodePreService qrCodePreService;

    @Autowired
    private ISysConfigService configService;

    @Transactional
    @Override
    public void generateQrCode() throws ServiceException {
        try {
            Integer preMax=Integer.valueOf(configService.selectConfigByKey(ConfConst.QR_PRE_NUM));
//            int max=100000;
            int count = qrCodePreMapper.getCount();
            if (count>=preMax){
                return;
            }
            int randomLength=11;//随机部分长度
            int step=1000;
            final int year =  DateTime.now().getYear();
            QrCodePre pre=new QrCodePre();
            List<String> codeList = qrCodePreService.generateRandomCode(pre,randomLength, step, year);
            List<QrCodePre> barCodeList=new ArrayList<>();
            for (int i=0;i<codeList.size();i++){
                QrCodePre qrCodePre=new QrCodePre();
                qrCodePre.setCode(codeList.get(i));
                qrCodePre.setSeed(pre.getSeed());
                qrCodePre.setYear(year);
                barCodeList.add(qrCodePre);
            }
            qrCodePreMapper.batchInsertQrCodePre(barCodeList);
            log.info("本次预先生成数量："+codeList.size());
            int total=codeList.size()+count;
            log.info("二维码码池数量："+total);
        }catch (Exception e){
            log.info("二维码预生成异常：",e.getCause());
            e.printStackTrace();
            throw new ServiceException(e.getMessage());
        }

    }


}
