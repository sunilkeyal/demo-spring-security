package info.keyal.demo.controller;

import info.keyal.demo.model.Role;
import info.keyal.demo.model.User;
import info.keyal.demo.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

@RestController
public class UserController {
    private final UserService userService;

    /**
     * As of Spring 4.3, classes with a single constructor can omit the @Autowired annotation.
     * A nice little bit of convenience and boilerplate removal!
     */
    public UserController(UserService userService) {
        this.userService = userService;
    }

    /**
     * Create new user
     *
     * @param user
     * @return newly created user
     */
    @PostMapping(value = "/users")
    public ResponseEntity<User> addUser(@RequestBody User user) {
        user.setRoles(Collections.singletonList(new Role("USER")));
        return ResponseEntity.ok(userService.addUser(user));
    }

    /**
     * Get list of users
     *
     * @return list of users
     */
    @GetMapping(value = "/users")
    public ResponseEntity<List<User>> getUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }
}
