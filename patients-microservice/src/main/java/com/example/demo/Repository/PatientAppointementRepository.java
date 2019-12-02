package com.example.demo.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.PatientAppointment;

@Repository
public interface PatientAppointementRepository extends CrudRepository<PatientAppointment, Long>{

	
}
