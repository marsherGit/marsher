package delivery.controller;

import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.support.SqlSessionDaoSupport;

public class DeliveryDao extends SqlSessionDaoSupport {
	SqlSession session = getSqlSession();
	
	public HashMap<String,Object> allMem() {
		HashMap<String,Object> map = new HashMap<String,Object>();
		
		return map;
	}
}
