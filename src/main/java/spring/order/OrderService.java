package spring.order;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;

import factory.controller.FactoryCommand;
import mj.Product.controller.ProductDataBean;

@Controller
public interface OrderService {
	public List<ProductDataBean> getProductList();
	public List<FactoryCommand> getFactoryList();
	
	
	public List<OrderDataBean> getOrderList(String o_sender);
	public List<OrderDataBean> getAllOrders();
	public List<OrderDataBean> getSaengSanList();
	
	public int getOrderCount();
	public OrderDataBean getOrder(int o_ref) throws Exception;
	public List<OrderProducts> getOrderProducts(int o_ref);
	public int getProCount();
	
	public int insertOrder(OrderDataBean ordering, String[] pro_name, int[] pro_count);
	/*public void insertProList(Integer o_reStep, List<OrderProducts> proList);*/
	
}
