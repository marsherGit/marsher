package chowonhee.DTO;

import java.util.Date;

public class StockModifyBoard {
	int mod_number;
	String title;
	Date mod_regdate;
	
	public int getMod_number() {
		return mod_number;
	}
	public void setMod_number(int mod_number) {
		this.mod_number = mod_number;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Date getMod_regdate() {
		return mod_regdate;
	}
	public void setMod_regdate(Date mod_regdate) {
		this.mod_regdate = mod_regdate;
	}
	
	
}
