package org.example.jdk8_time;

import java.time.Instant;

/**
 * <b>描述：</b><p>时间线上的某个时刻/时间戳
 * 作用：可以用来记录代码的执行时间或者记录用于操作某个事件的时间点
 * 代替Date类的原因是不可变对象，并且可以精确到纳秒
 *
 * <p><b>创建时间：</b><p>2026-01-18 15:50
 *
 * @author 朱兴宇
 * @version 1.0.0
 */
public class Test5_Instant {
    public static void main(String[] args) {
        //如何创建对象 和之前的是一样使用now()
        Instant now = Instant.now();
        System.out.println(now);//2026-01-18T07:50:09.586Z

        //获取总秒数、总毫秒数、当前的纳秒数
        long epochSecond = now.getEpochSecond();
        //获取毫秒数使用to方法
        long epochMilli = now.toEpochMilli();
        int nano = now.getNano();
        System.out.println(epochSecond);//1768722609
        System.out.println(epochMilli);//1768722609586
        System.out.println(nano);//586000000

        //增加系列的方法使用plus方法

        //减少系列的方法使用minus方法

        //判断系列的方法使用isBefore() equals() isAfter()
    }
}
