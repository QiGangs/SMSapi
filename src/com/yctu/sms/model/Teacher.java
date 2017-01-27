package com.yctu.sms.model;

public class Teacher {
	private int user_id;
	private int custom_id;
	private String name;
	private String password;
	private String phone_number;
	private String email;
	private String user_group;
	private String college;
	private String speciality;
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public int getCustom_id() {
		return custom_id;
	}
	public void setCustom_id(int custom_id) {
		this.custom_id = custom_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPhone_number() {
		return phone_number;
	}
	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUser_group() {
		return user_group;
	}
	public void setUser_group(String user_group) {
		this.user_group = user_group;
	}
	public String getCollege() {
		return college;
	}
	public void setCollege(String college) {
		this.college = college;
	}
	public String getSpeciality() {
		return speciality;
	}
	public void setSpeciality(String speciality) {
		this.speciality = speciality;
	}
	@Override
	public String toString() {
		return "Teacher [user_id=" + user_id + ", custom_id=" + custom_id + ", name=" + name + ", password=" + password
				+ ", phone_number=" + phone_number + ", email=" + email + ", user_group=" + user_group + ", college="
				+ college + ", speciality=" + speciality + "]";
	}
	
	
	
}
