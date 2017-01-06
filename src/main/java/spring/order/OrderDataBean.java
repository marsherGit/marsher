package spring.order;

import java.util.Date;

public class OrderDataBean {
	private int o_num;
	private String o_title;
	private String pro_num;
	private int o_count;
	private Date o_deadline;
	private Date o_regdate;
	private Date o_sendDate;
	private String deliverystate;
	private String o_receiver;
	private String o_sender;
	private String senderSign;
	private String receiverSign;
	public int getO_num() {
		return o_num;
	}
	public void setO_num(int o_num) {
		this.o_num = o_num;
	}
	public String getO_title() {
		return o_title;
	}
	public void setO_title(String o_title) {
		this.o_title = o_title;
	}
	public String getPro_num() {
		return pro_num;
	}
	public void setPro_num(String pro_num) {
		this.pro_num = pro_num;
	}
	public int getO_count() {
		return o_count;
	}
	public void setO_count(int o_count) {
		this.o_count = o_count;
	}
	public Date getO_deadline() {
		return o_deadline;
	}
	public void setO_deadline(Date o_deadline) {
		this.o_deadline = o_deadline;
	}
	public Date getO_regdate() {
		return o_regdate;
	}
	public void setO_regdate(Date o_regdate) {
		this.o_regdate = o_regdate;
	}
	public Date getO_sendDate() {
		return o_sendDate;
	}
	public void setO_sendDate(Date o_sendDate) {
		this.o_sendDate = o_sendDate;
	}
	public String getO_receiver() {
		return o_receiver;
	}
	public void setO_receiver(String o_receiver) {
		this.o_receiver = o_receiver;
	}
	public String getO_sender() {
		return o_sender;
	}
	public void setO_sender(String o_sender) {
		this.o_sender = o_sender;
	}
	public String getSenderSign() {
		return senderSign;
	}
	public void setSenderSign(String senderSign) {
		this.senderSign = senderSign;
	}
	public String getReceiverSign() {
		return receiverSign;
	}
	public void setReceiverSign(String receiverSign) {
		this.receiverSign = receiverSign;
	}
	public String getDeliverystate() {
		return deliverystate;
	}
	public void setDeliverystate(String deliverystate) {
		this.deliverystate = deliverystate;
	}
	
	

}
