package com.linkwin.quartz.task;

import com.linkwin.common.utils.DateUtils;
import com.linkwin.task.IBoxCodePreTaskService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Slf4j
@Component("boxCodePreTask")
public class BoxCodePreTask {

    @Autowired
    private IBoxCodePreTaskService boxCodePreTaskService;


    private static Object lock = new Object();

    private static boolean isRunning = false;

    public void execute() {
        if (!isRunning) {
            synchronized (lock) {
                try {
                    isRunning = true;
                    long startTime = System.currentTimeMillis();
                    log.info(String.format("预生成箱码定时任务开始,当前时间[%s]", DateUtils.getNowDate()));
                    boxCodePreTaskService.generateCode();
                    long endTime = System.currentTimeMillis();
                    log.info(String.format("预生成箱码申请定时任务结束,当前时间[%s],任务花费时间%s", DateUtils.getNowDate(), String.valueOf(endTime - startTime)));
                } catch (Exception e) {
                    log.error(e.getMessage());
                    e.printStackTrace();
                } finally {
                    isRunning = false;
                }
            }
        }
    }


}
