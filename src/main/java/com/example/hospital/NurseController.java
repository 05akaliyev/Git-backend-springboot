// NurseController.java
package com.example.hospital;

import java.util.ArrayList;
import java.util.Optional;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/nurses") // Common prefix /nurses
public class NurseController {
	private ArrayList<Nurse> nurses;
	// ArrayList
	@Autowired
	private NurseRepository nurseRepository;

	// Comment to test Pipeline CI
	// Endpoint login
	@PostMapping("/login")
	public ResponseEntity<Boolean> login(@RequestParam String user, @RequestParam String password) {
		Nurse nurse = nurseRepository.findByUser(user);
		if (nurse != null && nurse.getPassword().equals(password)) {
			return ResponseEntity.ok(true); // Return HTTP 200 (OK)
		}
		return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(false); // Return HTTP 401 (Unauthorized)
	}

	@GetMapping("/name/{name}")
	public ResponseEntity<Nurse> findByName(@PathVariable String name) {
		Nurse nurse = nurseRepository.findByUser(name);
		if (nurse != null) {
			return ResponseEntity.ok(nurse);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND); // Return HTTP 404 (Not Found)
	}

	// Endpoint getAll
	@GetMapping("/index")
	public ResponseEntity<Iterable<Nurse>> getAll() {

		Iterable<Nurse> nurses = nurseRepository.findAll();

		// Return HTTP 200 (OK) and the ArrayList of Nurses
		return ResponseEntity.ok(nurses);
	}

	// Endpoint FindById
	@GetMapping("/{id}")
	public ResponseEntity<Nurse> findById(@PathVariable int id) {
		Optional<Nurse> nurse = nurseRepository.findById(id);
		if (nurse.isPresent()) {
			return ResponseEntity.ok(nurse.get());
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}

	// Endpoint Create Nurse
	@PostMapping("/")
	public ResponseEntity<Nurse> addNurse(@RequestParam String user, @RequestParam String password) {
		if (user == null || user.isEmpty() || password == null || password.isEmpty()) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
		Nurse nurse = new Nurse();
		nurse.setUser(user);
		nurse.setPassword(password);
		Nurse newNurse = nurseRepository.save(nurse);

		return ResponseEntity.status(HttpStatus.CREATED).body(newNurse);

	}

	// Endpoint Update Nurse
	@PutMapping("/{id}")
	public ResponseEntity<Nurse> updateNurseById(@PathVariable int id, @RequestParam(required = false) String user,
			@RequestParam(required = false) String password) {

		if ((user != null && user.isEmpty()) || (password != null && password.isEmpty())) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}

		Optional<Nurse> nurseOptional = nurseRepository.findById(id);
		if (nurseOptional.isPresent()) {
			Nurse existingNurse = nurseOptional.get();
			if (user != null && !user.isEmpty()) {
				existingNurse.setUser(user);
			}
			if (password != null && !password.isEmpty()) {
				existingNurse.setPassword(password);
			}
			Nurse updatedNurse = nurseRepository.save(existingNurse);
			return ResponseEntity.ok(updatedNurse);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	// Endpoint Delete Nurse
	@DeleteMapping("/{id}")
	public ResponseEntity<Nurse> deleteNurseById(@PathVariable int id) {
		Optional<Nurse> nurseOptional = nurseRepository.findById(id);
		if (nurseOptional.isPresent()) {
			
			nurseRepository.delete(deletedNurse);
			return ResponseEntity.ok(deletedNurse);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

}
