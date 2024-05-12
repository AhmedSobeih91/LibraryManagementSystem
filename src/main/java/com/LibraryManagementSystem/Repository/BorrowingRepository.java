package com.LibraryManagementSystem.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.LibraryManagementSystem.Entity.BorrowingRecord;

@Repository
public interface BorrowingRepository extends JpaRepository<BorrowingRecord, Integer> {
	@Query(value = "select * from Borrowing_Record where book_id=:id and patron_id=:pid", nativeQuery = true)
	BorrowingRecord getborrow(@Param("id") int id, @Param("pid") int pid);

}
