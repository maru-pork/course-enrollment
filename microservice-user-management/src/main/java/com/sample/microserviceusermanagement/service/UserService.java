package com.sample.microserviceusermanagement.service;

import com.sample.microserviceusermanagement.model.User;

import java.util.List;

public interface UserService {

    void saveUser(User user);
    User findByUsername(String username);
    List<User> findUsers(List<Long> ids);
}
