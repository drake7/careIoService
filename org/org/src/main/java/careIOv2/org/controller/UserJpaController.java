package careIOv2.org.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import careIOv2.org.dao.UserDaoService;
import careIOv2.org.dao.UserRepository;
import  careIOv2.org.entity.User;
import careIOv2.org.exception.UserNotFoundException;

import java.net.URI;
import java.util.*;

import javax.validation.Valid;

//we are allowed to create multiple controller(Note:Controller class must be inside the Init subpackage)
@RestController
public class UserJpaController {

	private UserDaoService service;
	
	private UserRepository repository;
	
	public UserJpaController(UserDaoService service,UserRepository repository)
	{
		this.service=service;
		this.repository=repository;
	}


	@GetMapping("/jpa/users")
	public List<User> retrieveAllUsers() {

		return repository.findAll();

	}

	// path variable
	@GetMapping("/jpa/users/{id}")
	public Optional<User> retrieveUser(@PathVariable int id) {

		Optional<User> user = repository.findById(id);
		if (!user.isPresent()) {
			throw new UserNotFoundException("id : " + id);
		}

		return user;
	}

	// path variable
	@PostMapping("/jpa/users")
	public ResponseEntity<User> addUser(@Valid @RequestBody User user) {
		User savedUser = repository.save(user);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(savedUser.getLoginId()).toUri();
		return ResponseEntity.created(location).build();

	}
	
	//to delete the user
	@DeleteMapping("/jpa/users/{id}")
	public void deleteUser(@PathVariable int id){
	
		repository.deleteById(id);
	}
}
