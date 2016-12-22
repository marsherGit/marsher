package mj.Store.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;




public class memberDAO extends SqlSessionDaoSupport {
	
	
	
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
	
	
	
	
//���� ���� �ҷ�����(������������)	
	public memberDataBean getMember2(String st_id) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("st_id", st_id);
		memberDataBean getMember2 = getSqlSession().selectOne("member.getMember2", map);
		return getMember2;
	}
	
	
//���� ���� ����	
	public int updateMember(Map<String, Object> map) {
		getSqlSession().update("member.updateMember", map);
		return 1;
	}

//������ ���� ���� ���� form
	public List<memberDataBean> showList(String st_id){
		return getSqlSession().selectList("member.showList2");
			
			
		}
	

	
	//������ ���� ����	
		public int updateMember2(Map<String, Object> map) {
			getSqlSession().update("member.updateMember2", map);
			return 1;
		}
}
