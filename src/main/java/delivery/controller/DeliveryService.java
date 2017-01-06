package delivery.controller;

import java.util.ArrayList;
import java.util.List;

import mj.Product.controller.ProductDataBean;
import mj.Store.service.memberDataBean;
import spring.order.OrderDataBean;

public interface DeliveryService {
	/* deliveryInfo */
	public ArrayList<DeliveryInfo> allMem();
	
	/* deliverStatus */
	public List<OrderDataBean> getArticles(int startRow,int endRow, String searchText, String productSelect, String storeSelect, int daySelect);
	public int getArticleCount(String searchText, String productSelect, String storeSelect, int daySelect);
	
	public void stateChange(int o_num);		// 배송상태 변경

	public List<ProductDataBean> getProductList();
	public List<memberDataBean> getStoreList();
	
}
