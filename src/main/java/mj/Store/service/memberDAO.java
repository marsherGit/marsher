package mj.Store.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;




public class memberDAO extends SqlSessionDaoSupport {
	
	
	
//매장정보 불러오기 
	public memberDataBean getMember(String st_id) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("st_id", st_id);
		memberDataBean getMember = getSqlSession().selectOne("member.getMember", map);
		return getMember;
	}

//매장 정보 등록 
	public int Insert(String string, Map<String, Object> list) {
		int check = getSqlSession().insert(string, list);
		return check;
	}
	
	
//매장 정보 불러오기(탭메뉴용)
	public List<memberDataBean> showList(){
		return getSqlSession().selectList("member.showList");
		
		
	}
	
	
	
	
//매장 정보 불러오기(수정페이지용)	
	public memberDataBean getMember2(String st_id) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("st_id", st_id);
		memberDataBean getMember2 = getSqlSession().selectOne("member.getMember2", map);
		return getMember2;
	}
	
	
//매장 정보 수정	
	public int updateMember(Map<String, Object> map) {
		getSqlSession().update("member.updateMember", map);
		return 1;
	}

//관리자 매장 정보 수정 form
	public List<memberDataBean> showList(String st_id){
		return getSqlSession().selectList("member.showList2");
			
			
		}
	

	
	//관리자 정보 수정	
		public int updateMember2(Map<String, Object> map) {
			getSqlSession().update("member.updateMember2", map);
			return 1;
		}
}
