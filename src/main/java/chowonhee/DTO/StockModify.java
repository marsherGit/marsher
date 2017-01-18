package chowonhee.DTO;

import java.util.Date;

public class StockModify {
	  int mod_number; 
	  String pro_num; 
	  int real_stockAmount; 
	  int old_stockAmount;
	  Date mod_regdate;
	  
	public int getMod_number() {
		return mod_number;
	}
	public void setMod_number(int mod_number) {
		this.mod_number = mod_number;
	}
	public String getPro_num() {
		return pro_num;
	}
	public void setPro_num(String pro_num) {
		this.pro_num = pro_num;
	}
	public int getReal_stockAmount() {
		return real_stockAmount;
	}
	public void setReal_stockAmount(int real_stockAmount) {
		this.real_stockAmount = real_stockAmount;
	}
	public int getOld_stockAmount() {
		return old_stockAmount;
	}
	public void setOld_stockAmount(int old_stockAmount) {
		this.old_stockAmount = old_stockAmount;
	}
	public Date getMod_regdate() {
		return mod_regdate;
	}
	public void setMod_regdate(Date mod_regdate) {
		this.mod_regdate = mod_regdate;
	}
}
