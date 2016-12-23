package mj.Store.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;


public class memberServiceImpl implements memberService {

	@Autowired
	private memberDAO dao;

	public void setDao(memberDAO dao) {
		this.dao = dao;
	}

	public memberDataBean getMember(String st_id) {
		memberDataBean list = null;

		try {
			list = dao.getMember(st_id);
		} catch (Exception e) {

			e.printStackTrace();
		}

		return list;
	}

	// 매장 찾기 페이지(탭메뉴용)
	@Override
	public List<memberDataBean> showList() {
		List<memberDataBean> result = new ArrayList<memberDataBean>();
		result = dao.showList();

		return result;

	}

	public int insert(memberDataBean article) {
		int check = 0;

		Map<String, Object> map = new HashMap<String, Object>();

		// st_id, passwd, st_name, st_tel, st_location, st_image, sign_img

		try {
			map.put("st_id", article.getSt_id());
			map.put("passwd", article.getPasswd());
			map.put("st_name", article.getSt_name());
			map.put("st_tel", article.getSt_tel());
			map.put("st_location", article.getSt_location());
			map.put("st_image", article.getSt_image());
			map.put("sign_img", article.getSign_img());

			check = dao.Insert("member.addMember", map);
		} catch (Exception e) {
			System.out.println(e.toString());
		}

		return check;
	}
}

