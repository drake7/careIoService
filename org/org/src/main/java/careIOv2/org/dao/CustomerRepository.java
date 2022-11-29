package careIOv2.org.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import careIOv2.org.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

	Optional<Customer> findByUserName(String username);
}
