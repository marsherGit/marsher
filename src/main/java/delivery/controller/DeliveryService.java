package delivery.controller;

import java.util.ArrayList;
import java.util.List;

import mj.Product.controller.ProductDataBean;
import mj.Store.service.memberDataBean;

public interface DeliveryService {
	/* deliveryInfo */
	public ArrayList<DeliveryInfo> allMem();
	
	/* deliverStatus */
	public int getArticleCount(String searchText, String productSelect, String storeSelect, int daySelect);
	public List<StateCommand> getArticles(int startRow,int endRow, String searchText, String productSelect, String storeSelect, int daySelect);
	
	/* deliveryUnsolved */
	public int getArticleCountUnsolved(String searchText, String productSelect, String storeSelect, int daySelect);
	public List<StateCommand> getArticlesUnsolved(int startRow,int endRow, String searchText, String productSelect, String storeSelect, int daySelect);
	
	public List<ProductDataBean> getProductList();
	public List<memberDataBean> getStoreList();

}
