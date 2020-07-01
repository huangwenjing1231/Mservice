package com.study.interview.rabbitmq.config;

import com.study.interview.rabbitmq.constant.RabbitmqConstant;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author alice
 * @version 1.0
 * @description
 * @since 2020-06-25 13:40
 **/
@Slf4j
@Component
public class RabbitmqConfig implements RabbitTemplate.ConfirmCallback {

    @Resource
    private CachingConnectionFactory cachingConnectionFactory;

    @Bean
    public RabbitTemplate rabbitTemplate() {
        RabbitTemplate rabbitTemplate = new RabbitTemplate(cachingConnectionFactory);
        rabbitTemplate.setConfirmCallback(this);
        return rabbitTemplate;
    }

    @Bean
    public Queue queue() {
        return new Queue(RabbitmqConstant.QUEUE);
    }

    @Bean
    public DirectExchange directExchange() {
        return new DirectExchange(RabbitmqConstant.EXCHANGE);
    }

    @Bean
    public Binding binding() {
        return BindingBuilder.bind(queue()).to(directExchange()).with(RabbitmqConstant.ROUTING_KEY);
    }

    @Override
    public void confirm(CorrelationData correlationData, boolean ack, String cause) {
        log.info("Confirm=" + correlationData + ", ack=" + ack + (cause == null ? "" : ", cause: " + cause));
    }
}
