package mj.Store.service;

import java.util.HashMap;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;


public class memberDAO extends SqlSessionDaoSupport {
	
	
	

	public memberDataBean getMember(String st_id) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("st_id", st_id);
		memberDataBean getMember = getSqlSession().selectOne("member.getMember", map);
		return getMember;
	}

	public int Insert(String string, Map<String, Object> list) {
		int check = getSqlSession().insert(string, list);
		return check;
	}
	
	
	public memberDataBean getMember2(String st_id) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("st_id", st_id);
		memberDataBean getMember2 = getSqlSession().selectOne("member.getMember2", map);
		return getMember2;
	}
	
	public int updateMember(Map<String, Object> map) {
		getSqlSession().update("member.updateMember", map);
		return 1;
	}

	
}
