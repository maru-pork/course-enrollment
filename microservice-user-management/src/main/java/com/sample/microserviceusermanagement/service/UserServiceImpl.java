package com.sample.microserviceusermanagement.service;

import com.sample.microserviceusermanagement.model.User;
import com.sample.microserviceusermanagement.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public void saveUser(User user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
}

    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public List<User> findUsers(List<Long> ids){
        return userRepository.findUsersByIds(ids);
    }
}
