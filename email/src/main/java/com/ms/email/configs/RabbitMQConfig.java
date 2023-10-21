package com.ms.email.configs;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rabbitmq.client.AMQP;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    @Value("${broker.queue.email.name}")
    private String queue;

    @Bean
    public Queue queue() {
        return new Queue(this.queue, true);
    }

    @Bean
    public Jackson2JsonMessageConverter messageConverter() {
        var mapper = new ObjectMapper();
        return new Jackson2JsonMessageConverter(mapper);
    }
}
