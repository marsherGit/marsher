package login.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import mj.Store.service.memberDataBean;

public class LoginServiceImpl implements LoginService {

	@Autowired
	LoginDao dao;

	public void setDao(LoginDao dao) {
		this.dao = dao;
	}

	// 매장 수정 form (매니저/관리자)
	public memberDataBean getMember2(String st_id) {
		memberDataBean list = null;

		try {
			list = dao.getMember2(st_id);
		} catch (Exception e) {

			e.printStackTrace();
		}

		return list;
	}

	// 매장 수정 Pro (매니저/관리자)
	public int updateMember(memberDataBean member, String st_id) {

		Map<String, Object> map = new HashMap<String, Object>();

		map.put("st_id", member.getSt_id());
		map.put("st_name", member.getSt_name());
		map.put("st_tel", member.getSt_tel());
		map.put("st_location", member.getSt_location());
		map.put("st_image", member.getSt_image());
		map.put("sign_img", member.getSign_img());

		dao.updateMember(map);

		System.out.println("매장정보업데이트");

		return 1;

	}

	// 관리자 매장정보List
	@Override
	public List<memberDataBean> showList() {
		List<memberDataBean> result = new ArrayList<memberDataBean>();
		result = dao.showList();

		return result;

	}


}
