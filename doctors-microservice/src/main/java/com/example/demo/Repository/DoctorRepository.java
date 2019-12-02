package com.example.demo.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.model.Doctor;

@Repository
public interface DoctorRepository extends CrudRepository<Doctor, Long> {

}
