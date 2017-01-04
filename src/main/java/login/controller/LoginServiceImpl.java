package login.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import delivery.controller.DeliveryCommand;
import delivery.controller.DeliveryInfo;
import factory.controller.FactoryCommand;
import mj.Store.service.memberDataBean;

@Service("loginService")
public class LoginServiceImpl implements LoginService {

	@Autowired
	LoginDao dao;

	public void setDao(LoginDao dao) {
		this.dao = dao;
	}

	// ���� ���� form (�Ŵ���/������)
	public memberDataBean getMember2(String st_id) {
		memberDataBean list = null;

		try {
			list = dao.getMember2(st_id);
		} catch (Exception e) {

			e.printStackTrace();
		}

		return list;
	}

	// ���� ���� Pro (�Ŵ���/������)
	public int updateMember(memberDataBean member, String st_id) {

		Map<String, Object> map = new HashMap<String, Object>();

		map.put("st_id", member.getSt_id());
		map.put("st_name", member.getSt_name());
		map.put("st_tel", member.getSt_tel());
		map.put("st_location", member.getSt_location());
		map.put("st_image", member.getSt_image());
		map.put("sign_img", member.getSign_img());

		dao.updateMember(map);

		System.out.println("��������������Ʈ");

		return 1;

	}

	// ������ ��������List
	@Override
	public List<memberDataBean> showList() {
		List<memberDataBean> result = new ArrayList<memberDataBean>();
		result = dao.showList();

		return result;

	}
	
	/* delivery */
	@Override
	public List<DeliveryInfo> getDeliveryList() {
		List<DeliveryInfo> list = dao.getDeliveryList();
		return list;
	}
	
	@Override
	public int updateDelivery(DeliveryCommand command) {
		int check = dao.updateDelivery(command);
		return check;
	}

	@Override
	public DeliveryCommand getDelivery(int delivery_num) {
		DeliveryCommand deliveryCommand = dao.getDelivery(delivery_num);
		return deliveryCommand;
	}
	
	@Override
	public int inputDelivery(DeliveryCommand command) {
		int check = dao.inputDelivery(command);
		return 0;
	}

	@Override
	public int totalFactory() {
		int total = dao.totalFactory();
		return total;
	}
	
	@Override
	public int deleteDelivery(int delivery_num) {
		int check = dao.deleteDelivery(delivery_num);
		return check;
	}
	
	/* factory */
	@Override
	public List<FactoryCommand> getFactoryList() {
		List<FactoryCommand> list = dao.getFactoryList();
		return list;
	}

	@Override
	public int updateFactory(FactoryCommand command) {
		int check = dao.updateFactory(command);
		return check;
	}

	@Override
	public FactoryCommand getFactory(int fac_id) {
		FactoryCommand factoryCommand = dao.getFactory(fac_id);
		return factoryCommand;
	}

	@Override
	public int deleteFactory(int fac_id) {
		int check = dao.deleteFactory(fac_id);
		return check;
	}


}
