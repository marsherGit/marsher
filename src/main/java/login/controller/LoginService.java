package login.controller;

import java.util.List;

import delivery.controller.DeliveryCommand;
import delivery.controller.DeliveryInfo;
import factory.controller.FactoryCommand;
import mj.Notice.controller.NoticeDataBean;
import mj.Store.service.memberDataBean;
import spring.message.ReceiveMsg;

public interface LoginService {
	
	public String getLogintype(String st_id);							// login - type check
	public String getPasswd(String st_id);								// login - passwd check
	
	public memberDataBean getMember2(String st_id);				    	// storeUpdateForm
	public int updateMember(memberDataBean member, String st_id);   	// storeUpdatePro
	public List<memberDataBean> showList();								// storeList
	public int  deleteMember(String st_id);								// storeDeletePro
	
	
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
	
	
	public List<NoticeDataBean> calNoticeList();						// main - calendar
	public NoticeDataBean getNotice3(String calendar_date);				// main - calendarView
	public int newMsg_count(String memId);								// nowMessageCount

}
