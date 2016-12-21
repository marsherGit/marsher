package mj.Store.service;

public class memberDataBean {
	
	private String st_id;
	private String passwd;
	private String st_name;
	private String st_tel;
	private String st_location;
	private String st_image;
	private String sign_img;
	
	
	public String getSt_id() {
		return st_id;
	}
	public void setSt_id(String st_id) {
		this.st_id = st_id;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	public String getSt_name() {
		return st_name;
	}
	public void setSt_name(String st_name) {
		this.st_name = st_name;
	}
	public String getSt_tel() {
		return st_tel;
	}
	public void setSt_tel(String st_tel) {
		this.st_tel = st_tel;
	}
	public String getSt_location() {
		return st_location;
	}
	public void setSt_location(String st_location) {
		this.st_location = st_location;
	}
	public String getSt_image() {
		return st_image;
	}
	public void setSt_image(String st_image) {
		this.st_image = st_image;
	}
	public String getSign_img() {
		return sign_img;
	}
	public void setSign_img(String sign_img) {
		this.sign_img = sign_img;
	}
	@Override
	public String toString() {
		return "memberDataBean [st_id=" + st_id + ", passwd=" + passwd + ", st_name=" + st_name + ", st_tel=" + st_tel
				+ ", st_location=" + st_location + ", st_image=" + st_image + ", sign_img=" + sign_img + "]";
	}
	
	
	
	

}


