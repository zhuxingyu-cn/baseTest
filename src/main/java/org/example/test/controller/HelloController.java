package org.example.test.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <b>描述：</b><p>springboot示例代码
 *
 * <p><b>创建时间：</b><p>2026-01-12 21:46
 *
 * @author 朱兴宇
 * @version 1.0.0
 */
@RestController
public class HelloController {

    @GetMapping("/hello")
    public String hello() {
        return "Hello, Spring Boot!";
    }
}
