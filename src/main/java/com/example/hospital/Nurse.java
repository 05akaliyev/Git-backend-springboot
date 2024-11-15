package com.example.hospital;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Nurse {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String user;
	private String password;

	// Constructor vacío (necesario para JPA)
	public Nurse() {
	}

	// Constructor para inicializar user y password
	public Nurse(String user, String password) {
		this.user = user;
		this.password = password;
	}

	// Constructor para inicializar id, user y password (para pruebas)
	public Nurse(int id, String user, String password) {
		this.id = id;
		this.user = user;
		this.password = password;
	}

	// Getters y setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
