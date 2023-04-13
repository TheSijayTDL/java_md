package model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Post {
	private String msg;
	private LocalDateTime dateTime;
	private int countOfLikes = 0; // TODO ArrayList to check if user likes only once
	
	public Post() {
		setMsg("Unknown");
		setDateTime();
	}
	
	public Post(String msg) {
		setMsg(msg);
		setDateTime();
	}
	
	public String getMsg() {
		return msg;
	}
	
	public LocalDateTime getDateTime() {
		return dateTime;
	}
	
	public int getCountOfLikes() {
		return countOfLikes;
	}
	
	public void setMsg(String msg) {
		if (msg != null && msg.length() > 3) {
			this.msg = msg;
		} else {
			this.msg = "Unknown";
		}
	}
	
	public void setDateTime() {
		this.dateTime = LocalDateTime.now();
	}
	
	public void increaseLikes() {
		countOfLikes++;
	}

	public String toString() {
		return dateTime.format(DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm:ss")) + " -> " + msg + " (" + countOfLikes + ")";
	}
	
	
}
