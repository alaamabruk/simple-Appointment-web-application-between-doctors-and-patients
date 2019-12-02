package com.example.demo.model.VM;

public class PatientRegisterVm {

	   // user attributes
		private String username;
		private String password;

		// patient attributes
		private String name;
		private String gender;
		private String phone;
		private int age;

		public String getUsername() {
			return username;
		}

		public void setUsername(String username) {
			this.username = username;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
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

		@Override
		public String toString() {
			return "PatientRegisterVm [username=" + username + ", password=" + password + ", name=" + name + ", gender="
					+ gender + ", phone=" + phone + ", age=" + age + "]";
		}
		
}
