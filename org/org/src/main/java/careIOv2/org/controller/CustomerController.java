package careIOv2.org.controller;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

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
import careIOv2.org.entity.CustomerNew;
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
	
	@CrossOrigin(origins = "http://localhost:5500")
	@GetMapping("customer")
	public List<CustomerNew> retrieveCustomers() {

		List<Customer> customerList = customerRepository.findAll();
		
		List<CustomerNew> customerNewList = new ArrayList<CustomerNew>();
		
		
		for(Customer cust: customerList)
		{
			CustomerNew customerNew = new CustomerNew();
			customerNew.setAddress(cust.getAddress());
			customerNew.setCity(cust.getCity());
			customerNew.setCustomerId(cust.getCustomerId());
			customerNew.setEmail(cust.getUsername());
			customerNew.setFirstName(cust.getFirstName());
			customerNew.setLastName(cust.getLastName());
			customerNew.setPassword(cust.getPassword());
			customerNew.setProvince(cust.getProvince());
			customerNew.setRoles(cust.getRoles());
			customerNew.setContact(cust.getContact());
			customerNewList.add(customerNew);
		}
		

		return customerNewList;
	}

	
	

}
