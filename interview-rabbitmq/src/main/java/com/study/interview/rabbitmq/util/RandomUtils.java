package com.study.interview.rabbitmq.util;

import java.util.UUID;

/**
 * @author alice
 * @version 1.0
 * @description
 * @since 2020-06-25 16:54
 **/
public class RandomUtils {

    public static String getUUID() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }
}
