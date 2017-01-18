package chowonhee.DTO;

import java.util.Date;

public class inoutBoard {

	int inout_num;
	String inout_name;
	String inout_sender;
	String inout_receiver;
	String inout_note;
	Date inout_deadline;
	
	int total;
	
	public Date getInout_deadline() {
		return inout_deadline;
	}
	public void setInout_deadline(Date inout_deadline) {
		this.inout_deadline = inout_deadline;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public int getInout_num() {
		return inout_num;
	}
	public void setInout_num(int inout_num) {
		this.inout_num = inout_num;
	}
	public String getInout_name() {
		return inout_name;
	}
	public void setInout_name(String inout_name) {
		this.inout_name = inout_name;
	}
	public String getInout_sender() {
		return inout_sender;
	}
	public void setInout_sender(String inout_sender) {
		this.inout_sender = inout_sender;
	}
	public String getInout_receiver() {
		return inout_receiver;
	}
	public void setInout_receiver(String inout_receiver) {
		this.inout_receiver = inout_receiver;
	}
	public String getInout_note() {
		return inout_note;
	}
	public void setInout_note(String inout_note) {
		this.inout_note = inout_note;
	}
	
	
}
