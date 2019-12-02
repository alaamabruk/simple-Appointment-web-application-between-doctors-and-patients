package com.example.demo.model.VM;

public class DoctorVm {

	private String name;
	private String phone;
	private String address;
	private String specialist;
	private String gender;

	private long userId;

	public DoctorVm() {

	}

	public DoctorVm(DoctorRegisterVm registerVm) {
		this.name = registerVm.getName();
		this.phone = registerVm.getPhone();
		this.address = registerVm.getAddress();
		this.specialist = registerVm.getSpecialist();
		this.gender = registerVm.getGender();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getSpecialist() {
		return specialist;
	}

	public void setSpecialist(String specialist) {
		this.specialist = specialist;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}
}
