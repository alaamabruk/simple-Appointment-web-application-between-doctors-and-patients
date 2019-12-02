package com.example.demo.Repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Patient;

@Repository
public interface PatientRepository extends CrudRepository<Patient, Long>{
	
	Optional<Patient> findByUserId(Long UserId);

}
