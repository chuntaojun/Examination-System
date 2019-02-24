package com.tensor.org.work.utils;

import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;

/**
 * @author liaochuntao
 */
@Slf4j
public class CronExpressUtils {

    /**
     * 特定时间任务corn表达式生成
     * @param date
     * @return
     */
    public static String date2CornExpress(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        int minute = calendar.get(Calendar.MINUTE);
        StringBuilder cornBuilder = new StringBuilder();
        cornBuilder.append(0).append(" ")
                .append(minute).append(" ")
                .append(hour).append(" ")
                .append(day).append(" ")
                .append(month + 1).append(" ")
                .append("?").append(" ")
                .append(year);
        return cornBuilder.toString();
    }

}
