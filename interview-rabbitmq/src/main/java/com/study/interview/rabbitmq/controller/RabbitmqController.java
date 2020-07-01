package com.study.interview.rabbitmq.controller;

import com.study.interview.rabbitmq.constant.RabbitmqConstant;
import com.study.interview.rabbitmq.util.RandomUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author alice
 * @version 1.0
 * @description
 * @since 2020-06-25 16:48
 **/
@Slf4j
@RestController
public class RabbitmqController {

    @Resource
    private RabbitTemplate rabbitTemplate;

    @RequestMapping("/send")
    public Object send(@RequestParam String message) {
        CorrelationData correlationData = new CorrelationData(RandomUtils.getUUID());
        log.info("correlationData:{}", correlationData);
        this.rabbitTemplate.convertAndSend(RabbitmqConstant.EXCHANGE, RabbitmqConstant.ROUTING_KEY, message, correlationData);
        return message;
    }

    @RabbitListener(queues = RabbitmqConstant.QUEUE)
    public void listen(Message message) {
        log.info("receive message [{}]", message);
    }
}
