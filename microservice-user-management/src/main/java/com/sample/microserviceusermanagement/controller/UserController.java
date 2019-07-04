package com.sample.microserviceusermanagement.controller;

import com.sample.microserviceusermanagement.model.Role;
import com.sample.microserviceusermanagement.model.User;
import com.sample.microserviceusermanagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/service/registration")
    public ResponseEntity<?> register(@RequestBody User user){
        if(userService.findByUsername(user.getUsername()) != null) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }

        user.setRole(Role.USER);
        userService.saveUser(user);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/api/user/service/user")
    public ResponseEntity<?> getUser(Principal principal) {
        if (principal == null || principal.getName() == null) {
            return ResponseEntity.ok(principal);
        }

        return new ResponseEntity<User>(
                userService.findByUsername(principal.getName()),
                HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/service/names")
    public ResponseEntity<?> getUsers(@RequestBody List<Long> ids) {
        return ResponseEntity.ok(userService.findUsers(ids));
    }
}
