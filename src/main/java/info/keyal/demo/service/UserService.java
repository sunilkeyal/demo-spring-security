package info.keyal.demo.service;

import info.keyal.demo.model.User;
import info.keyal.demo.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    /**
     * As of Spring 4.3, classes with a single constructor can omit the @Autowired annotation.
     * A nice little bit of convenience and boilerplate removal!
     */
    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    /**
     * Add a new user
     *
     * @param user User to add
     * @return newly created User
     */
    public User addUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    /**
     * Get all users
     *
     * @return list of users
     */
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}
