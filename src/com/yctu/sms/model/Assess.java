package com.yctu.sms.model;

public class Assess {
	private String department;
	private String score;
	private int week;
	private String reason;
	private String time;
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getScore() {
		return score;
	}
	public void setScore(String score) {
		this.score = score;
	}
	public int getWeek() {
		return week;
	}
	public void setWeek(int week) {
		this.week = week;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	@Override
	public String toString() {
		return "Assess [department=" + department + ", score=" + score + ", week=" + week + ", reason=" + reason
				+ ", time=" + time + "]";
	}
	
	
}
