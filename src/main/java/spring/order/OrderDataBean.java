package spring.order;

import java.util.Date;

public class OrderDataBean {
	private int o_ref;
	private String o_title;
	private Date o_deadline;
	private Date o_regdate;
	private Date o_sendDate;
	private String o_receiver;
	private String o_sender;
	private String o_note;
	private String senderSign;
	private String receiverSign;
	private String deliveryState;

	
	public int getO_ref() {
		return o_ref;
	}
	public void setO_ref(int o_ref) {
		this.o_ref = o_ref;
	}
	public String getDeliveryState() {
		return deliveryState;
	}
	public void setDeliveryState(String deliveryState) {
		this.deliveryState = deliveryState;
	}
	public String getO_note() {
		return o_note;
	}
	public void setO_note(String o_note) {
		this.o_note = o_note;
	}
	
	
	public String getO_title() {
		return o_title;
	}
	public void setO_title(String o_title) {
		this.o_title = o_title;
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
	
	@Override
	public String toString() {
		return "OrderDataBean [o_ref=" + o_ref + ", o_title=" + o_title + ", o_deadline=" + o_deadline + ", o_regdate="
				+ o_regdate + ", o_sendDate=" + o_sendDate + ", o_receiver=" + o_receiver + ", o_sender=" + o_sender
				+ ", o_note=" + o_note + ", senderSign=" + senderSign + ", receiverSign=" + receiverSign
				+ ", deliveryState=" + deliveryState + "]";
	}
	
	

}
