package com.example.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Repository.DoctorRepository;
import com.example.demo.model.Doctor;

@Service
public class DoctorService {

	@Autowired
	private DoctorRepository doctorRepository;
	
	
	public List<Doctor> listAll(){
		return (List<Doctor>) this.doctorRepository.findAll();
	}
	
	public Doctor saveDoctor(Doctor doctor) {
		return doctorRepository.save(doctor);
	}
}
