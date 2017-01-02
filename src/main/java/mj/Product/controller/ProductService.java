package mj.Product.controller;

import java.util.List;

public interface ProductService {
	
	public int insert(ProductDataBean product);
	public List<Object> sodaList(int startRow,int endRow);	
	public List<Object> drinkList(int startRow,int endRow);	
	public List<Object> juiceList(int startRow,int endRow);	
	public List<Object> milkList(int startRow,int endRow);	
	public int sodaListCount();
	public int drinkListCount();
	public int juiceListCount();
	public int milkListCount();
	
	

}
