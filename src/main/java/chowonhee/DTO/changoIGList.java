package chowonhee.DTO;

public class changoIGList {
	
	String pro_num;/* 제품번호 */
	String pro_name;/* 제품명 */
	String pro_container; /* 용기 */
	int pro_volume; /* 용량 */
	int pro_count; /* 제품수량 */

	String inout_receiver; /* 입고장소*/
	
	public String getPro_num() {
		return pro_num;
	}
	public void setPro_num(String pro_num) {
		this.pro_num = pro_num;
	}
	public String getPro_name() {
		return pro_name;
	}
	public void setPro_name(String pro_name) {
		this.pro_name = pro_name;
	}
	public String getPro_container() {
		return pro_container;
	}
	public void setPro_container(String pro_container) {
		this.pro_container = pro_container;
	}
	public int getPro_volume() {
		return pro_volume;
	}
	public void setPro_volume(int pro_volume) {
		this.pro_volume = pro_volume;
	}
	public int getPro_count() {
		return pro_count;
	}
	public void setPro_count(int pro_count) {
		this.pro_count = pro_count;
	}

	public String getInout_receiver() {
		return inout_receiver;
	}
	public void setInout_receiver(String inout_receiver) {
		this.inout_receiver = inout_receiver;
	}
	
	
}
