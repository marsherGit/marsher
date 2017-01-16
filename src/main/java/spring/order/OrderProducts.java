package spring.order;

public class OrderProducts {
	private int o_ref;
	private int o_reStep;
	private String pro_name;
	private String pro_container;
	private int pro_volume;
	private int pro_count;

	public int getO_ref() {
		return o_ref;
	}
	public void setO_ref(int o_ref) {
		this.o_ref = o_ref;
	}
	public int getO_reStep() {
		return o_reStep;
	}
	public void setO_reStep(int o_reStep) {
		this.o_reStep = o_reStep;
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
	@Override
	public String toString() {
		return "OrderProducts [o_ref=" + o_ref + ", o_reStep=" + o_reStep + ", pro_name=" + pro_name
				+ ", pro_container=" + pro_container + ", pro_volume=" + pro_volume + ", pro_count=" + pro_count + "]";
	}
	
	

}
