package login.controller;

import java.util.List;

import delivery.controller.DeliveryCommand;
import delivery.controller.DeliveryInfo;
import factory.controller.FactoryCommand;
import mj.Store.service.memberDataBean;

public interface LoginService {
	
	public memberDataBean getMember2(String st_id);				    	// storeUpdateForm
	public int updateMember(memberDataBean member, String st_id);   	// storeUpdatePro
	
	public List<memberDataBean> showList();								// storeList
	
	public List<DeliveryInfo> getDeliveryList();						// deliveryList
	
	public int updateDelivery(DeliveryCommand command);					// deliveryUpdate
	public DeliveryCommand getDelivery(int delivery_num); 				// deliveryUpdateForm - command
	
	public int inputDelivery(DeliveryCommand command);					// deliveryInput
	public int totalFactory();											// deliveryInput
	
	public int deleteDelivery(int delivery_num);						// deliveryDelete
	
	public List<FactoryCommand> getFactoryList();						// factoryList
	
	public int updateFactory(FactoryCommand command);					// factoryUpdate
	public FactoryCommand getFactory(int fac_id); 						// factoryUpdateForm - command
	
	public int deleteFactory(int fac_id);								// factoryDelete

}
