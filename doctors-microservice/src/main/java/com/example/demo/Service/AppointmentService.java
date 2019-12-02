package com.example.demo.Service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.Repository.AppointmentRepository;
import com.example.demo.Repository.DoctorRepository;
import com.example.demo.model.Appointment;
import com.example.demo.model.Doctor;

@Service
public class AppointmentService {

	@Autowired
	private AppointmentRepository appointmentRepository;
	
	@Autowired
	private DoctorRepository doctorRepository;

	public List<Appointment> listAll() {
		return (List<Appointment>) this.appointmentRepository.findAll();
	}

	public List<Appointment> listAvaialableAppointements() {
		return appointmentRepository.findByAvailable(true);
	}

	public boolean isAvailable(long appointementId) {
		Appointment appointment = this.appointmentRepository.findByIdAndAvailable(appointementId, true).orElse(null);
		return (null != appointment);
	}

	public boolean markAsUnavialble(long appointmentId) {
		Appointment appointment = appointmentRepository.findById(appointmentId).orElse(null);
		if (null != appointment) {
			appointment.setAvailable(false);
			appointmentRepository.save(appointment);
			return true;
		}
		return false;
	}
	
	public boolean PutAppointment(Appointment appointment) {
	
		Doctor doctor = this.doctorRepository.findById(appointment.getDoctor().getId()).orElse(null);
		if(null !=doctor) {
	       Appointment appointment1 = this.appointmentRepository.findByFromHourAndDate(appointment.getFromHour(), appointment.getDate()).orElse(null);
	    		   if(appointment1 == null) {		
			appointmentRepository.save(appointment);
			return true;
		}
		
	}
		return false;
	}
	
}
