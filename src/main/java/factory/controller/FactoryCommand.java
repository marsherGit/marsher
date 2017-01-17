package factory.controller;

import org.springframework.web.multipart.MultipartFile;

public class FactoryCommand {
	private int fac_id;
	private String fac_name;
	private String fac_location;
	private String fac_tel;
	private String fac_product;
	private String fac_image;
	private MultipartFile fac_file; 
	
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
	public String getFac_location() {
		return fac_location;
	}
	public void setFac_location(String fac_location) {
		this.fac_location = fac_location;
	}
	public String getFac_tel() {
		return fac_tel;
	}
	public void setFac_tel(String fac_tel) {
		this.fac_tel = fac_tel;
	}
	public String getFac_product() {
		return fac_product;
	}
	public void setFac_product(String fac_product) {
		this.fac_product = fac_product;
	}
	public String getFac_image() {
		return fac_image;
	}
	public void setFac_image(String fac_image) {
		this.fac_image = fac_image;
	}
	
	public MultipartFile getFac_file() {
		return fac_file;
	}
	public void setFac_file(MultipartFile fac_file) {
		this.fac_file = fac_file;
	}
	
	@Override
	public String toString() {
		return "FactoryCommand [fac_id=" + fac_id + ", fac_name=" + fac_name + ", fac_location=" + fac_location
				+ ", fac_tel=" + fac_tel + ", fac_product=" + fac_product + ", fac_image=" + fac_image + "]";
	}
	
	
	
}
