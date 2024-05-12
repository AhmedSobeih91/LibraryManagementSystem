package com.LibraryManagementSystem.mapper;

import org.mapstruct.Mapper;

import com.LibraryManagementSystem.DTO.Books_DTO_Request;
import com.LibraryManagementSystem.Entity.Books;
import com.LibraryManagementSystem.DTO.BorrowingRecord_DTO_Request;
import com.LibraryManagementSystem.Entity.BorrowingRecord;
import com.LibraryManagementSystem.DTO.Patrons_DTO_Request;
import com.LibraryManagementSystem.Entity.Patrons;

@Mapper
public interface mapper {

	Books Books_DTO_Request_To_Books(Books_DTO_Request dto_req);

	BorrowingRecord BorrowingRecord_DTO_Request_To_BorrowingRecord(BorrowingRecord_DTO_Request dto_req);

	Patrons Patrons_DTO_Request_TO_Patrons(Patrons_DTO_Request dto_req);

	Books_DTO_Request Books_TO_Books_DTO_Request(Books books);

	BorrowingRecord_DTO_Request BorrowingRecord_To_BorrowingRecord_DTO_Request(BorrowingRecord borrowingRecord);

	Patrons_DTO_Request Patrons_TO_Patrons_DTO_Request(Patrons patrons);

}
