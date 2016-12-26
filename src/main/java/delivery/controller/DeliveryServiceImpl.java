package delivery.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	
	
	
	public void setDao(DeliveryDao dao) {
		this.dao = dao;
	}
}
