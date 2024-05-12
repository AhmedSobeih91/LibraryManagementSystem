package com.LibraryManagementSystem.DTO;

import lombok.Data;

@Data
public class Books_DTO_Request {

	private int ID;
	private String Title;
	private String Author;
	private String Publication_Year;
	private int ISBN;

}
