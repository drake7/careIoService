package careIOv2.org.controller;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import careIOv2.org.dao.CustomerRepository;
import careIOv2.org.entity.Customer;
import careIOv2.org.exception.UserNotFoundException;

@CrossOrigin(origins = "http://localhost:5500")
@RestController
public class CustomerController {
	
private CustomerRepository customerRepository;
	
	public CustomerController(CustomerRepository customerRepository) {
	
		this.customerRepository=customerRepository;
	}
	
	@CrossOrigin(origins = "http://localhost:5500")
	@PostMapping("customer")
	public ResponseEntity<Customer> addCustomer(@Valid @RequestBody Customer customer) {
		Customer savedCustomer = customerRepository.save(customer);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(savedCustomer.getCustomerId()).toUri();
		
		return ResponseEntity.created(location).body(savedCustomer);
		
	}
	
	@CrossOrigin(origins = "http://localhost:5500")
	@GetMapping("customer/{id}")
	public Customer retrieveCustomer(@PathVariable int id) {

		java.util.Optional<Customer> customer = customerRepository.findById(id);
		if (customer == null) {
			throw new UserNotFoundException("id : " + id);
		}

		return customer.get();
	}

	
	

}
