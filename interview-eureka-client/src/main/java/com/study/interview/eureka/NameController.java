package com.study.interview.eureka;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author alice
 * @version 1.0
 * @description
 * @since 2020-07-02 01:37
 **/
@RestController
public class NameController {
    @Value("${name}")
    private String name;

    @RequestMapping("/name")
    public String name(){
        return name;
    }
}
