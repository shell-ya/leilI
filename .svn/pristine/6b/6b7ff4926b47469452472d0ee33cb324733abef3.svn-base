package com.linkwin.quartz.task;

import com.linkwin.common.utils.DateUtils;
import com.linkwin.task.IBarCodePreTaskService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Slf4j
@Component("qrCodePreTask")
public class QrCodePreTask {

    @Autowired
    private IBarCodePreTaskService barCodePreTaskService;

    private static Object lock = new Object();

    private static boolean isRunning = false;

    public void execute() {
        if (!isRunning) {
            synchronized (lock) {
                try {
                    isRunning = true;
                    long startTime = System.currentTimeMillis();
                    log.info(String.format("预生成二维码定时任务开始,当前时间[%s]", DateUtils.getNowDate()));
                    barCodePreTaskService.generateQrCode();
                    long endTime = System.currentTimeMillis();
                    log.info(String.format("预生成二维码申请定时任务结束,当前时间[%s],任务花费时间%s", DateUtils.getNowDate(), String.valueOf(endTime - startTime)));
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    isRunning = false;
                }
            }
        }
    }


}
