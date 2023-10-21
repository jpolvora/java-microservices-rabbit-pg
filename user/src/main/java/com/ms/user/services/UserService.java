package com.ms.user.services;
import com.ms.user.models.UserModel;
import com.ms.user.producers.UserProducer;
import com.ms.user.repositories.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;


@Service
public class UserService {
    final UserRepository repository;
    final UserProducer producer;

    public UserService(UserRepository repository, UserProducer producer ) {
        this.repository = repository;
        this.producer = producer;
    }

    @Transactional
    public UserModel save(UserModel model) {
        var result = this.repository.save(model);
        this.producer.publishMessage(result);

        return result;
    }
}
