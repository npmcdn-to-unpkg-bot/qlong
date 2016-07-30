package com.qlong.task;

import org.joda.time.DateTime;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * Created by qianlong on 2016/7/22.
 */
@Component
public class TaskJob {
    //在线cron格式生成 http://www.pdtools.net/tools/becron.jsp

    @Scheduled(cron = "0/5 * * * * ? ")
    void doJsoupJob(){
        System.out.println("time:"+ DateTime.now());
    }

}
