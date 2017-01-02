package mj.Product.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;

public class ProductDAO extends SqlSessionDaoSupport {
	
	// product Register Pro
	public int Insert(String string, Map<String, Object> list) {
		int check = getSqlSession().insert(string, list);
		return check;
	}

	// soda Product Form
	public List<Object> sodaList(int startRow, int endRow) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("startRow", startRow);
		map.put("endRow", endRow);
		List<Object> sodaList = getSqlSession().selectList("product.sodaList", map);
		System.out.println(sodaList.size());
		return sodaList;

	}

	// drink Product Form
	public List<Object> drinkList(int startRow, int endRow) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("startRow", startRow);
		map.put("endRow", endRow);
		List<Object> drinkList = getSqlSession().selectList("product.drinkList", map);
		System.out.println(drinkList.size());
		return drinkList;

	}

	// juice Product Form
	public List<Object> juiceList(int startRow, int endRow) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("startRow", startRow);
		map.put("endRow", endRow);
		List<Object> juiceList = getSqlSession().selectList("product.juiceList", map);
		System.out.println(juiceList.size());
		return juiceList;

	}

	// milk Product Form
	public List<Object> milkList(int startRow, int endRow) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("startRow", startRow);
		map.put("endRow", endRow);
		List<Object> milkList = getSqlSession().selectList("product.milkList", map);
		System.out.println(milkList.size());
		return milkList;

	}

	public int sodaListCount() {
		int count = getSqlSession().selectOne("product.sodaListCount", Integer.class); 
		return count;
	}
	
	public int drinkListCount() {
		int count = getSqlSession().selectOne("product.drinkListCount", Integer.class); 
		return count;
	}
	
	public int juiceListCount() {
		int count = getSqlSession().selectOne("product.juiceListCount", Integer.class); 
		return count;
	}
	
	public int milkListCount() {
		int count = getSqlSession().selectOne("product.milkListCount", Integer.class); 
		return count;
	}

}
