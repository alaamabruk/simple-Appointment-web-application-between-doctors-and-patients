package com.example.demo.model.VM;

public class PatientVm {

	private String name;
	private String gender;
	private String phone;
	private int age;

	private long userId;

	public PatientVm(PatientRegisterVm registerVm) {
		this.name = registerVm.getName();
		this.gender = registerVm.getGender();
		this.phone = registerVm.getPhone();
		this.age = registerVm.getAge();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}
}
