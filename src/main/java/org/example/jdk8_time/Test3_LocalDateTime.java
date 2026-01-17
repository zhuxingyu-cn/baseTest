package org.example.jdk8_time;

import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 * <b>描述：</b><p>本地日期时间类
 *
 * <p><b>创建时间：</b><p>2026-01-17 21:50
 *
 * @author 朱兴宇
 * @version 1.0.0
 */
public class Test3_LocalDateTime {
    public static void main(String[] args) {
        //创建对象的方法：
        //使用now()方法创建对象，也适用于LocalDate、LocalTime
        //使用of()方法创建对象，也适用于LocalDate、LocalTime
        System.out.println("创建对象并打印：");
        LocalDateTime localDateTime = LocalDateTime.now();
        LocalDateTime localDateTime1 = LocalDateTime.of(2026, 1, 17, 21, 50, 50, 999);
        System.out.println(localDateTime);//2026-01-17T21:52:25.867
        System.out.println(localDateTime1);//2026-01-17T21:50:50.000000999

        //获取对象中的信息 获取时分秒纳秒
        System.out.println("获取年月日时分秒纳秒：");
        System.out.println(localDateTime.getYear());//2026
        System.out.println(localDateTime.getMonthValue());//1
        System.out.println(localDateTime.getDayOfMonth());//17
        System.out.println(localDateTime.getDayOfWeek().getValue());//6
        System.out.println(localDateTime.getDayOfYear());//17
        System.out.println(localDateTime.getHour());//22
        System.out.println(localDateTime.getMinute());//5
        System.out.println(localDateTime.getSecond());//52
        System.out.println(localDateTime.getNano());//325000000

        //修改某个信息，使用with开头的方法，是直接修改，会生成新的对象，不会影响之前的对象
        System.out.println("修改时分秒纳秒：");
        LocalDateTime localDateTime2 = localDateTime.withYear(2027).
                withMonth(2).
                withDayOfMonth(18).
                withHour(23).
                withMinute(2).
                withSecond(59).
                withNano(999);
        System.out.println(localDateTime2);//2027-02-18T23:02:59.000000999

        //把某个信息加多少，使用plus开头的方法

        //把某个信息加多少，使用minus开头的方法

        System.out.println("边界情况处理（可以正常处理）：");
        LocalDateTime localDateTime3 = LocalDateTime.of(2025, 12, 31, 23, 59, 59, 999999999);
        System.out.println(localDateTime3.plusNanos(1));//2026-01-01T00:00
        LocalDateTime localDateTime4 = LocalDateTime.of(2025, 1, 1, 0, 0, 0, 0);
        System.out.println(localDateTime4.minusNanos(1));//2024-12-31T23:59:59.999999999

        //判断两个时间是否相等，使用equals()，isBefore()，isAfter()
        System.out.println(localDateTime.isBefore(localDateTime1));//false
        System.out.println(localDateTime.equals(localDateTime1));//false
        System.out.println(localDateTime.isAfter(localDateTime1));//true
    }
}
