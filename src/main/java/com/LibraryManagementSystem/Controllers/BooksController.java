package com.LibraryManagementSystem.Controllers;

import java.util.List;

import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.LibraryManagementSystem.DTO.Books_DTO_Request;
import com.LibraryManagementSystem.Entity.Books;
import com.LibraryManagementSystem.Service.BookService;
import com.LibraryManagementSystem.exception.EntityException;
import com.LibraryManagementSystem.exception.Not_Found_Exception;
import com.LibraryManagementSystem.mapper.mapperImpl;

@RestController
@RequestMapping("/api")
public class BooksController {
	private final BookService bookservice;
	private final mapperImpl mapperImpl;

	public BooksController(BookService bookservice, mapperImpl mapperImpl) {
		this.bookservice = bookservice;
		this.mapperImpl = mapperImpl;
	}

	@GetMapping("/books")
	public List<Books> getBooks() throws Not_Found_Exception {
		try {
			return bookservice.FindAllBooks();
		} catch (NotFoundException e) {
			throw new Not_Found_Exception("Not found Books");
		}
	}

	@GetMapping("/books/{id}")
	public ResponseEntity<Books_DTO_Request> getBook(@PathVariable("id") int id) throws Not_Found_Exception {
		Books book = null;
		Books_DTO_Request Books_DTO = null;
		try {
			book = bookservice.FindBook(id);
			if (book != null) {
				Books_DTO = mapperImpl.Books_TO_Books_DTO_Request(book);
				ResponseEntity<Books_DTO_Request> massage = new ResponseEntity<>(Books_DTO, HttpStatus.ACCEPTED);
				return massage;
			} else {
				throw new Not_Found_Exception("Not found Books");
			}
		} catch (NotFoundException e) {
			throw new Not_Found_Exception("Not found Books");
		}

	}

	@ExceptionHandler
	public ResponseEntity<EntityException> HandleException(Not_Found_Exception notFound) {
		EntityException error = new EntityException();
		error.setMassage(notFound.getMessage());
		ResponseEntity<EntityException> massage = new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
		return massage;
	}

	@PostMapping("/books")
	public ResponseEntity<String> NewBook(@RequestBody Books_DTO_Request book) {
		try {
			bookservice.NewBook(book);
			ResponseEntity<String> massage = new ResponseEntity<>("successful", HttpStatus.CREATED);
			return massage;
		} catch (Exception e) {
			ResponseEntity<String> massage = new ResponseEntity<>("Not Created", HttpStatus.NOT_FOUND);
			return massage;
		}

	}

	@PutMapping("/books")
	public ResponseEntity<String> UpdateBook(@RequestBody Books_DTO_Request book) {

		try {
			Books books = bookservice.FindBook(book.getID());
			if (books.getID() != 0) {
				bookservice.UpdateBook(book);
				ResponseEntity<String> massage = new ResponseEntity<>("successful", HttpStatus.ACCEPTED);
				return massage;
			} else {
				ResponseEntity<String> massage = new ResponseEntity<>("Not Updated", HttpStatus.NOT_FOUND);
				return massage;
			}
		} catch (Exception e) {
			ResponseEntity<String> massage = new ResponseEntity<>("Not Updated", HttpStatus.NOT_FOUND);
			return massage;
		}

	}

	@DeleteMapping("/books/{id}")
	public ResponseEntity<String> DeleteBook(@PathVariable("id") int id) {

		try {
			bookservice.DeleteBook(id);
			ResponseEntity<String> massage = new ResponseEntity<>("successful", HttpStatus.ACCEPTED);
			return massage;
		} catch (Exception e) {
			ResponseEntity<String> massage = new ResponseEntity<>("Not Deleted", HttpStatus.NOT_FOUND);
			return massage;
		}

	}

}
