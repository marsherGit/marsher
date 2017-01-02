package mj.Product.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class ProductServiceImpl implements ProductService {
	
	private ProductDAO dao;
	
	public void setDao(ProductDAO dao) {
		this.dao = dao;
	}



	public int insert(ProductDataBean product) {
		int check = 0;

		Map<String, Object> map = new HashMap<String, Object>();

		// pro_num;, pro_name pro_bcategory;pro_volume;pro_container; pro_calorie;pro_cPrice; pro_uPrice;pro_properStock;pro_image;

		try {
			map.put("pro_num", product.getPro_num());
			map.put("pro_bcategory", product.getPro_bcategory());
			map.put("pro_name", product.getPro_name());
			map.put("pro_volume", product.getPro_volume());
			map.put("pro_container", product.getPro_container());
			map.put("pro_calorie", product.getPro_calorie());
			map.put("pro_cPrice", product.getPro_cPrice());
			map.put("pro_uPrice", product.getPro_uPrice());
			map.put("pro_properStock", product.getPro_properStock());
			map.put("pro_image", product.getPro_image());

			check = dao.Insert("product.addMember", map);
		} catch (Exception e) {
			System.out.println(e.toString());
		}

		return check;
	}
	
	
	public List<Object> sodaList(int startRow,int endRow) {
		List<Object> result =  null;
		result = dao.sodaList(startRow,endRow);

		return result;

	}
	
	public List<Object> drinkList(int startRow,int endRow) {
		List<Object> result =  null;
		result = dao.drinkList(startRow,endRow);

		return result;

	}
	
	public List<Object> juiceList(int startRow,int endRow) {
		List<Object> result =  null;
		result = dao.juiceList(startRow,endRow);

		return result;

	}
	
	public List<Object> milkList(int startRow,int endRow) {
		List<Object> result =  null;
		result = dao.milkList(startRow,endRow);

		return result;

	}
	
	public int sodaListCount(){
		return dao.sodaListCount();
	}
	
	public int drinkListCount(){
		return dao.drinkListCount();
	}
	
	public int juiceListCount(){
		return dao.juiceListCount();
	}
	
	public int milkListCount(){
		return dao.milkListCount();
	}

}
