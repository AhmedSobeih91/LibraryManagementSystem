package com.LibraryManagementSystem.DTO;

import lombok.Data;

@Data
public class Users_DTO_Request {

	private int id;
	private String username;
	private String password;
	private String roles;

}
