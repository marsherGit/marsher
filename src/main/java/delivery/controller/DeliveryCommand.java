package delivery.controller;

public class DeliveryCommand {
	private int delivery_num;
	private String delivery_name;
	private String delivery_tel;
	private String delivery_img;
	private String delivery_day;
	private String fac_id;
	
	public int getDelivery_num() {
		return delivery_num;
	}
	public void setDelivery_num(int delivery_num) {
		this.delivery_num = delivery_num;
	}
	public String getDelivery_name() {
		return delivery_name;
	}
	public void setDelivery_name(String delivery_name) {
		this.delivery_name = delivery_name;
	}
	public String getDelivery_tel() {
		return delivery_tel;
	}
	public void setDelivery_tel(String delivery_tel) {
		this.delivery_tel = delivery_tel;
	}
	public String getDelivery_img() {
		return delivery_img;
	}
	public void setDelivery_img(String delivery_img) {
		this.delivery_img = delivery_img;
	}
	public String getDelivery_day() {
		return delivery_day;
	}
	public void setDelivery_day(String delivery_day) {
		this.delivery_day = delivery_day;
	}
	public String getFac_id() {
		return fac_id;
	}
	public void setFac_id(String fac_id) {
		this.fac_id = fac_id;
	}
	
	@Override
	public String toString() {
		return "DeliveryCommand [delivery_num=" + delivery_num + ", delivery_name=" + delivery_name + ", delivery_tel="
				+ delivery_tel + ", delivery_img=" + delivery_img + ", delivery_day=" + delivery_day + ", fac_id="
				+ fac_id + "]";
	}
	
}
