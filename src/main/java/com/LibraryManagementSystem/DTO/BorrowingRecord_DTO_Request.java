package com.LibraryManagementSystem.DTO;

import lombok.Data;

@Data
public class BorrowingRecord_DTO_Request {

	private int ID;
	private int Book_ID;
	private int Patron_ID;
	private String BorrwingDate;
	private String ReturnDate;
	private boolean returned;

}
