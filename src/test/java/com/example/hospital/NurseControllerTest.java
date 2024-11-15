package com.example.hospital;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

@WebMvcTest(NurseController.class) // Solo carga el controlador para las pruebas
@ExtendWith(MockitoExtension.class)
public class NurseControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private NurseRepository nurseRepository; // Mock del repositorio

	private Nurse nurse;

	@BeforeEach
	public void setUp() {
		nurse = new Nurse();
		nurse.setUser("john");
		nurse.setPassword("password123");
	}

	@Test
	public void testLoginSuccess() throws Exception {
		// Datos de prueba
		String user = "john";
		String password = "password123";

		// Mock del repositorio
		when(nurseRepository.findByUser(user)).thenReturn(nurse);

		// Realiza la petición POST
		mockMvc.perform(post("/nurses/login").param("user", user).param("password", password))
				.andExpect(status().isOk()) // Código HTTP 200
				.andExpect(content().string("true"));
	}

	@Test
	public void testLoginUnauthorized() throws Exception {
		// Datos de prueba
		String user = "john";
		String password = "wrongpassword";

		// Mock del repositorio
		when(nurseRepository.findByUser(user)).thenReturn(nurse);

		// Realiza la petición POST con contraseña incorrecta
		mockMvc.perform(post("/nurses/login").param("user", user).param("password", password))
				.andExpect(status().isUnauthorized()) // Código HTTP 401
				.andExpect(content().string("false"));
	}

	@Test
	public void testFindByNameSuccess() throws Exception {
		// Datos de prueba
		String name = "john";

		// Mock del repositorio
		when(nurseRepository.findByUser(name)).thenReturn(nurse);

		// Realiza la petición GET
		mockMvc.perform(get("/nurses/name/{name}", name)).andExpect(status().isOk()) // Código HTTP 200
				.andExpect(jsonPath("$.user").value("john")).andExpect(jsonPath("$.password").value("password123"));
	}

	@Test
	public void testFindByNameNotFound() throws Exception {
		// Datos de prueba
		String name = "john";

		// Mock del repositorio
		when(nurseRepository.findByUser(name)).thenReturn(null);

		// Realiza la petición GET para un usuario que no existe
		mockMvc.perform(get("/nurses/name/{name}", name)).andExpect(status().isNotFound()); // Código HTTP 404
	}

	@Test
	public void testGetAll() throws Exception {
		// Datos de prueba
		Nurse nurse1 = new Nurse();
		nurse1.setUser("john");
		nurse1.setPassword("password123");

		Nurse nurse2 = new Nurse();
		nurse2.setUser("jane");
		nurse2.setPassword("password456");

		// Mock del repositorio
		when(nurseRepository.findAll()).thenReturn(List.of(nurse1, nurse2));

		// Realiza la petición GET
		mockMvc.perform(get("/nurses/index")).andExpect(status().isOk()) // Código HTTP 200
				.andExpect(jsonPath("$[0].user").value("john")).andExpect(jsonPath("$[1].user").value("jane"));
	}

	@Test
	public void testAddNurse() throws Exception {
		// Datos de prueba
		String user = "john";
		String password = "password123";
		Nurse newNurse = new Nurse();
		newNurse.setUser(user);
		newNurse.setPassword(password);

		// Mock del repositorio
		when(nurseRepository.save(any(Nurse.class))).thenReturn(newNurse);

		// Realiza la petición POST
		mockMvc.perform(post("/nurses/").param("user", user).param("password", password))
				.andExpect(status().isCreated()) // Código HTTP 201
				.andExpect(jsonPath("$.user").value(user)).andExpect(jsonPath("$.password").value(password));
	}

	@Test
	public void testUpdateNurse() throws Exception {
		// Datos de prueba
		int id = 1;
		String user = "john";
		String password = "newpassword123";

		Nurse updatedNurse = new Nurse();
		updatedNurse.setId(id);
		updatedNurse.setUser(user);
		updatedNurse.setPassword(password);

		// Mock del repositorio
		when(nurseRepository.findById(id)).thenReturn(Optional.of(updatedNurse));
		when(nurseRepository.save(any(Nurse.class))).thenReturn(updatedNurse);

		// Realiza la petición PUT
		mockMvc.perform(put("/nurses/{id}", id).param("user", user).param("password", password))
				.andExpect(status().isOk()) // Código HTTP 200
				.andExpect(jsonPath("$.user").value(user)).andExpect(jsonPath("$.password").value(password));
	}

	@Test
	public void testDeleteNurse() throws Exception {
		// Datos de prueba
		int id = 1;
		Nurse nurseToDelete = new Nurse();
		nurseToDelete.setId(id);
		nurseToDelete.setUser("john");
		nurseToDelete.setPassword("password123");

		// Mock del repositorio
		when(nurseRepository.findById(id)).thenReturn(Optional.of(nurseToDelete));

		// Realiza la petición DELETE
		mockMvc.perform(delete("/nurses/{id}", id)).andExpect(status().isOk()) // Código HTTP 200
				.andExpect(jsonPath("$.user").value("john"));
	}
}
