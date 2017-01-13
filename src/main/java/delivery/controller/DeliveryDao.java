package delivery.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import mj.Product.controller.ProductDataBean;
import mj.Store.service.memberDataBean;

public class DeliveryDao extends SqlSessionDaoSupport {
	
	/* deliveryInfo.jsp */
	public ArrayList<DeliveryInfo> allMem() {
		
		List<DeliveryInfo> deliveryList = new ArrayList<DeliveryInfo>();
		deliveryList = getSqlSession().selectList("delivery.allMem");
		
		return  (ArrayList<DeliveryInfo>) deliveryList;
		
	}
	
	/* deliveryState.jsp */
	public int getArticleCount() {
		int count = getSqlSession().selectOne("delivery.getArticleCount", Integer.class);
		return count;
	}
	
	public List<StateCommand> getArticles(int startRow, int endRow) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("startRow", startRow);
		map.put("endRow", endRow);
		List<StateCommand> getArticles = getSqlSession().selectList("delivery.getArticles", map);
		return getArticles;
	}
	
	public int getArticleCount(String searchText, String productSelect, String storeSelect, int daySelect){
		int x = 0;
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("productSelect", productSelect);
		map.put("searchText", searchText);
		map.put("storeSelect", storeSelect);
		map.put("daySelect", daySelect);
		x = getSqlSession().selectOne("delivery.searchgetArticleCount",map);
		return x;
	}

	public List<StateCommand> getArticles(int startRow,int endRow, String searchText, String productSelect, String storeSelect, int daySelect){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("startRow", startRow);
		map.put("endRow", endRow);
		map.put("productSelect", productSelect);
		map.put("searchText", searchText);
		map.put("storeSelect", storeSelect);
		map.put("daySelect", daySelect);
		
		List<StateCommand> list = getSqlSession().selectList("delivery.searchgetArticles",map);
		
		return list;
	}
	
	/* deliveryUnsolved.jsp */
	public int getArticleCountUnsolved() {
		int count = getSqlSession().selectOne("delivery.getArticleCountUnsolved", Integer.class);
		return count;
	}

	public List<StateCommand> getArticlesUnsolved(int startRow, int endRow) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("startRow", startRow);
		map.put("endRow", endRow);
		List<StateCommand> getArticles = getSqlSession().selectList("delivery.getArticlesUnsolved", map);
		return getArticles;
	}
	
	public int getArticleCountUnsolved(String searchText, String productSelect, String storeSelect, int daySelect){
		int x = 0;
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("productSelect", productSelect);
		map.put("searchText", searchText);
		map.put("storeSelect", storeSelect);
		map.put("daySelect", daySelect);
		x = getSqlSession().selectOne("delivery.searchgetArticleCountUnsolved",map);
		return x;
	}

	public List<StateCommand> getArticlesUnsolved(int startRow,int endRow, String searchText, String productSelect, String storeSelect, int daySelect){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("startRow", startRow);
		map.put("endRow", endRow);
		map.put("productSelect", productSelect);
		map.put("searchText", searchText);
		map.put("storeSelect", storeSelect);
		map.put("daySelect", daySelect);
		
		List<StateCommand> list = getSqlSession().selectList("delivery.searchgetArticlesUnsolved",map);
		
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
