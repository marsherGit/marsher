package delivery.controller;

public class DeliveryInfo {
	private int delivery_num;
	private String delivery_name;
	private String delivery_tel;
	private String delivery_img;
	private int fac_id;
	private String fac_name;
	private String fac_product;
	private String delivery_day;
	
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
	public int getFac_id() {
		return fac_id;
	}
	public void setFac_id(int fac_id) {
		this.fac_id = fac_id;
	}
	public String getFac_name() {
		return fac_name;
	}
	public void setFac_name(String fac_name) {
		this.fac_name = fac_name;
	}
	public String getFac_product() {
		return fac_product;
	}
	public void setFac_product(String fac_product) {
		this.fac_product = fac_product;
	}
	public String getDelivery_day() {
		return delivery_day;
	}
	public void setDelivery_day(String delivery_day) {
		this.delivery_day = delivery_day;
	}
	
	@Override
	public String toString() {
		return "DeliveryInfo [delivery_num=" + delivery_num + ", delivery_name=" + delivery_name + ", delivery_tel="
				+ delivery_tel + ", delivery_img=" + delivery_img + ", fac_id=" + fac_id + ", fac_name=" + fac_name
				+ ", fac_product=" + fac_product + ", delivery_day=" + delivery_day + "]";
	}
	
	
}
