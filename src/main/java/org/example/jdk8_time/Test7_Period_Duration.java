package org.example.jdk8_time;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;

/**
 * <b>描述：</b><p>Period计算日期间隔（年月日） Duration计算时间间隔（天时分秒毫秒纳秒）
 *
 * <p><b>创建时间：</b><p>2026-01-18 16:37
 *
 * @author 朱兴宇
 * @version 1.0.0
 */
public class Test7_Period_Duration {
    public static void main(String[] args) {
        //Period怎么创建对象，使用between()
        LocalDate localDate = LocalDate.of(2025, 2, 19);
        LocalDate localDate2 = LocalDate.of(2026, 1, 18);
        Period between = Period.between(localDate, localDate2);

        //计算年月日相差多少  自然历法差
        System.out.println(between.getYears());//0 相差0年
        System.out.println(between.getMonths());//10 相差10个月
        System.out.println(between.getDays());//30天 相差30天


        //Duration怎么创建对象，使用between()
        LocalDateTime localDateTime = LocalDateTime.of(2025, 2, 19, 16, 55, 0);
        LocalDateTime localDateTime2 = LocalDateTime.of(2026, 1, 18, 16, 54, 59);
        //计算相差天时分秒毫秒纳秒
        //Duration 是以「纳秒」为最小单位，计算两个时间点之间的「总时间间隔」，再按需转换为秒、分、时等单位，它遵循 “绝对时间差” 规则（而非 Period 的自然历法）
        Duration duration = Duration.between(localDateTime, localDateTime2);
        System.out.println(duration.toDays());//332
        System.out.println(duration.toHours());//7991
        System.out.println(duration.toMinutes());//479519
        System.out.println(duration.getSeconds());//28771199
        System.out.println(duration.toMillis());//28771199000
        System.out.println(duration.toNanos());//28771199000000000
    }
}
