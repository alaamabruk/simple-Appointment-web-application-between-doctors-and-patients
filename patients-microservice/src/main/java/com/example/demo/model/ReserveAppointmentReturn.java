package com.example.demo.model;

public enum ReserveAppointmentReturn {

	PATIENT_NOT_FOUND("patient not found"),
	APPOINTMENT_NOT_AVAILABLE("appointment not available");
    
	
	private String message;

	private ReserveAppointmentReturn(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

}
