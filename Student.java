package org.pasha.DemoApp;

public class Student {
	private  String name,username,email,sex,city,country,pw;
	public void setPassword(String Password) {
		this.pw=Password;
	}	
	public String getPassword() {
			return pw;
		}
		public String getName() {
			return name;	
		}
		public void setName(String name) {
			this.name=name;
		}
		public String getUsername() {
			return username;
		}
		public void setUsername(String username) {
			this.username=username;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email=email;
		}
		public void setGender(String Gender) {
			this.sex=Gender;
		}
		public String getGender() {
			return sex;
		}
		public String getCity() {
			return city;
		}
		public void setCity(String city) {
			this.city=city;
		}
		public String getCountry() {
			return country;
		}
		public void setCountry(String country) {
			this.country=country;
		}
}
