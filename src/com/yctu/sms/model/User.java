package com.yctu.sms.model;

public class User {
	@Override
	public String toString() {
		return "User [custom_id=" + custom_id + ", name=" + name + ", college=" + college + ", department=" + department
				+ ", classes=" + classes + ", year=" + year + ", sex=" + sex + ", nation=" + nation + ", tel=" + tel
				+ ", qq=" + qq + ", mail=" + mail + ", ID_card=" + ID_card + ", address=" + address + ", parent_tel="
				+ parent_tel + ", economy=" + economy + ", dorm=" + dorm + ", scholarship=" + scholarship
				+ ", punishment=" + punishment + ", CET=" + CET + ", NCRE=" + NCRE + ", ruankao=" + ruankao
				+ ", kaoyan=" + kaoyan + ", cadre=" + cadre + ", polity=" + polity + "]";
	}
	private int custom_id;
	private String name;
	private String college;
	private String department;
	private String classes;
	private int year;
	private String sex;
	private String nation;
	private String tel;
	private String qq;
	private String mail;
	private String ID_card;
	private String address;
	private String parent_tel;
	private String economy;
	private String dorm;
	private String scholarship;
	private String punishment;
	private String CET;
	private String NCRE;
	private String ruankao;
	private String kaoyan;
	private String cadre;
	private String polity;
	private String teacher;
	public String getTeacher() {
		return teacher;
	}
	public void setTeacher(String teacher) {
		this.teacher = teacher;
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
	public String getCollege() {
		return college;
	}
	public void setCollege(String college) {
		this.college = college;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getClasses() {
		return classes;
	}
	public void setClasses(String classes) {
		this.classes = classes;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getNation() {
		return nation;
	}
	public void setNation(String nation) {
		this.nation = nation;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getQq() {
		return qq;
	}
	public void setQq(String qq) {
		this.qq = qq;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getID_card() {
		return ID_card;
	}
	public void setID_card(String iD_card) {
		ID_card = iD_card;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getParent_tel() {
		return parent_tel;
	}
	public void setParent_tel(String parent_tel) {
		this.parent_tel = parent_tel;
	}
	public String getEconomy() {
		return economy;
	}
	public void setEconomy(String economy) {
		this.economy = economy;
	}
	public String getDorm() {
		return dorm;
	}
	public void setDorm(String dorm) {
		this.dorm = dorm;
	}
	public String getScholarship() {
		return scholarship;
	}
	public void setScholarship(String scholarship) {
		this.scholarship = scholarship;
	}
	public String getPunishment() {
		return punishment;
	}
	public void setPunishment(String punishment) {
		this.punishment = punishment;
	}
	public String getCET() {
		return CET;
	}
	public void setCET(String cET) {
		CET = cET;
	}
	public String getNCRE() {
		return NCRE;
	}
	public void setNCRE(String nCRE) {
		NCRE = nCRE;
	}
	public String getRuankao() {
		return ruankao;
	}
	public void setRuankao(String ruankao) {
		this.ruankao = ruankao;
	}
	public String getKaoyan() {
		return kaoyan;
	}
	public void setKaoyan(String kaoyan) {
		this.kaoyan = kaoyan;
	}
	public String getCadre() {
		return cadre;
	}
	public void setCadre(String cadre) {
		this.cadre = cadre;
	}
	public String getPolity() {
		return polity;
	}
	public void setPolity(String polity) {
		this.polity = polity;
	}
	
}
