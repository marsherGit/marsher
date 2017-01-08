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
	public int getArticleCount(); //get
	public List<OrderDataBean> getArticles(int startRow, int endRow); 	//get
	
	public List<OrderDataBean> getArticles(int startRow,int endRow, String searchText, String productSelect, String storeSelect, int daySelect);
	public int getArticleCount(String searchText, String productSelect, String storeSelect, int daySelect);
	
	public List<ProductDataBean> getProductList();
	public List<memberDataBean> getStoreList();

	public int getArticleCountUnsolved(); //get
	public List<OrderDataBean> getArticlesUnsolved(int startRow, int endRow); 	//get
	
	public List<OrderDataBean> getArticlesUnsolved(int startRow,int endRow, String searchText, String productSelect, String storeSelect, int daySelect);
	public int getArticleCountUnsolved(String searchText, String productSelect, String storeSelect, int daySelect);

}
