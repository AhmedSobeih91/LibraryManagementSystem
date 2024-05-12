package com.LibraryManagementSystem.Controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.LibraryManagementSystem.Service.BorrowingService;

@RestController
@RequestMapping("/api")
public class RorrowController {
	private final BorrowingService borrowservice;

	public RorrowController(BorrowingService borrowservice) {
		this.borrowservice = borrowservice;
	}

	@PostMapping("/borrow/{bookid}/patron/{patronid}")
	public ResponseEntity<String> NewBorrow(@PathVariable("bookid") int bookid,
			@PathVariable("patronid") int patronid) {
		try {
			borrowservice.NewBorrow(bookid, patronid);
			ResponseEntity<String> massage = new ResponseEntity<>("successful", HttpStatus.CREATED);
			return massage;
		} catch (Exception ex) {
			ResponseEntity<String> massage = new ResponseEntity<>("Not Created", HttpStatus.NOT_FOUND);
			return massage;
		}
	}

	@PutMapping("/return/{bookid}/patron/{patronid}")
	public ResponseEntity<String> UpdateBorrow(@PathVariable("bookid") int bookid,
			@PathVariable("patronid") int patronid) {
		try {
			borrowservice.UpdateBorrow(bookid, patronid);
			ResponseEntity<String> massage = new ResponseEntity<>("successful", HttpStatus.CREATED);
			return massage;
		} catch (Exception ex) {
			ResponseEntity<String> massage = new ResponseEntity<>("Not update", HttpStatus.NOT_FOUND);
			return massage;
		}
	}
}