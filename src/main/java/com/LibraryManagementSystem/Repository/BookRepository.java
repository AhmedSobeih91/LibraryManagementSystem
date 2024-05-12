package com.LibraryManagementSystem.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.LibraryManagementSystem.Entity.Books;

@Repository
public interface BookRepository extends JpaRepository<Books, Integer> {

}
