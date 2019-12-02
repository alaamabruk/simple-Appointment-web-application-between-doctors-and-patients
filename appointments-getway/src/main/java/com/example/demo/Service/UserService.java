package com.example.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Repository.UserRepository;
import com.example.demo.model.User;
import com.example.demo.model.VM.DoctorRegisterVm;
import com.example.demo.model.VM.LoginVm;
import com.example.demo.model.VM.PatientRegisterVm;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public List<User> listAll() {
		return (List<User>) this.userRepository.findAll();
	}

	public User saveDoctor(DoctorRegisterVm doctorRegisterVm) {
		User existedUser = userRepository.findByUsername(doctorRegisterVm.getUsername()).orElse(null);

		if (existedUser == null) {
			User user = new User(doctorRegisterVm);
			this.userRepository.save(user);
			return user;
		}
		return null;
	}

	public User savePatient(PatientRegisterVm patientRegisterVm) {
		User existedUser = userRepository.findByUsername(patientRegisterVm.getUsername()).orElse(null);

		if (existedUser == null) {
			User user = new User(patientRegisterVm);
			this.userRepository.save(user);
			return user;
		}
		return null;
	}

	public User isAuthenticated(LoginVm loginVm) {
		return userRepository.findByUsernameAndPassword(loginVm.getUsername(),loginVm.getPassword()).orElse(null);
	}
}
