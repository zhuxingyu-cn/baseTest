package org.example.jdk8_time;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 * <b>描述：</b><p>本地日期类
 *
 * <p><b>创建时间：</b><p>2026-01-17 19:09
 *
 * @author 朱兴宇
 * @version 1.0.0
 */
public class Test1_LocalDate {
    public static void main(String[] args) {
        //创建对象的方法：
        //使用now()方法创建对象，也适用于LocalTime、LocalDateTime
        //使用of()方法创建对象，也适用于LocalTime、LocalDateTime
        System.out.println("创建对象并打印：");
        LocalDate localDate = LocalDate.now();
        LocalDate localDate1 = LocalDate.of(2026, 1, 15);
        System.out.println(localDate);//2026-01-17
        System.out.println(localDate1);//2026-01-15

        //获取对象中的信息 获取某年某月某日
        System.out.println("获取年月日：");
        int year = localDate.getYear();
        int monthValue = localDate.getMonthValue();
        //获取天数 = 这个月过了多少天了（包括当天）
        int dayValue = localDate.getDayOfMonth();
        System.out.println(year);//2026
        System.out.println(monthValue);//1
        System.out.println(dayValue);//17
        
        //获取周几 = 这周过了多少天了（包括当天）
        System.out.println("获取周几和本年过了多少天");
        int value = localDate.getDayOfWeek().getValue();
        System.out.println(value);//6
        //获取本年过了多少天数 = 本年过了多少天了（包括当天）
        int dayOfYear = localDate.getDayOfYear();
        System.out.println(dayOfYear);//17

        //修改某个信息，使用with开头的方法，是直接修改，会生成新的对象，不会影响之前的对象
        System.out.println("修改年月日和天数：");
        LocalDate localDate2 = localDate.withYear(2099);
        System.out.println(localDate2);//2099-01-17
        LocalDate localDate3 = localDate.withMonth(12);
        System.out.println(localDate3);//2026-12-17
        LocalDate localDate4 = localDate.withDayOfMonth(31);
        System.out.println(localDate4);//2026-01-31
        //修改天数是从当年的1月1号开始计算的
        LocalDate localDate5 = localDate.withDayOfYear(365);
        System.out.println(localDate5);//2026-12-31

        //把某个信息加多少，使用plus开头的方法
        System.out.println("加年月日和周：");
        LocalDate localDate6 = localDate.plusYears(1).
                plusMonths(1).
                plusDays(1);
        System.out.println(localDate6);//2027-02-18
        LocalDate localDate7 = localDate.plusWeeks(1);
        System.out.println(localDate7);//2026-01-24

        //把某个信息加多少，使用minus开头的方法
        System.out.println("减年月日和周：");
        LocalDate localDate8 = localDate.minusYears(1).
                minusMonths(1).
                minusDays(1);
        System.out.println(localDate8);//2024-12-16
        LocalDate localDate9 = localDate.minusWeeks(1);
        System.out.println(localDate9);//2026-01-10

        System.out.println("边界情况处理（可以正常处理）：");
        LocalDate LocalDate11 = LocalDate.of(2025, 12, 31);
        System.out.println(LocalDate11.plusDays(1));//2026-01-01
        LocalDate LocalDate12 = LocalDate.of(2025, 1, 1);
        System.out.println(LocalDate12.minusDays(1));//2024-12-31

        //判断两个日期是否相等，使用equals()
        // 判断一个日期是否在另外一个日期前面，使用isBefore()
        // 判断一个日期是否在另外一个日期后面，使用isAfter()
        System.out.println("判断两个日期对象是否相等、在前还是在后：");
        LocalDate localDate10 = LocalDate.of(2026, 1, 17);
        boolean before = localDate10.isBefore(localDate);
        boolean equals = localDate10.equals(localDate);
        boolean after = localDate10.isAfter(localDate);
        System.out.println(before);//false
        System.out.println(equals);//true
        System.out.println(after);//false

        boolean before1 = localDate6.isBefore(localDate);
        boolean equals1 = localDate6.equals(localDate);
        boolean after1 = localDate6.isAfter(localDate);
        System.out.println(before1);//false
        System.out.println(equals1);//false
        System.out.println(after1);//true

        boolean before2 = localDate8.isBefore(localDate);
        boolean equals2 = localDate8.equals(localDate);
        boolean after2 = localDate8.isAfter(localDate);
        System.out.println(before2);//true
        System.out.println(equals2);//false
        System.out.println(after2);//false
    }
}
