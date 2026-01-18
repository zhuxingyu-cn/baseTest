package org.example.jdk8_time;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;

/**
 * <b>描述：</b><p>格式化器、用于时间的格式化和解析
 * 作用：代替SimpleDateFormat（线程不安全）、线程安全
 *
 * <p><b>创建时间：</b><p>2026-01-18 16:04
 *
 * @author 朱兴宇
 * @version 1.0.0
 */
public class Test6_DateTimeFormatter {
    public static void main(String[] args) {
        //怎么创建对象，使用ofPattern()
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        //如何对时间进行格式化 分为正向格式化和反向格式化
        //正常用法
        System.out.println(dateTimeFormatter.format(LocalDateTime.now()));//2026-01-18 16:32:26
        //使用时刻去做格式化
        String format = dateTimeFormatter.format(Instant.now().atZone(ZoneId.systemDefault()));
        System.out.println(format);//2026-01-18 16:32:26
        //反向格式化
        LocalDateTime now = LocalDateTime.now();
        String format1 = now.format(dateTimeFormatter);
        System.out.println(format1);//2026-01-18 16:32:26

        //解析时间
        String s = "2026年1月20日 13:12:12";
        DateTimeFormatter dateTimeFormatter2 = DateTimeFormatter.ofPattern("yyyy年MM月dd日 HH:mm:ss");
        LocalDateTime parse = LocalDateTime.parse(s, dateTimeFormatter2);
        System.out.println(parse);//2026-01-20T13:12:12
    }
}
