package info.keyal.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import info.keyal.demo.model.User;

/**
 * User Repository
 */
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    /**
     * Find a user by username
     * @param username user name
     * @return User
     */
    User findByUsername(String username);
}

