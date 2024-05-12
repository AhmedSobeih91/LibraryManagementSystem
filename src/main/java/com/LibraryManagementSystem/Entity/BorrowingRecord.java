package com.LibraryManagementSystem.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "Borrowing_Record")
public class BorrowingRecord {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int ID;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "book_id")
	private Books book;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "patron_id")
	private Patrons patron;
	@Column
	private String BorrwingDate;
	@Column
	private String ReturnDate;
	@Column
	private String returned;

}
