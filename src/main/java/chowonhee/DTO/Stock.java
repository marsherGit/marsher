package chowonhee.DTO;

public class Stock {

	String st_id;/* 아이디 */
	String pro_num;/* 제품번호 */
	int pro_stockAmount;/* 재고수량 */
	String pro_remark;/* 비고 */
	
	public String getSt_id() {
		return st_id;
	}
	public void setSt_id(String st_id) {
		this.st_id = st_id;
	}
	public String getPro_num() {
		return pro_num;
	}
	public void setPro_num(String pro_num) {
		this.pro_num = pro_num;
	}
	public int getPro_stockAmount() {
		return pro_stockAmount;
	}
	public void setPro_stockAmount(int pro_stockAmount) {
		this.pro_stockAmount = pro_stockAmount;
	}
	public String getPro_remark() {
		return pro_remark;
	}
	public void setPro_remark(String pro_remark) {
		this.pro_remark = pro_remark;
	}
	
	
}
