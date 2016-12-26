package delivery.controller;

import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;

public class DeliveryDao extends SqlSessionDaoSupport {
	
	/* deliveryInfo.jsp */
	public ArrayList<DeliveryInfo> allMem() {
		
		List<DeliveryInfo> deliveryList = new ArrayList<DeliveryInfo>();
		deliveryList = getSqlSession().selectList("delivery.allMem");
		
		return  (ArrayList<DeliveryInfo>) deliveryList;
		
	} //end allMem()

}
