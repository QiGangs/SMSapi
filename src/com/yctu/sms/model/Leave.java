package com.yctu.sms.model;

public class Leave {
	private String reason;
	private String start_time;
	private String end_time;
	private String back_time;
	private String approver;
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public String getStart_time() {
		return start_time;
	}
	public void setStart_time(String start_time) {
		this.start_time = start_time;
	}
	public String getEnd_time() {
		return end_time;
	}
	public void setEnd_time(String end_time) {
		this.end_time = end_time;
	}
	public String getBack_time() {
		return back_time;
	}
	public void setBack_time(String back_time) {
		this.back_time = back_time;
	}
	public String getApprover() {
		return approver;
	}
	public void setApprover(String approver) {
		this.approver = approver;
	}
	@Override
	public String toString() {
		return "Leave [reason=" + reason + ", start_time=" + start_time + ", end_time=" + end_time + ", back_time="
				+ back_time + ", approver=" + approver + "]";
	}
	
	
}
