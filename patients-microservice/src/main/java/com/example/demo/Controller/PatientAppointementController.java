package com.example.demo.Controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import com.example.demo.Constant.Constants;
import com.example.demo.Service.PatientAppointmentService;
import com.example.demo.model.BaseResponse;
import com.example.demo.model.PatientAppointment;

@RestController
@RequestMapping("/api/patient-appointements")
public class PatientAppointementController {
	
	@Autowired
	private PatientAppointmentService patientAppointmentService;
	
	@Autowired
	private RestTemplate restTemplate;

	@GetMapping("")
	public List<PatientAppointment> listAll() {
		return this.patientAppointmentService.findAll();
	}

	@PostMapping("/{patientId}/appointment/{appointementId}")
	public BaseResponse reserveAppointment(@PathVariable("patientId") long patientId,
			@PathVariable("appointementId") long appointementId) {

		Map<String, Long> uriVariables = new HashMap<>();
		uriVariables.put("appointmentId", appointementId);

		BaseResponse response = restTemplate.getForEntity(Constants.DOCTOR_IS_APPOINTMENT_AVAILABLE_URL, BaseResponse.class, uriVariables)
				.getBody();
		

		if (!response.isSuccess()) {
			return response;
		}

		String message = "appointment reserved successfully";
		boolean success = patientAppointmentService.reserveAppointment(patientId, appointementId);
		if (!success) {
			message = String.format("patient with id %s not exist", patientId);
		} else {
			restTemplate.postForEntity(Constants.DOCTOR_MARK_APPOINTMENT_UNAVAILABLE_URL, null, BaseResponse.class,
							uriVariables).getBody();
		}

		return new BaseResponse(message, success);
	}

}