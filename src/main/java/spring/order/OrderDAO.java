package spring.order;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import mj.Product.controller.ProductDataBean;

public class OrderDAO extends SqlSessionDaoSupport {

	/*@Resource(name = "optionsDataMapper")
	private OptionsDataMapper optionsDataMapper;

	//insertProList
	public void insertProList(int o_reStep, List<OrderProducts> proList) {
		this.optionsDataMapper.insertProList(o_reStep, proList);
	}*/

	public List<ProductDataBean> getProductList() {
		List<ProductDataBean> list = new ArrayList<ProductDataBean>();
		list = getSqlSession().selectList("delivery.allProduct");
		return list;
	}

	public List<OrderDataBean> getOrderList() {
		List<OrderDataBean> orderList = getSqlSession().selectList("order.getOrderList");
		return orderList;
	}

	public int getOrderCount() {
		int count = getSqlSession().selectOne("order.getOrderCount", Integer.class);
		return count;
	}

	public OrderDataBean getOrder(int o_ref) {
		OrderDataBean getOrder = getSqlSession().selectOne("order.getOrder", o_ref);
		return getOrder;
	}

	public List<OrderProducts> getOrderProducts(int o_ref) {
		List<OrderProducts> getOrderProducts = getSqlSession().selectList("order.getOrderProducts", o_ref);
		return getOrderProducts;
	}

	public int getProCount() {
		int proCount = getSqlSession().selectOne("order.getProCount", Integer.class);
		return proCount;
	}

	// insertOrder
	public int insertOrder(OrderDataBean ordering) {
		int check = -1;
		check = getSqlSession().insert("order.insertOrder", ordering);
		return check;
	}

}
