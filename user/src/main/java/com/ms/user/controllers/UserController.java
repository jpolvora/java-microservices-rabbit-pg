package com.ms.user.controllers;

import com.ms.user.dtos.UserRecord;
import com.ms.user.models.UserModel;
import com.ms.user.services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    private final UserService service;

    public UserController(UserService service) {

        this.service = service;
    }
    @PostMapping("/users")
    public ResponseEntity<UserModel> saveUser(@RequestBody @Valid UserRecord dto) {
        var model = new UserModel();
        BeanUtils.copyProperties(dto, model);

        var result = this.service.save(model);

        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }
}
