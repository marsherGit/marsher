package login.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import delivery.controller.DeliveryCommand;
import delivery.controller.DeliveryInfo;
import factory.controller.FactoryCommand;
import mj.Notice.controller.NoticeDataBean;
import mj.Store.service.memberDataBean;

@Service("loginService")
public class LoginServiceImpl implements LoginService {

	@Autowired
	LoginDao dao;

	public void setDao(LoginDao dao) {
		this.dao = dao;
	}

	// login
	public String getLogintype(String st_id) {
		String logintype = dao.getLogintype(st_id);
		return logintype;
	}
	public String getPasswd(String st_id) {
		String passwd = dao.getPasswd(st_id);
		return passwd;
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

		return 1;

	}

	// ������ ��������List
	@Override
	public List<memberDataBean> showList() {
		List<memberDataBean> result = new ArrayList<memberDataBean>();
		result = dao.showList();

		return result;

	}
	
	//Admin_memberDelte
	@Override
	public int deleteMember(String st_id){
		int check = dao.deleteMember(st_id);
			
		return check;
			
	}
	
	
	/* delivery */
	@Override
	public List<DeliveryInfo> getDeliveryList() {
		List<DeliveryInfo> list = dao.getDeliveryList();
		return list;
	}
	
	@Override
	public int updateDelivery(DeliveryCommand command, String contextRoot) {
		int delivery_num = command.getDelivery_num();
		MultipartFile delivery_file = command.getDelivery_file();
		if(delivery_file != null) {
			String original_file_name = delivery_file.getOriginalFilename();
			int pos = original_file_name.lastIndexOf(".");
			String original_extention = original_file_name.substring(pos);
			
			String stored_file_path = contextRoot + "saveFile\\";
			String stored_file_name = "delivery" + delivery_num;
			if(pos > 0) stored_file_name += original_extention;
			
			File stored_file = new File(stored_file_path + stored_file_name);
			try {
				delivery_file.transferTo(stored_file);
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			System.out.println("파일이름 : "+stored_file_name);
			command.setDelivery_img(stored_file_name);
		}
		System.out.println("update : "+command);			//test code
		
		int check = dao.updateDelivery(command);
		return check;
	}

	@Override
	public DeliveryCommand getDelivery(int delivery_num) {
		DeliveryCommand deliveryCommand = dao.getDelivery(delivery_num);
		return deliveryCommand;
	}
	
	@Override
	public int inputDelivery(DeliveryCommand command, String contextRoot) {
		int delivery_num = 0;
		delivery_num = dao.maxDelivery() + 1;
		
		MultipartFile delivery_file = command.getDelivery_file();
		if(delivery_file != null){
			String original_file_name = delivery_file.getOriginalFilename();
			int pos = original_file_name.lastIndexOf(".");
			String original_extention = original_file_name.substring(pos);
			
			String stored_file_path = contextRoot + "saveFile\\";
			String stored_file_name = "delivery" + delivery_num;
			if(pos > 0) stored_file_name += original_extention;
			
			File stored_file = new File(stored_file_path + stored_file_name);
			try {
				delivery_file.transferTo(stored_file);
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			command.setDelivery_img(stored_file_name);
		}
		command.setDelivery_num(delivery_num);
		
		System.out.println(command);			//test code
		
		int check = dao.inputDelivery(command);
		return 0;
	}

	@Override
	public int totalFactory() {
		int total = dao.totalFactory();
		return total;
	}
	
	@Override
	public int deleteDelivery(int delivery_num, String contextRoot) {
		DeliveryCommand command = dao.getDelivery(delivery_num);
		String delivery_img = command.getDelivery_img();
		String stored_file_name = contextRoot + "saveFile\\" + delivery_img;
		File stored_file = new File(stored_file_name);
		if(stored_file.isFile()) stored_file.delete();
		
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
	public int updateFactory(FactoryCommand command, String contextRoot) {
		int fac_id = command.getFac_id();
		MultipartFile fac_file = command.getFac_file();
		if(fac_file != null) {
			String original_file_name = fac_file.getOriginalFilename();
			int pos = original_file_name.lastIndexOf(".");
			String original_extention = original_file_name.substring(pos);
			
			String stored_file_path = contextRoot + "saveFile\\";
			String stored_file_name = "factory" + fac_id;
			if(pos > 0) stored_file_name += original_extention;
			
			File stored_file = new File(stored_file_path + stored_file_name);
			try {
				fac_file.transferTo(stored_file);
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			command.setFac_image(stored_file_name);
		}
		System.out.println("update : "+command);			//test code
		
		int check = dao.updateFactory(command);
		return check;
	}

	@Override
	public FactoryCommand getFactory(int fac_id) {
		FactoryCommand factoryCommand = dao.getFactory(fac_id);
		return factoryCommand;
	}

	@Override
	public int deleteFactory(int fac_id, String contextRoot) {
		FactoryCommand command = dao.getFactory(fac_id);
		String fac_image = command.getFac_image();
		String stored_file_name = contextRoot + "saveFile\\" + fac_image;
		File stored_file = new File(stored_file_name);
		if(stored_file.isFile()) stored_file.delete();
		
		int check = dao.deleteFactory(fac_id);
		return check;
	}

	@Override
	public List<NoticeDataBean> calNoticeList() {
		List<NoticeDataBean> result = new ArrayList<NoticeDataBean>();
		result = dao.calNoticeList();

		return result;

	}

	@Override
	public NoticeDataBean getNotice3(String calendar_date) {
		NoticeDataBean list = null;

		try {
			list = dao.getNotice3(calendar_date);
		} catch (Exception e) {

			e.printStackTrace();
		}

		return list;
	}

}
