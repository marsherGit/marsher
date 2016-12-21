package mj.Store.service;

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
	

 
	public int insert(memberDataBean article) {
		int check =0;
		
		Map<String, Object> map = new HashMap<String, Object>();
		
	//	st_id, passwd, st_name, st_tel, st_location, st_image, sign_img
		
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

	
	public memberDataBean getMember2(String st_id) {
		memberDataBean list = null;
		
		try {                        
			list = dao.getMember2(st_id);
		} catch (Exception e) {

			e.printStackTrace();
		}

		return list;
	}
	
	

	
	public int updateMember(memberDataBean member, String st_id){
		
		Map<String,Object> map = new HashMap<String,Object>();
		
		map.put("st_id",member.getSt_id());
		map.put("st_name",member.getSt_name());
		map.put("st_tel",member.getSt_tel());
		map.put("st_location",member.getSt_location());
		map.put("st_image", member.getSt_image());
		map.put("sign_img", member.getSign_img());
		
		
		dao.updateMember(map);
		
		System.out.println("매장정보업데이트");
		
		return 1;
	
		
	}
}
	
	

