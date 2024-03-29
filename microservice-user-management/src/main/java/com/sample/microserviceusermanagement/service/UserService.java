package com.sample.microserviceusermanagement.service;

import com.sample.microserviceusermanagement.model.User;

import java.util.List;

public interface UserService {

    void saveUser(User user);
    User findByUsername(String username);
    List<String> findUsers(List<Long> ids);
}
