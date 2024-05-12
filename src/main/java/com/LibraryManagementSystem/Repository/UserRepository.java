package com.LibraryManagementSystem.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.LibraryManagementSystem.security.UserDetail;

@Repository
public interface UserRepository extends JpaRepository<UserDetail, String> {
	UserDetail findByUsername(String username);
}
