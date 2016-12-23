package mj.Store.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.support.SqlSessionDaoSupport;




public class memberDAO extends SqlSessionDaoSupport {
	SqlSession session = getSqlSession();
	
	
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

}
