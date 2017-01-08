package mj.Notice.controller;

import java.sql.Timestamp;

public class NoticeDataBean {
	
	private int no_num;
	private String no_title;
	private String no_content;
	private String calendar_date;
	private Timestamp no_date;
	
	public int getNo_num() {
		return no_num;
	}
	public void setNo_num(int no_num) {
		this.no_num = no_num;
	}
	public String getNo_title() {
		return no_title;
	}
	public void setNo_title(String no_title) {
		this.no_title = no_title;
	}
	public String getNo_content() {
		return no_content;
	}
	public void setNo_content(String no_content) {
		this.no_content = no_content;
	}
	public String getCalendar_date() {
		return calendar_date;
	}
	public void setCalendar_date(String calendar_date) {
		this.calendar_date = calendar_date;
	}
	public Timestamp getNo_date() {
		return no_date;
	}
	public void setNo_date(Timestamp no_date) {
		this.no_date = no_date;
	}
	@Override
	public String toString() {
		return "NoticeDataBean [no_num=" + no_num + ", no_title=" + no_title + ", no_content=" + no_content
				+ ", calendar_date=" + calendar_date + ", no_date=" + no_date + "]";
	}
	
	

}
