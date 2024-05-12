package com.LibraryManagementSystem.Controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.LibraryManagementSystem.DTO.Users_DTO_Request;
import com.LibraryManagementSystem.security.UserService;

@RestController
@RequestMapping("/api")
public class UsersController {
	private final UserService userService;

	public UsersController(UserService userService) {
		this.userService = userService;
	}

	@PostMapping("/signup")
	public ResponseEntity<String> NewUser(@RequestBody Users_DTO_Request user) {
		if (user.getUsername() != null && user.getPassword() != null && user.getRoles() != null) {
			userService.NewUser(user);
			ResponseEntity<String> massage = new ResponseEntity<>("successful", HttpStatus.CREATED);
			return massage;
		} else {
			ResponseEntity<String> massage = new ResponseEntity<>("Not Created :- please enter all fields  ",
					HttpStatus.NOT_FOUND);
			return massage;
		}

	}

}
