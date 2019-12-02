package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.demo.Constants.Constants;
import com.example.demo.Service.UserService;
import com.example.demo.model.BaseResponse;
import com.example.demo.model.LoginResponse;
import com.example.demo.model.User;
import com.example.demo.model.VM.DoctorRegisterVm;
import com.example.demo.model.VM.DoctorVm;
import com.example.demo.model.VM.LoginVm;
import com.example.demo.model.VM.PatientRegisterVm;
import com.example.demo.model.VM.PatientVm;

@RestController
@RequestMapping("/api/users")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private RestTemplate restTemplate;

	@GetMapping("")
	public List<User> listAll() {
		return userService.listAll();
	}

	@PostMapping("/register-doctor")
	public BaseResponse registerDoctor(@RequestBody DoctorRegisterVm doctorRegisterVm) {
		User savedUser = userService.saveDoctor(doctorRegisterVm);

		if (savedUser == null) {
			return new BaseResponse("this username already exist", false);
		}
		DoctorVm doctorVm = new DoctorVm(doctorRegisterVm);
		doctorVm.setUserId(savedUser.getId());
		BaseResponse response =restTemplate.postForEntity(Constants.DOCTORS_SAVE_DOCTOR_URL, doctorVm, BaseResponse.class).getBody();

		if (response.isSuccess()) {
			return new BaseResponse("Doctor registerd successfully", true);
		}
		return new BaseResponse("some error happend, Please try later", false);
	}

	@PostMapping("/register-patient")
	public BaseResponse registerPatient(@RequestBody PatientRegisterVm patientRegisterVm) {

		User savedUser = userService.savePatient(patientRegisterVm);
		if (savedUser == null) {
			return new BaseResponse("this username already exist", false);
		}

		PatientVm patientVm = new PatientVm(patientRegisterVm);
		patientVm.setUserId(savedUser.getId());
		BaseResponse response = restTemplate.postForEntity(Constants.PATIENTS_SAVE_PATIENT_URL, patientVm, BaseResponse.class).getBody();

		if (response.isSuccess()) {
			return new BaseResponse("Patient registerd successfully", true);
		}
		return new BaseResponse("some error happend, Please try later", false);
	}


	@PostMapping("/is-authenticate")
	public BaseResponse isAuthenticatedUser(@RequestBody LoginVm loginVm) {
		User loggedUser = userService.isAuthenticated(loginVm);
		LoginResponse loginResponse = new LoginResponse();
		if (loggedUser != null) {
			loginResponse.setMessage("user is authenticated");
			loginResponse.setSuccess(true);
			loginResponse.setType(loggedUser.getType());
		} else {
			loginResponse.setMessage("username or password is invalid");
			loginResponse.setSuccess(false);
			loginResponse.setType(Constants.NOT_AVAILABLE);
		}
		return loginResponse;
	}

}