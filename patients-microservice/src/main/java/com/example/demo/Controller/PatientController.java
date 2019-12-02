package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.Service.PatientService;
import com.example.demo.model.BaseResponse;
import com.example.demo.model.Patient;

@RestController
@RequestMapping("/api/patients")
public class PatientController {

	@Autowired
	private PatientService patientService;
	
	
	@GetMapping("")
	public List<Patient> getAllPatients(){
		return patientService.listAll();
	}
	
	@PostMapping("/save")
	public BaseResponse savePatient(@RequestBody Patient patient ) {
		if(patientService.savePatient(patient)) {
			return new BaseResponse("patient saved successfully",true);	
		}
		return new BaseResponse("this patient already exists",false);
	}
}
