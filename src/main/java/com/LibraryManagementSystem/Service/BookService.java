package com.LibraryManagementSystem.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;

import com.LibraryManagementSystem.DTO.Books_DTO_Request;
import com.LibraryManagementSystem.Entity.Books;
import com.LibraryManagementSystem.Repository.BookRepository;
import com.LibraryManagementSystem.mapper.mapperImpl;

import jakarta.transaction.Transactional;

@Service
public class BookService {

	private final BookRepository bookRepo;
	private final mapperImpl mapperImpl;

	public BookService(BookRepository bookRepo, mapperImpl mapperImpl) {

		this.bookRepo = bookRepo;
		this.mapperImpl = mapperImpl;
	}

	public List<Books> FindAllBooks() throws NotFoundException {
		List<Books> books = bookRepo.findAll();
		return books;
	}

	public Books FindBook(int id) throws NotFoundException {

		Optional<Books> book = bookRepo.findById(id);
		Books BK = null;
		if (book.isPresent()) {
			BK = book.get();
		}
		return BK;
	}

	@Transactional
	public void NewBook(Books_DTO_Request DtoRequest) throws Exception {
		Books books = mapperImpl.Books_DTO_Request_To_Books(DtoRequest);
		bookRepo.save(books);

	}

	@Transactional
	public void UpdateBook(Books_DTO_Request DtoRequest) throws Exception {
		Books books = mapperImpl.Books_DTO_Request_To_Books(DtoRequest);
		bookRepo.save(books);
	}

	@Transactional
	public void DeleteBook(int id) throws Exception {
		Books book = FindBook(id);
		bookRepo.delete(book);
	}

}
