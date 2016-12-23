package mj.Store.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.support.SqlSessionDaoSupport;




public class memberDAO extends SqlSessionDaoSupport {
	SqlSession session = getSqlSession();
	
	
//�������� �ҷ����� 
	public memberDataBean getMember(String st_id) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("st_id", st_id);
		memberDataBean getMember = getSqlSession().selectOne("member.getMember", map);
		return getMember;
	}

//���� ���� ��� 
	public int Insert(String string, Map<String, Object> list) {
		int check = getSqlSession().insert(string, list);
		return check;
	}
	
	
//���� ���� �ҷ�����(�Ǹ޴���)
	public List<memberDataBean> showList(){
		return getSqlSession().selectList("member.showList");
		
		
	}

}
