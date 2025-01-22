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
    private int phone_number;
    private String first_name;
    private String last_name;

    // Constructor vacío (necesario para JPA)
    public Nurse() {}

    // Constructor para inicializar user y password
    public Nurse(String user, String password, int phone_number, String first_name, String last_name) {
        this.user = user;
        this.password = password;
        this.phone_number = phone_number;
        this.first_name = first_name;
        this.last_name = last_name;
    }

    // Constructor para inicializar id, user y password (para pruebas)
    public Nurse(int id, String user, String password, int phone_number, String first_name, String last_name) {
        this.id = id;
        this.user = user;
        this.password = password;
        this.phone_number = phone_number;
        this.first_name = first_name;
        this.last_name = last_name;
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

	public int getPhone_number() {
		return phone_number;
	}

	public void setPhone_number(int phone_number) {
		this.phone_number = phone_number;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
    
    
}
