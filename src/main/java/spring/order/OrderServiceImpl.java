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
	public List<FactoryCommand> getFactoryList() {
		List<FactoryCommand> list = new ArrayList<FactoryCommand>();
		list = dao.getFactoryList();
		return list;
	}

	public List<OrderDataBean> getOrderList(String o_sender) {
		List<OrderDataBean> list = new ArrayList<OrderDataBean>();
		list = dao.getOrderList(o_sender);
		return list;
	}
	public List<OrderDataBean> getAllOrders(){
		List<OrderDataBean> list = new ArrayList<OrderDataBean>();
		list = dao.getAllOrders();
		return list;
	}
	public List<OrderDataBean> getSaengSanList() {
		List<OrderDataBean> list = dao.getSaengSanList();
		return list;
	}

	public int getOrderCount() {
		return dao.getOrderCount();
	}

	public OrderDataBean getOrder(int o_ref) throws Exception {
		return dao.getOrder(o_ref);
	}

	public List<OrderProducts> getOrderProducts(int o_ref) {
		List<OrderProducts> proList = dao.getOrderProducts(o_ref);
		return proList;
	}

	public int getProCount() {
		return dao.getProCount();
	}

	public int insertOrder(OrderDataBean ordering, String[] pro_name, int[] pro_count){
		String first_pro = dao.getProduct(pro_name[0]).getPro_name();
		String o_title = first_pro + " 외 " + pro_name.length + "개 발주서";
		ordering.setO_title(o_title);
		int check = dao.insertOrder(ordering);
		System.out.println("dao:"+ordering);
		int currunt_ref = dao.maxOrder();
		
		for(int i=0; i<pro_name.length; i++) {
			OrderProducts opro = new OrderProducts();
			ProductDataBean pro = new ProductDataBean();
			if(pro_name[i] != null || !("".equals(pro_name[i]))){
				pro = dao.getProduct(pro_name[i]);
				opro.setO_ref(currunt_ref);
				opro.setO_reStep(i+1);
				opro.setPro_count(pro_count[i]);
				opro.setPro_name(pro.getPro_name());
				opro.setPro_container(pro.getPro_container());
				opro.setPro_volume(pro.getPro_volume());
			}
			System.out.println(opro);
			int check2 = dao.insertProList(opro);
		}
		return 0;
	}
	
	public int checkDelivery(int o_ref){
		int check = dao.checkDelivery(o_ref);
		return 0;
	}
	

}
