package info.keyal.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import info.keyal.demo.model.User;
import info.keyal.demo.repository.UserRepository;

/**
 * User service
 *
 */
@Service
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
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
