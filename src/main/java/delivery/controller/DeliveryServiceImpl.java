package delivery.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mj.Product.controller.ProductDataBean;
import mj.Store.service.memberDataBean;
import spring.order.OrderDataBean;

@Service("deliveryService")
public class DeliveryServiceImpl implements DeliveryService {
	@Autowired
	DeliveryDao dao;

	/* deliveryInfo.jsp */
	public ArrayList<DeliveryInfo> allMem() {
		
		List<DeliveryInfo> deliveryList = new ArrayList<DeliveryInfo>();
		deliveryList = dao.allMem();
		
		return  (ArrayList<DeliveryInfo>) deliveryList;
	} //end allMem()
	
	/* deliveryState.jsp */
	public List<OrderDataBean> getArticles(int startRow,int endRow, String searchText, String productSelect, String storeSelect, int daySelect) {
		List<OrderDataBean> list = null;
		
		if((searchText == null || searchText.equals("")) && productSelect.equals("0") && storeSelect.equals("0") && daySelect == 0)
			list = dao.getArticles(startRow, endRow);
		else
			list = dao.getArticles(startRow, endRow, searchText, productSelect, storeSelect, daySelect);
	

		return list;
	}
	
	public int getArticleCount(String searchText, String productSelect, String storeSelect, int daySelect) {
		int count = 0;
		if((searchText == null || searchText.equals("")) && productSelect.equals("0") && storeSelect.equals("0") && daySelect == 0)
			count = dao.getArticleCount();
		else
			count = dao.getArticleCount(searchText, productSelect, storeSelect, daySelect);
		
		return count;
	}
	
	public void stateChange(int o_num){
//		System.out.println("stateChange()실행");   					//test code
		dao.stateChange(o_num);
	}
	
	public List<ProductDataBean> getProductList() {
		List<ProductDataBean> list = new ArrayList<ProductDataBean>();
		list = dao.getProductList();
		return list;
	}
	
	public List<memberDataBean> getStoreList() {
		List<memberDataBean> list = new ArrayList<memberDataBean>();
		list = dao.getStoreList();
		return list;
	}
	
	public void setDao(DeliveryDao dao) {
		this.dao = dao;
	}
}
