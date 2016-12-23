package login.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import mj.Store.service.memberDataBean;

public class LoginDao extends SqlSessionDaoSupport {
	public String getArticle(String st_id) {
		return (String) getSqlSession().selectOne("loginMem.checkMem", st_id);
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


}