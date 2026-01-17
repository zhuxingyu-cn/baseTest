package org.example.jdk8_time;

import java.time.Clock;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Set;

/**
 * <b>描述：</b><p>一个时区ID类和 带有时区的日期时间类（具有时区的日期时间的不可变表示类测试类）
 *
 * <p><b>创建时间：</b><p>2026-01-17 21:50
 *
 * @author 朱兴宇
 * @version 1.0.0
 */
public class Test4_ZoneId_ZonedDateTime {
    public static void main(String[] args) {
        //创建对象的方法：
        ZoneId zoneId = ZoneId.systemDefault();
        System.out.println(zoneId);//Asia/Shanghai
        System.out.println(zoneId.getId());//Asia/Shanghai 也就是toString()调用了getId()方法

        Set<String> availableZoneIds = ZoneId.getAvailableZoneIds();
        System.out.println(availableZoneIds);//包括 America/New_York
        System.out.println(availableZoneIds.size());//599个结果

        //ZonedDateTime创建对象的方法
        //使用时区id类对象创建带有时区的日期时间类
        ZonedDateTime now = ZonedDateTime.now(zoneId);
        System.out.println(now);//2026-01-17T22:21:16.664+08:00[Asia/Shanghai]
        //使用世界标准时间创建
        ZonedDateTime now1 = ZonedDateTime.now(Clock.systemUTC());
        System.out.println(now1);//2026-01-17T14:24:44.554Z
        //默认创建
        ZonedDateTime now2 = ZonedDateTime.now();
        System.out.println(now2);//2026-01-17T22:26:52.032+08:00[Asia/Shanghai]

        //ZonedDateTime和LocalDateTime的方法是一样的，按照那个学习就可以了
    }
}
