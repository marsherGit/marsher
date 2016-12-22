package spring.order;

import java.util.List;

import org.springframework.stereotype.Controller;

@Controller
public interface OrderService {
	public List<Object> getOrders(int startRow, int endRow);
	public Order getOrder(int o_num);
	public int insertOrder(Order order);


}
