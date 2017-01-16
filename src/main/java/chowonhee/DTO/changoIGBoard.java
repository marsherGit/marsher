package chowonhee.DTO;

import java.util.Date;

public class changoIGBoard {
	int inout_num;/* 입출고번호 */
	String inout_name;/* 제목 */
	String inout_sender;/* 출고장소 */
	String inout_receiver; /* 입고장소 */
	Date inout_deadline;/* 입고날짜 */
	//게시글
	String pro_num;/* 제품번호 */
	int pro_count;/* 제품수량 */
	String inout_note; /* 비고 */
	
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
	public Date getInout_deadline() {
		return inout_deadline;
	}
	public void setInout_deadline(Date inout_deadline) {
		this.inout_deadline = inout_deadline;
	}
	public String getPro_num() {
		return pro_num;
	}
	public void setPro_num(String pro_num) {
		this.pro_num = pro_num;
	}
	public int getPro_count() {
		return pro_count;
	}
	public void setPro_count(int pro_count) {
		this.pro_count = pro_count;
	}
	@Override
	public String toString() {
		return "changoIGBoard [inout_num=" + inout_num + ", inout_name=" + inout_name + ", inout_sender=" + inout_sender
				+ ", inout_receiver=" + inout_receiver + ", inout_deadline=" + inout_deadline + ", pro_num=" + pro_num
				+ ", pro_count=" + pro_count + ", inout_note=" + inout_note + "]";
	}
	
	
	
}
