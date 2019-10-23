package info.keyal.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import info.keyal.demo.model.Customer;

/**
 * Customer Repository
 */
@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
}
