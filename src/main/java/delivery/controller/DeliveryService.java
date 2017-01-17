package delivery.controller;

import java.util.ArrayList;
import java.util.List;

import mj.Product.controller.ProductDataBean;
import mj.Store.service.memberDataBean;

public interface DeliveryService {
	/* deliveryInfo */
	public ArrayList<DeliveryInfo> allMem();
	
	/* deliverStatus */
	public int getArticleCount(String st_id); //get
	public List<StateCommand> getArticles(String st_id, int startRow, int endRow); 	//get
	
	public List<StateCommand> getArticles(String st_id, int startRow,int endRow, String searchText, String productSelect, String storeSelect, int daySelect);
	public int getArticleCount(String st_id, String searchText, String productSelect, String storeSelect, int daySelect);
	
	public List<ProductDataBean> getProductList();
	public List<memberDataBean> getStoreList();

	public int getArticleCountUnsolved(String st_id); //get
	public List<StateCommand> getArticlesUnsolved(String st_id, int startRow, int endRow); 	//get
	
	public List<StateCommand> getArticlesUnsolved(String st_id, int startRow,int endRow, String searchText, String productSelect, String storeSelect, int daySelect);
	public int getArticleCountUnsolved(String st_id, String searchText, String productSelect, String storeSelect, int daySelect);

}
