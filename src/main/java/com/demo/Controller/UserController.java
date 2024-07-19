package com.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.Entity.User;
import com.demo.Service.UserService;
import com.demo.exception.UserNotFoundException;

@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserService userService;

	@GetMapping("/alluser")
	public ResponseEntity<List<User>> getAllUser() {
		List<User> lis = userService.getAllUser();
		return new ResponseEntity<List<User>>(lis, HttpStatus.OK);
	}

	@PostMapping("/adduser")
	public ResponseEntity<User> addUser(@RequestBody User user) throws Exception {
		User addedUser = userService.addUser(user);
		return new ResponseEntity<User>(addedUser, HttpStatus.CREATED);
	}

	@GetMapping("/{id}")
	public ResponseEntity<User> getUserById(@PathVariable Long id) throws UserNotFoundException {
		User getUser = userService.findUser(id);
		return new ResponseEntity<User>(getUser, HttpStatus.OK);
	}

	@DeleteMapping("/delete/{id}")
	public void deleteUserById(@PathVariable Long id) throws UserNotFoundException {
		userService.deleteUser(id);
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<User> updateUserById(@RequestBody User user, @PathVariable Long id) {
		User user1 = userService.updateUser(user, id);
		return new ResponseEntity<User>(user1, HttpStatus.OK);
	}

}
