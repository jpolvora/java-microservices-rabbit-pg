package com.ms.user.producers;

import com.ms.user.dtos.EmailDto;
import com.ms.user.models.UserModel;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class UserProducer {
    final RabbitTemplate rabbitTemplate;

    public UserProducer(RabbitTemplate template) {
        this.rabbitTemplate = template;
    }


    @Value("${broker.queue.email.name}")
    private String routingKey;

    public void publishMessage(UserModel model) {
        var emailDto = new EmailDto(model.getUserId(),
                model.getEmail(),
                "Novo Cadastro",
                "Seja Bem vindo");

        rabbitTemplate.convertAndSend("", routingKey, emailDto);
    }
}
