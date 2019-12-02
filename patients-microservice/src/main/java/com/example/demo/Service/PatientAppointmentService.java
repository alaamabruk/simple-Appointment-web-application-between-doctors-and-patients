package com.example.demo.Service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.Repository.PatientAppointementRepository;
import com.example.demo.Repository.PatientRepository;
import com.example.demo.model.Patient;
import com.example.demo.model.PatientAppointment;

@Service
public class PatientAppointmentService {

	@Autowired
	private PatientAppointementRepository patientAppointementRepository;

	@Autowired
	private PatientRepository patientRepository;

	public List<PatientAppointment> findAll() {
		return (List<PatientAppointment>) patientAppointementRepository.findAll();
	}

	public boolean reserveAppointment(long patientId, long appointementId) {
		Patient patient = patientRepository.findById(patientId).orElse(null);
		if (null == patient) {
			return false;
		}
		PatientAppointment patientAppointment = new PatientAppointment();
		patientAppointment.setAppointmentId(appointementId);
		patientAppointment.setPatient(patient);
		patientAppointementRepository.save(patientAppointment);
		return true;
	}

}