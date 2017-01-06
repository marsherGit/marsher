package delivery.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import mj.Product.controller.ProductDataBean;
import mj.Store.service.memberDataBean;
import spring.order.OrderDataBean;

public class DeliveryDao extends SqlSessionDaoSupport {
	
	/* deliveryInfo.jsp */
	public ArrayList<DeliveryInfo> allMem() {
		
		List<DeliveryInfo> deliveryList = new ArrayList<DeliveryInfo>();
		deliveryList = getSqlSession().selectList("delivery.allMem");
		
		return  (ArrayList<DeliveryInfo>) deliveryList;
		
	}

	/* deliveryState.jsp */
	public List<OrderDataBean> getArticles(int startRow, int endRow) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("startRow", startRow);
		map.put("endRow", endRow);
		List<OrderDataBean> getArticles = getSqlSession().selectList("delivery.getArticles", map);
//		System.out.println(getArticles.size());  //testcode
		return getArticles;
	}

	public int getArticleCount() {
		int count = getSqlSession().selectOne("delivery.getArticleCount", Integer.class);
		return count;
	}
	

	public void stateChange(int o_num) {
		int i = getSqlSession().update("delivery.stateChange", o_num);
	}

	public int getArticleCount(String searchText, String productSelect, String storeSelect, int daySelect){
		int x = 0;
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("productSelect", productSelect);
		map.put("searchText", searchText);
		map.put("storeSelect", storeSelect);
		map.put("daySelect", daySelect);
		x = getSqlSession().selectOne("delivery.getArticleCount", Integer.class); // cityMapper		
		return x;
	}

	public List<OrderDataBean> getArticles(int startRow,int endRow, String searchText, String productSelect, String storeSelect, int daySelect){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("startRow", startRow);
		map.put("endRow", endRow);
		map.put("productSelect", productSelect);
		map.put("searchText", searchText);
		map.put("storeSelect", storeSelect);
		map.put("daySelect", daySelect);
		
		List<OrderDataBean> list = getSqlSession().selectList("delivery.searchgetArticles",map);
		return list;
	}

	public List<ProductDataBean> getProductList() {
		List<ProductDataBean> list = new ArrayList<ProductDataBean>();
		list = getSqlSession().selectList("delivery.allProduct");
		return list;
	}
	
	public List<memberDataBean> getStoreList() {
		List<memberDataBean> list = new ArrayList<memberDataBean>();
		list = getSqlSession().selectList("delivery.allStore");
		return list;
	}
	
}
