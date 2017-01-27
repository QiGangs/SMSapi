package com.yctu.sms.model;

public class Notice {
	private int id;
	
	private String title;
	private String content;
	private String author;
	private String time;
	private int authorid;
	private long timenum;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public int getAuthorid() {
		return authorid;
	}
	public void setAuthorid(int authorid) {
		this.authorid = authorid;
	}
	public long getTimenum() {
		return timenum;
	}
	public void setTimenum(long timenum) {
		this.timenum = timenum;
	}
	@Override
	public String toString() {
		return "Notice [title=" + title + ", content=" + content + ", author=" + author + ", time=" + time
				+ ", authorid=" + authorid + ", timenum=" + timenum + "]";
	}
	
}
