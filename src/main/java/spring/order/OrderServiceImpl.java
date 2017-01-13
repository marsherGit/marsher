package spring.order;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;

import factory.controller.FactoryCommand;
import mj.Product.controller.ProductDataBean;
import spring.message.ReceiveMsg;

@Controller
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderDAO dao;

	public void setDao(OrderDAO dao) {
		this.dao = dao;
	}
/*
	@Transactional
	public void insertProList(Integer o_reStep, List<OrderProducts> proList){
		dao.insertProList(o_reStep, proList);
	}*/
	
	public List<ProductDataBean> getProductList() {
		List<ProductDataBean> list = new ArrayList<ProductDataBean>();
		list = dao.getProductList();
		return list;
	}

	// ���ּ� ���
	public List<OrderDataBean> getOrderList() {
		List<OrderDataBean> orderList = dao.getOrderList();
		return orderList;
	}

	// ���ּ� ��
	public int getOrderCount() {
		return dao.getOrderCount();
	}

	// ordering ���̺� �ִ� ����(ModelAndView)
	public OrderDataBean getOrder(int o_ref) throws Exception {
		return dao.getOrder(o_ref);
	}

	// orderingPro ���̺� �ִ� ����
	public List<OrderProducts> getOrderProducts(int o_ref) {
		List<OrderProducts> proList = dao.getOrderProducts(o_ref);
		return proList;
	}

	// ������ǰ ��
	public int getProCount() {
		return dao.getProCount();
	}

	public int insertOrder(OrderDataBean ordering) {
		int check = dao.insertOrder(ordering);
		return 0;

	}

}
