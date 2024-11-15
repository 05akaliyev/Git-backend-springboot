// NurseRepository.java
package com.example.hospital;

import org.springframework.data.repository.CrudRepository;

public interface NurseRepository extends CrudRepository<Nurse, Integer> {
	Nurse findByUser(String user);
}
