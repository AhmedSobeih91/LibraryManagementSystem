package com.LibraryManagementSystem.Service;

import java.util.Date;

import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;

import com.LibraryManagementSystem.Entity.Books;
import com.LibraryManagementSystem.Entity.BorrowingRecord;
import com.LibraryManagementSystem.Entity.Patrons;
import com.LibraryManagementSystem.Repository.BorrowingRepository;

import jakarta.transaction.Transactional;

@Service
public class BorrowingService {

	private final BorrowingRepository BorrowingRepo;
	private final BookService bookservice;
	private final PatronService patronservice;

	public BorrowingService(BorrowingRepository BorrowingRepo, BookService bookservice, PatronService patronservice) {

		this.BorrowingRepo = BorrowingRepo;
		this.bookservice = bookservice;
		this.patronservice = patronservice;
	}

	@Transactional
	public void NewBorrow(int bookid, int patronid) throws NotFoundException {

		Books book = bookservice.FindBook(bookid);
		Patrons patron = patronservice.FindPatron(patronid);
		if (book == null || patron == null) {
			throw new NotFoundException();
		}
		BorrowingRecord borrow = new BorrowingRecord();
		borrow.setBook(book);
		borrow.setPatron(patron);
		borrow.setBorrwingDate(new Date(System.currentTimeMillis()).toString());
		borrow.setReturnDate(new Date(System.currentTimeMillis() + 7 * 24 * 60 * 60 * 1000).toString());
		borrow.setReturned("false");
		BorrowingRepo.save(borrow);

	}

	@Transactional
	public void UpdateBorrow(int bookid, int patronid) throws NotFoundException {
		BorrowingRecord borrow = BorrowingRepo.getborrow(bookid, patronid);
		if (borrow == null) {
			throw new NotFoundException();
		}
		borrow.setReturned("true");
		BorrowingRepo.save(borrow);
	}

}
