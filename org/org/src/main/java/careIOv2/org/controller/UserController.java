//package careIOv2.org.controller;
//
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
//
//import careIOv2.org.dao.UserDaoService;
//import  careIOv2.org.entity.User;
//import careIOv2.org.exception.UserNotFoundException;
//
//import java.net.URI;
//import java.util.*;
//
//import javax.validation.Valid;
//
////we are allowed to create multiple controller(Note:Controller class must be inside the Init subpackage)
//@RestController
//public class UserController {
//
//	private UserDaoService service;
//
//	// constructor injections
//	public UserController(UserDaoService service) {
//		this.service = service;
//	}
//
//
//	@CrossOrigin(origins = "http://localhost:5500")
//	@GetMapping("/users")
//	public List<User> retrieveAllUsers() {
//
//		return service.findAll();
//
//	}
//
//	// path variable
//	@GetMapping("/users/{id}")
//	public User retrieveUser(@PathVariable int id) {
//
//		User user = service.findById(id);
//		if (user == null) {
//			throw new UserNotFoundException("id : " + id);
//		}
//
//		return user;
//	}
//
//	// path variable
//	@PostMapping("/users")
//	public ResponseEntity<User> addUser(@Valid @RequestBody User user) {
//		User savedUser = service.createNewUser(user);
//		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
//				.buildAndExpand(savedUser.getLoginId()).toUri();
//		return ResponseEntity.created(location).build();
//
//	}
//	
//	//to delete the user
//	@DeleteMapping("/users/{id}")
//	public void deleteUser(@PathVariable int id){
//	
//		service.deleteById(id);
//	}
//}
