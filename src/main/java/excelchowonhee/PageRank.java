package excelchowonhee;

	import javax.xml.bind.annotation.XmlAccessType;
	import javax.xml.bind.annotation.XmlAccessorType;
	import javax.xml.bind.annotation.XmlType;

	@XmlAccessorType(XmlAccessType.FIELD)
	@XmlType(name = "", propOrder = {"no","pro_num","pro_bcategory","pro_name","pro_container","pro_volume","pro_cPrice","pro_uPrice","pro_properStock","totalStockAmount","totalStockAmountStore","pro_remark" })
	public class PageRank {
		
		private int no;
		private String pro_num;/*  제품번호 */
		private String pro_bcategory;/* 품목명 */
		private String pro_name;/* 제품명 */
		private int pro_volume;/* 용량 */
		private String pro_container;/* 용기 */
		private String pro_cPrice;/* 제품원가 */
		private String pro_uPrice;/* 판매단가 */
		private int pro_properStock;/* 적정재고 */
		private int totalStockAmount;
		private int totalStockAmountStore;
		private String pro_remark;
			
		public PageRank(int no, String pro_num, String pro_bcategory, String pro_name, String pro_container,
				int pro_volume, String pro_cPrice, String pro_uPrice,
				int totalStockAmount, int totalStockAmountStore,int pro_properStock,String pro_remark) {
			super();
			this.no = no;
			this.pro_num = pro_num;
			this.pro_bcategory = pro_bcategory;
			this.pro_name = pro_name;
			this.pro_volume = pro_volume;
			this.pro_container = pro_container;
			this.pro_cPrice = pro_cPrice;
			this.pro_uPrice = pro_uPrice;
			this.pro_properStock = pro_properStock;
			this.totalStockAmount = totalStockAmount;
			this.totalStockAmountStore = totalStockAmountStore;
			this.pro_remark = pro_remark;
		}
		
		public int getNo() {
			return no;
		}

		public String getPro_num() {
			return pro_num;
		}

		public String getPro_bcategory() {
			return pro_bcategory;
		}

		public String getPro_name() {
			return pro_name;
		}

		public int getPro_volume() {
			return pro_volume;
		}

		public String getPro_container() {
			return pro_container;
		}

		public String getPro_cPrice() {
			return pro_cPrice;
		}

		public String getPro_uPrice() {
			return pro_uPrice;
		}

		public int getPro_properStock() {
			return pro_properStock;
		}

		public int getTotalStockAmount() {
			return totalStockAmount;
		}

		public int getTotalStockAmountStore() {
			return totalStockAmountStore;
		}

		public String getPro_remark() {
			return pro_remark;
		}
		
	}