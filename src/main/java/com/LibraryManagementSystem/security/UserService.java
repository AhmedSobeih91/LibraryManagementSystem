package com.LibraryManagementSystem.security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.LibraryManagementSystem.DTO.Users_DTO_Request;
import com.LibraryManagementSystem.Repository.UserRepository;

import jakarta.transaction.Transactional;

@Service
public class UserService implements UserDetailsService {

	private final UserRepository UserRepo;

	public UserService(UserRepository userRepo) {

		this.UserRepo = userRepo;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserDetail user = UserRepo.findByUsername(username);
		if (user == null) {
			throw new UsernameNotFoundException("this user is not found");
		}

		return new UserDetail(user.getUsername(), user.getPassword(), user.getRoles());
	}

	@Transactional
	public void NewUser(Users_DTO_Request request) {
		UserDetail user = new UserDetail();
		user.setUsername(request.getUsername());
		user.setPassword(request.getPassword());
		user.setRoles(request.getRoles());
		UserRepo.save(user);
	}

}
