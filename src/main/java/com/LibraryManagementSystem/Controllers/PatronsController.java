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

import com.LibraryManagementSystem.DTO.Patrons_DTO_Request;
import com.LibraryManagementSystem.Entity.Patrons;
import com.LibraryManagementSystem.Service.PatronService;
import com.LibraryManagementSystem.exception.EntityException;
import com.LibraryManagementSystem.exception.Not_Found_Exception;

@RestController
@RequestMapping("/api")
public class PatronsController {
	private final PatronService patronservice;

	public PatronsController(PatronService patronservice) {
		this.patronservice = patronservice;
	}

	@GetMapping("/patrons")
	public List<Patrons> getPatrons() throws Not_Found_Exception {
		try {
			return patronservice.FindAllPatrons();
		} catch (NotFoundException e) {
			throw new Not_Found_Exception("Not found patrons");
		}
	}

	@GetMapping("/patrons/{id}")
	public ResponseEntity<Patrons> getPatron(@PathVariable("id") int id) throws Not_Found_Exception {
		Patrons patron = null;
		try {
			patron = patronservice.FindPatron(id);
			if (patron != null) {
				ResponseEntity<Patrons> massage = new ResponseEntity<>(patron, HttpStatus.OK);
				return massage;
			} else {
				throw new Not_Found_Exception("Not found patrons");
			}
		} catch (NotFoundException e) {
			throw new Not_Found_Exception("Not found patrons");
		}

	}

	@ExceptionHandler
	public ResponseEntity<EntityException> HandleException(Not_Found_Exception notFound) {
		EntityException error = new EntityException();
		error.setMassage(notFound.getMessage());
		ResponseEntity<EntityException> massage = new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
		return massage;
	}

	@PostMapping("/patrons")
	public ResponseEntity<String> NewBook(@RequestBody Patrons_DTO_Request patron) {
		try {
			patronservice.NewPatron(patron);
			ResponseEntity<String> massage = new ResponseEntity<>("successful", HttpStatus.CREATED);
			return massage;
		} catch (Exception e) {
			ResponseEntity<String> massage = new ResponseEntity<>("Not Created", HttpStatus.NOT_FOUND);
			return massage;
		}

	}

	@PutMapping("/patrons")
	public ResponseEntity<String> UpdatePatron(@RequestBody Patrons_DTO_Request patron) {

		try {
			Patrons Patronss = patronservice.FindPatron(patron.getID());
			if (Patronss.getID() != 0) {
				patronservice.Updatepatron(patron);
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

	@DeleteMapping("/patrons/{id}")
	public ResponseEntity<String> DeletePatron(@PathVariable("id") int id) {
		try {
			patronservice.DeletePatron(id);
			ResponseEntity<String> massage = new ResponseEntity<>("successful", HttpStatus.ACCEPTED);
			return massage;
		} catch (Exception e) {
			ResponseEntity<String> massage = new ResponseEntity<>("Not Deleted", HttpStatus.NOT_FOUND);
			return massage;
		}

	}

}
