package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.example.demo.model.VM.DoctorRegisterVm;
import com.example.demo.model.VM.PatientRegisterVm;

@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String username;
	private String password;
	private String type;

	public User() {

	}

	public User(DoctorRegisterVm registerVm) {
		this.username = registerVm.getUsername();
		this.password = registerVm.getPassword();
		this.setType(UserType.DOCTOR.getType());
	}

	public User(PatientRegisterVm registerVm) {
		this.username = registerVm.getUsername();
		this.password = registerVm.getPassword();
		this.setType(UserType.PATIENT.getType());
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
}
