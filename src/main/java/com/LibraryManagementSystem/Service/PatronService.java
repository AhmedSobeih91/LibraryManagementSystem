package com.LibraryManagementSystem.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;

import com.LibraryManagementSystem.DTO.Patrons_DTO_Request;
import com.LibraryManagementSystem.Entity.Patrons;
import com.LibraryManagementSystem.Repository.PatronRepository;
import com.LibraryManagementSystem.mapper.mapperImpl;

import jakarta.transaction.Transactional;

@Service
public class PatronService {

	private final PatronRepository PatronRepo;
	private final mapperImpl mapperImpl;

	public PatronService(PatronRepository PatronRepo, mapperImpl mapperImpl) {

		this.PatronRepo = PatronRepo;
		this.mapperImpl = mapperImpl;
	}

	public List<Patrons> FindAllPatrons() throws NotFoundException {

		List<Patrons> patrons = PatronRepo.findAll();

		return patrons;
	}

	public Patrons FindPatron(int id) throws NotFoundException {
		Optional<Patrons> patron = PatronRepo.findById(id);
		Patrons PT = null;

		if (patron.isPresent()) {
			PT = patron.get();
		} else {
			throw new NotFoundException();
		}
		return PT;
	}

	@Transactional
	public void NewPatron(Patrons_DTO_Request DtoRequest) throws Exception {
		Patrons patrons = mapperImpl.Patrons_DTO_Request_TO_Patrons(DtoRequest);
		PatronRepo.save(patrons);
	}

	@Transactional
	public void Updatepatron(Patrons_DTO_Request DtoRequest) throws Exception {
		Patrons patrons = mapperImpl.Patrons_DTO_Request_TO_Patrons(DtoRequest);
		PatronRepo.save(patrons);
	}

	@Transactional
	public void DeletePatron(int id) throws NotFoundException {
		Patrons patron = FindPatron(id);
		PatronRepo.delete(patron);

	}

}
