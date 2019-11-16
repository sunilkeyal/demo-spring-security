package info.keyal.demo.controller;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import info.keyal.demo.model.Role;
import info.keyal.demo.model.User;
import info.keyal.demo.service.UserService;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping(value = "/users")
    public ResponseEntity<User> addUser(@RequestBody User user) {
        user.setRoles(Collections.singletonList(new Role("USER")));
        return ResponseEntity.ok(userService.addUser(user));
    }
}
