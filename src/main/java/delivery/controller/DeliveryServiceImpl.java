package delivery.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mj.Product.controller.ProductDataBean;
import mj.Store.service.memberDataBean;


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
	public int getArticleCount() {
		int count = 0;
		count = dao.getArticleCount();
		
		return count;
	}

	public List<StateCommand> getArticles(int startRow, int endRow) {
		List<StateCommand> list = null;
		list = dao.getArticles(startRow, endRow);
		
		return list;
	}
	
	public int getArticleCount(String searchText, String productSelect, String storeSelect, int daySelect) {
		int count = 0;
		if((searchText == null || "".equals(searchText)) && "0".equals(productSelect) && "0".equals(storeSelect) && daySelect == 0)
			count = dao.getArticleCount();
		else
			count = dao.getArticleCount(searchText, productSelect, storeSelect, daySelect);
		
		return count;
	}
	
	public List<StateCommand> getArticles(int startRow,int endRow, String searchText, String productSelect, String storeSelect, int daySelect) {
		List<StateCommand> list = null;
		
		if((searchText == null || "".equals(searchText)) && "0".equals(productSelect) && "0".equals(storeSelect) && daySelect == 0)
			list = dao.getArticles(startRow, endRow);
		else
			list = dao.getArticles(startRow, endRow, searchText, productSelect, storeSelect, daySelect);
	

		return list;
	}
	
	
	/* deliveryUnsolved.jsp */
	public int getArticleCountUnsolved() {
		int count = 0;
		count = dao.getArticleCountUnsolved();
		
		return count;
	}

	public List<StateCommand> getArticlesUnsolved(int startRow, int endRow) {
		List<StateCommand> list = null;
		list = dao.getArticlesUnsolved(startRow, endRow);
		
		return list;
	}
	
	public int getArticleCountUnsolved(String searchText, String productSelect, String storeSelect, int daySelect) {
		int count = 0;
		if((searchText == null || "".equals(searchText)) && "0".equals(productSelect) && "0".equals(storeSelect) && daySelect == 0)
			count = dao.getArticleCountUnsolved();
		else
			count = dao.getArticleCountUnsolved(searchText, productSelect, storeSelect, daySelect);
		
		return count;
	}
	
	public List<StateCommand> getArticlesUnsolved(int startRow,int endRow, String searchText, String productSelect, String storeSelect, int daySelect) {
		List<StateCommand> list = null;
		
		if((searchText == null || "".equals(searchText)) && "0".equals(productSelect) && "0".equals(storeSelect) && daySelect == 0)
			list = dao.getArticlesUnsolved(startRow, endRow);
		else
			list = dao.getArticlesUnsolved(startRow, endRow, searchText, productSelect, storeSelect, daySelect);
	

		return list;
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
