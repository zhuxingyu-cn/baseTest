package org.example.jdk8_time;

import java.time.LocalTime;

/**
 * <b>描述：</b><p>本地时间类
 *
 * <p><b>创建时间：</b><p>2026-01-17 20:28
 *
 * @author 朱兴宇
 * @version 1.0.0
 */
public class Test2_LocalTime {
    public static void main(String[] args) {
        //创建对象的方法：
        //使用now()方法创建对象，也适用于LocalDate、LocalDateTime
        //使用of()方法创建对象，也适用于LocalDate、LocalDateTime
        System.out.println("创建对象并打印：");
        LocalTime localTime = LocalTime.now();
        LocalTime localTime1 = LocalTime.of(20, 59, 59);
        System.out.println(localTime);//21:12:54.981
        System.out.println(localTime1);//20:59:59

        //获取对象中的信息 获取时分秒纳秒
        System.out.println("获取时分秒纳秒：");
        int hour = localTime.getHour();
        int minute = localTime.getMinute();
        int second = localTime.getSecond();
        int nano = localTime.getNano();
        System.out.println(hour);//21
        System.out.println(minute);//12
        System.out.println(second);//54
        System.out.println(nano);//981000000

        //修改某个信息，使用with开头的方法，是直接修改，会生成新的对象，不会影响之前的对象
        System.out.println("修改时分秒纳秒：");
        LocalTime localTime2 = localTime.withHour(19);
        LocalTime localTime3 = localTime.withMinute(19);
        LocalTime localTime4 = localTime.withSecond(19);
        LocalTime localTime5 = localTime.withNano(19);
        System.out.println(localTime2);//19:12:54.981
        System.out.println(localTime3);//21:19:54.981
        System.out.println(localTime4);//21:12:19.981
        System.out.println(localTime5);//21:12:54.000000019

        //把某个信息加多少，使用plus开头的方法
        System.out.println("加时分秒纳秒：");
        LocalTime localTime6 = localTime.plusHours(1).
                plusMinutes(1).
                plusSeconds(1).
                plusNanos(1);
        System.out.println(localTime6);//22:13:55.981000001

        //把某个信息加多少，使用minus开头的方法
        System.out.println("加时分秒纳秒：");
        LocalTime localTime7 = localTime.minusHours(1).
                minusMinutes(1).
                minusSeconds(1).
                minusNanos(1);
        System.out.println(localTime7);//20:11:53.980999999

        System.out.println("边界情况处理（可以正常处理）：");
        LocalTime localTime8 = LocalTime.of(23, 59, 59, 999999999);
        System.out.println(localTime8.plusNanos(1));//00:00
        LocalTime localTime9 = LocalTime.of(0, 0, 0, 0);
        System.out.println(localTime9.minusNanos(1));//23:59:59.999999999

        //判断两个时间是否相等，使用equals()，isBefore()，isAfter()
        LocalTime localTime10 = LocalTime.now();
        System.out.println(localTime10.isBefore(localTime));//false
        System.out.println(localTime10.equals(localTime));//false
        System.out.println(localTime10.isAfter(localTime));//true
    }
}
