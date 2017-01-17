package spring.order;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import factory.controller.FactoryCommand;
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
	public List<FactoryCommand> getFactoryList() {
		List<FactoryCommand> list = new ArrayList<FactoryCommand>();
		list = getSqlSession().selectList("factory.allFactory");
		return list;
	}

	public List<OrderDataBean> getOrderList(String o_sender) {
		List<OrderDataBean> list = new ArrayList<OrderDataBean>();
		list = getSqlSession().selectList("order.getOrderList", o_sender);
		return list;
	}
	
	public List<OrderDataBean> getAllOrders() {
		List<OrderDataBean> list = new ArrayList<OrderDataBean>();
		list = getSqlSession().selectList("order.getAllOrders");
		return list;
	}
	
	public List<OrderDataBean> getSaengSanList() {
		List<OrderDataBean> list = getSqlSession().selectList("order.getSaengSanList");
		return list;
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
	
	public int insertProList(OrderProducts proList) {
		int check = -1;
		check = getSqlSession().insert("order.insertProList", proList);
		return check;
	}
	
	public ProductDataBean getProduct(String pro_num) {
		ProductDataBean pro = getSqlSession().selectOne("order.getProduct", pro_num);
		return pro;
	}
	public int maxOrder() {
		int max = getSqlSession().selectOne("order.maxOrder");
		return max;
	}
	
	public int checkDelivery(int o_ref) {
		int check = -1;
		check = getSqlSession().update("order.checkDelivery", o_ref);
		return check;
	}
	
	public int getNewOrderCount() {
		int count = getSqlSession().selectOne("order.getNewOrderCount", Integer.class);
		return count;
	}
	

}
