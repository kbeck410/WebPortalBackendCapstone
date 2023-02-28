package net.adminPortal.controller;

import net.adminPortal.entity.User;

import net.adminPortal.exception.ResourceNotFoundException;
import net.adminPortal.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/")
public class UserController {
	@Autowired
	private UserRepository userRepository;

	// get all employees
	@GetMapping("/users")
	public List<User> getUserList(){
		return userRepository.findAll();
	}

	// create employee rest api
	@PostMapping("/users")
	public User createUser(@RequestBody User user) {
		return userRepository.save(user);
	}

	// get employee by id rest api
	@GetMapping("/users/{USERNAME}")
	public ResponseEntity<User> getUserByUSERNAME(@PathVariable Long USERNAME) {
		User user = userRepository.findById(USERNAME)
				.orElseThrow(() -> new ResourceNotFoundException("User not exist with id :" + USERNAME));
		return ResponseEntity.ok(user);
	}

	// update employee rest api

	@PutMapping("/users/{USERNAME}")
	public ResponseEntity<User> updateUser(@PathVariable Long USERNAME, @RequestBody User userDetails){
		User user = userRepository.findById(USERNAME)
				.orElseThrow(() -> new ResourceNotFoundException("User does not exist with username :" + USERNAME));

		user.setFirstName(userDetails.getFirstName());
		user.setLastName(userDetails.getLastName());
		user.setEmail(userDetails.getEmail());

		User updatedUser = userRepository.save(user);
		return ResponseEntity.ok(updatedUser);
	}

	// delete employee rest api
	@DeleteMapping("/users/{USERNAME}")
	public ResponseEntity<Map<String, Boolean>> deleteUser(@PathVariable Long USERNAME){
		User user = userRepository.findById(USERNAME)
				.orElseThrow(() -> new ResourceNotFoundException("User not exist with username :" + USERNAME));

		userRepository.delete(user);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
}