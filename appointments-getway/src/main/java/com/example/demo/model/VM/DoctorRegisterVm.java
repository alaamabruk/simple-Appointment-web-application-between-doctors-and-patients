package com.example.demo.model.VM;

public class DoctorRegisterVm {

	   // user attributes
		private String username;
		private String password;

		// doctor attributes
		private String name;
		private String phone;
		private String address;
		private String specialist;
		private String gender;

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

		@Override
		public String toString() {
			return "DoctorRegisterVm [username=" + username + ", password=" + password + ", name=" + name + ", phone="
					+ phone + ", address=" + address + ", specialist=" + specialist + ", gender=" + gender + "]";
		}
		
}
