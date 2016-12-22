package spring.order;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;

public class OrderDAO extends SqlSessionDaoSupport {
	
	public List<Object> getOrders(int startRow, int endRow){
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("startRow",startRow);
		map.put("endRow",endRow);
		List<Object> getOrders = getSqlSession().selectList("order.getOrders",map);
		System.out.println(getOrders.size());
		return getOrders;
	}
	
	public Order getOrder(int o_num){
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("o_num",o_num);
		Order getOrder = getSqlSession().selectOne("order.getOrder",map);
		return getOrder;
		
	}
	
	public int Insert(String string, Map<String, Object> list) {
		int check = getSqlSession().insert(string, list);
		return check;
	}



}
