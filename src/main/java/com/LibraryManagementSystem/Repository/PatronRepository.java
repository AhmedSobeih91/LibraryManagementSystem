package com.LibraryManagementSystem.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.LibraryManagementSystem.Entity.Patrons;

@Repository
public interface PatronRepository extends JpaRepository<Patrons, Integer> {

}
