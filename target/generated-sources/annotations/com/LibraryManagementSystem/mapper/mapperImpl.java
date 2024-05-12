package com.LibraryManagementSystem.mapper;

import com.LibraryManagementSystem.DTO.Books_DTO_Request;
import com.LibraryManagementSystem.DTO.BorrowingRecord_DTO_Request;
import com.LibraryManagementSystem.DTO.Patrons_DTO_Request;
import com.LibraryManagementSystem.Entity.Books;
import com.LibraryManagementSystem.Entity.BorrowingRecord;
import com.LibraryManagementSystem.Entity.Patrons;
import javax.annotation.processing.Generated;

import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-05-12T11:25:26+0300",
    comments = "version: 1.5.5.Final, compiler: Eclipse JDT (IDE) 3.35.0.v20230814-2020, environment: Java 17.0.8.1 (Eclipse Adoptium)"
)
@Component
public class mapperImpl implements mapper {

    @Override
    public Books Books_DTO_Request_To_Books(Books_DTO_Request dto_req) {
        if ( dto_req == null ) {
            return null;
        }

        Books books = new Books();

        books.setAuthor( dto_req.getAuthor() );
        books.setID( dto_req.getID() );
        books.setISBN( dto_req.getISBN() );
        books.setPublication_Year( dto_req.getPublication_Year() );
        books.setTitle( dto_req.getTitle() );

        return books;
    }

    @Override
    public BorrowingRecord BorrowingRecord_DTO_Request_To_BorrowingRecord(BorrowingRecord_DTO_Request dto_req) {
        if ( dto_req == null ) {
            return null;
        }

        BorrowingRecord borrowingRecord = new BorrowingRecord();

        borrowingRecord.setBorrwingDate( dto_req.getBorrwingDate() );
        borrowingRecord.setID( dto_req.getID() );
        borrowingRecord.setReturnDate( dto_req.getReturnDate() );
        borrowingRecord.setReturned( String.valueOf( dto_req.isReturned() ) );

        return borrowingRecord;
    }

    @Override
    public Patrons Patrons_DTO_Request_TO_Patrons(Patrons_DTO_Request dto_req) {
        if ( dto_req == null ) {
            return null;
        }

        Patrons patrons = new Patrons();

        patrons.setContact_Info( dto_req.getContact_Info() );
        patrons.setID( dto_req.getID() );
        patrons.setName( dto_req.getName() );

        return patrons;
    }

    @Override
    public Books_DTO_Request Books_TO_Books_DTO_Request(Books books) {
        if ( books == null ) {
            return null;
        }

        Books_DTO_Request books_DTO_Request = new Books_DTO_Request();

        books_DTO_Request.setAuthor( books.getAuthor() );
        if ( books.getID() != null ) {
            books_DTO_Request.setID( books.getID() );
        }
        books_DTO_Request.setISBN( books.getISBN() );
        books_DTO_Request.setPublication_Year( books.getPublication_Year() );
        books_DTO_Request.setTitle( books.getTitle() );

        return books_DTO_Request;
    }

    @Override
    public BorrowingRecord_DTO_Request BorrowingRecord_To_BorrowingRecord_DTO_Request(BorrowingRecord borrowingRecord) {
        if ( borrowingRecord == null ) {
            return null;
        }

        BorrowingRecord_DTO_Request borrowingRecord_DTO_Request = new BorrowingRecord_DTO_Request();

        borrowingRecord_DTO_Request.setBorrwingDate( borrowingRecord.getBorrwingDate() );
        borrowingRecord_DTO_Request.setID( borrowingRecord.getID() );
        borrowingRecord_DTO_Request.setReturnDate( borrowingRecord.getReturnDate() );
        if ( borrowingRecord.getReturned() != null ) {
            borrowingRecord_DTO_Request.setReturned( Boolean.parseBoolean( borrowingRecord.getReturned() ) );
        }

        return borrowingRecord_DTO_Request;
    }

    @Override
    public Patrons_DTO_Request Patrons_TO_Patrons_DTO_Request(Patrons patrons) {
        if ( patrons == null ) {
            return null;
        }

        Patrons_DTO_Request patrons_DTO_Request = new Patrons_DTO_Request();

        patrons_DTO_Request.setContact_Info( patrons.getContact_Info() );
        patrons_DTO_Request.setID( patrons.getID() );
        patrons_DTO_Request.setName( patrons.getName() );

        return patrons_DTO_Request;
    }
}
