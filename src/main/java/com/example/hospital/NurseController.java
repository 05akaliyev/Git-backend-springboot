package com.example.hospital;

import java.util.ArrayList;
import java.util.Scanner;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NurseController {
	 private ArrayList<Nurse> nurses;
	 //ArrayList

	    // Constructor to initialize the list of nurses with data
	    public NurseController() {
	        nurses = new ArrayList<>();
	        nurses.add(new Nurse("Alberto", "password1"));
	        nurses.add(new Nurse("Maria", "password2"));
	        nurses.add(new Nurse("Juan", "password3"));
	    }

	    // Endpoint login 
	    @PostMapping("/login")
	    public ResponseEntity <Boolean> login(@RequestParam String user, @RequestParam String password) {
	        for (Nurse nurse : nurses) { 
	            if (nurse.user().equals(user) && nurse.password().equals(password)) {
	                return ResponseEntity.ok(true); // Return HTTP 200 (OK)
	            }
	        }
	        // Return HTTP 401 (Error)
	        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(false); 

	    }
	    
	    //Endpoint find user per name
		@GetMapping("/findName/{name}")
		public ResponseEntity<Nurse>findByName(@PathVariable String name){
			
			for(Nurse nurse : nurses) {
				if(name.equalsIgnoreCase(nurse.user())) {
					System.out.println(nurse);
					return ResponseEntity.ok(nurse);
				}		
			}
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    
	    
}
	    // Endpoint getAll 
	    @GetMapping("/index")
	    public ResponseEntity<ArrayList<Nurse>> getAll() {
 
	        // Return HTTP 200 (OK) and the ArrayList of Nurses
	        return ResponseEntity.ok(nurses);

	    }
}
