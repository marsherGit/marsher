package chowonhee.DTO;

public class Product {

	String pro_num;/*  제품번호 */
	String pro_bcategory;/* 품목명 */
	String pro_name;/* 제품명 */
	int pro_volume;/* 용량 */
	String pro_container;/* 용기 */
	String pro_calorie;/* 칼로리 */
	String pro_cPrice;/* 제품원가 */
	String pro_uPrice;/* 판매단가 */
	int pro_properStock;/* 적정재고 */
	
	public String getPro_num() {
		return pro_num;
	}
	public void setPro_num(String pro_num) {
		this.pro_num = pro_num;
	}
	public String getPro_bcategory() {
		return pro_bcategory;
	}
	public void setPro_bcategory(String pro_bcategory) {
		this.pro_bcategory = pro_bcategory;
	}
	public String getPro_name() {
		return pro_name;
	}
	public void setPro_name(String pro_name) {
		this.pro_name = pro_name;
	}
	public int getPro_volume() {
		return pro_volume;
	}
	public void setPro_volume(int pro_volume) {
		this.pro_volume = pro_volume;
	}
	public String getPro_container() {
		return pro_container;
	}
	public void setPro_container(String pro_container) {
		this.pro_container = pro_container;
	}
	public String getPro_calorie() {
		return pro_calorie;
	}
	public void setPro_calorie(String pro_calorie) {
		this.pro_calorie = pro_calorie;
	}
	public String getPro_cPrice() {
		return pro_cPrice;
	}
	public void setPro_cPrice(String pro_cPrice) {
		this.pro_cPrice = pro_cPrice;
	}
	public String getPro_uPrice() {
		return pro_uPrice;
	}
	public void setPro_uPrice(String pro_uPrice) {
		this.pro_uPrice = pro_uPrice;
	}
	public int getPro_properStock() {
		return pro_properStock;
	}
	public void setPro_properStock(int pro_properStock) {
		this.pro_properStock = pro_properStock;
	}
	@Override
	public String toString() {
		return "Product [pro_num=" + pro_num + ", pro_bcategory=" + pro_bcategory + ", pro_name=" + pro_name
				+ ", pro_volume=" + pro_volume + ", pro_container=" + pro_container + ", pro_calorie=" + pro_calorie
				+ ", pro_cPrice=" + pro_cPrice + ", pro_uPrice=" + pro_uPrice + ", pro_properStock=" + pro_properStock
				+ "]";
	}
	
	
}
