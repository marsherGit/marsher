package login.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import delivery.controller.DeliveryCommand;
import delivery.controller.DeliveryInfo;
import factory.controller.FactoryCommand;
import mj.Notice.controller.NoticeDataBean;
import mj.Store.service.memberDataBean;
import spring.message.ReceiveMsg;

public class LoginDao extends SqlSessionDaoSupport {
	// login
	public String getPasswd(String st_id) {
		return (String) getSqlSession().selectOne("loginMem.checkPasswd", st_id);
	}
	public String getLogintype(String st_id) {
		return (String) getSqlSession().selectOne("loginMem.checkLogintype", st_id);
	}
	public String getName(String st_id) {
		return (String) getSqlSession().selectOne("loginMem.getName", st_id);
	}

	// �������� �ҷ����� (�Ŵ���/������)
	public memberDataBean getMember2(String st_id) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("st_id", st_id);
		memberDataBean getMember2 = getSqlSession().selectOne("loginMem.getMember2", map);
		return getMember2;
	}

	// ���� ���� ���� (�Ŵ���/������)
	public int updateMember(Map<String, Object> map) {
		getSqlSession().update("loginMem.updateMember", map);
		return 1;
	}

	// ������ ���� List (adminpage)
	public List<memberDataBean> showList() {
		return getSqlSession().selectList("loginMem.showList");
	}
	
	//Admin_memberDelte
	public int deleteMember(String st_id) {
		int check = getSqlSession().delete("loginMem.deleteMember", st_id);
		return check;
	}
	
	
	// deliveryList
	public List<DeliveryInfo> getDeliveryList() {
		List<DeliveryInfo> deliveryList = getSqlSession().selectList("delivery.allDelivery");
		return deliveryList;
	}
	
	// delivery_num
	public int maxDelivery() {
		return getSqlSession().selectOne("delivery.maxDelivery_num");
	}

	// deliveryUpdate
	public int updateDelivery(DeliveryCommand command) {
		int check = -1;
		check = getSqlSession().update("delivery.update", command);
		return check;
	}
	
	// getDeliveryMember
	public DeliveryCommand getDelivery(int delivery_num) {
		DeliveryCommand deliveryCommand = getSqlSession().selectOne("delivery.selectMem", delivery_num);
		return deliveryCommand;
	}
	
	// inputDelivery
	public int inputDelivery(DeliveryCommand command) {
		int check = -1;
		check = getSqlSession().insert("delivery.insert", command);
		return check;
	}
	
	// totalFactory
	public int totalFactory() {
		int total = getSqlSession().selectOne("factory.totalFactory");
		return total;
	}
	
	// deliveryDelete
	public int deleteDelivery(int delivery_num) {
		int check = -1;
		check = getSqlSession().insert("delivery.delete", delivery_num);
		return 0;
	}
	
	// factoryList
	public List<FactoryCommand> getFactoryList() {
		List<FactoryCommand> factoryCommand = getSqlSession().selectList("factory.allFactory");
		return factoryCommand;
	}
	
	// factoryUpdate
	public int updateFactory(FactoryCommand command) {
		int check = -1;
		check = getSqlSession().update("factory.updateFactory", command);
		return check;
	}
	
	// getFactoryMember
	public FactoryCommand getFactory(int fac_id) {
		FactoryCommand factoryCommand = getSqlSession().selectOne("factory.selectFactory", fac_id);
		return factoryCommand;
	}
	
	// deleteFactory
	public int deleteFactory(int fac_id) {
		int check = -1;
		check = getSqlSession().insert("factory.deleteFactory", fac_id);
		return 0;
	}
	
	// main - calendar 
	public List<NoticeDataBean> calNoticeList(){
		return getSqlSession().selectList("notice.calNoticeList");
			
	}
	
	// main - calendarView
	public NoticeDataBean getNotice3(String calendar_date) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("calendar_date", calendar_date);
		
		NoticeDataBean getNotice2 = getSqlSession().selectOne("notice.getNotice3", map);
		return getNotice2;
	}
	
	public int newMsg_count(String memId) {
		int count = getSqlSession().selectOne("message.getNewMsgCount", memId);
		return count; 
	}
	public List<ReceiveMsg> receiveMsg_list() {
		List<ReceiveMsg> receiveMsg_list = getSqlSession().selectList("message.getReceiveMsgList");
		return receiveMsg_list;
	}
	
	public int getNewOrderCount() {
		int count = getSqlSession().selectOne("order.getNewOrderCount", Integer.class);
		return count;
	}
	
	

}