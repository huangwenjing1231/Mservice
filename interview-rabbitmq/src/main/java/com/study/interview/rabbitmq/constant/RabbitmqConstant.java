package com.study.interview.rabbitmq.constant;

import lombok.experimental.UtilityClass;

/**
 * @author alice
 * @version 1.0
 * @description
 * @since 2020-06-25 16:50
 **/
@UtilityClass
public class RabbitmqConstant {

    /**
     * XXX业务队列
     */
    public static final String QUEUE = "queue";

    /**
     * XXX业务交换机
     */
    public static final String EXCHANGE = "exchange";

    /**
     * XXX业务路由key
     */
    public static final String ROUTING_KEY = "routingKey";
}
