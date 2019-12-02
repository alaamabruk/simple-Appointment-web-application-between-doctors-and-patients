package com.example.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Repository.PatientRepository;
import com.example.demo.model.Patient;

@Service
public class PatientService {

	@Autowired
	private PatientRepository patientRepository;
	
	public List<Patient> listAll(){
		return (List<Patient>) patientRepository.findAll();
	}
	
	public Boolean savePatient(Patient patient) {
		Patient patient1=patientRepository.findByUserId(patient.getUserId()).orElse(null);
		if(patient1 == null) {
		patientRepository.save(patient);
		return true;
		}
		else 
			return false;
	}
}
