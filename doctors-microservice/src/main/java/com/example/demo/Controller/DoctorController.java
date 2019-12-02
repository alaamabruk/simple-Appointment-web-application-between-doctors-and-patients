package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.Service.DoctorService;
import com.example.demo.model.BaseResponse;
import com.example.demo.model.Doctor;

@RestController
@RequestMapping("/api/doctors")
public class DoctorController {
	
	@Autowired
	private DoctorService doctorService;

	@GetMapping("")
	public List<Doctor> listAll() {
		return doctorService.listAll();
	}

	@PostMapping("/save")
	public BaseResponse saveDoctor(@RequestBody Doctor doctor) {
		
		doctorService.saveDoctor(doctor);
		return new BaseResponse("doctor saved successfuly", true);
	}

}
