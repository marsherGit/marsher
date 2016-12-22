package spring.order;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderDAO dao;

	public void setDao(OrderDAO dao) {
		this.dao = dao;
	}

	public List<Object> getOrders(int startRow, int endRow) {
		List<Object> list = null;
		System.out.println(startRow + "    " + endRow);
		try { // city는 mepper파일의 id값에 해당한다.
			list = dao.getOrders(startRow, endRow);
		} catch (Exception e) {

			e.printStackTrace();
		}

		return list;
	}

	public Order getOrder(int o_num) {
		Order list = null;
		System.out.println(o_num);
		try { // city는 mepper파일의 id값에 해당한다.
			list = dao.getOrder(o_num);
		} catch (Exception e) {

			e.printStackTrace();
		}

		return list;
	}

	public int insertOrder(Order order) {
		int check = 0;

		Map<String, Object> map = new HashMap<String, Object>();

		try {
			map.put("o_num", order.getO_num());
			map.put("o_title", order.getO_title());
			map.put("pro_num", order.getPro_num());
			map.put("o_count", order.getO_count());
			map.put("o_deadline", order.getO_deadline());
			map.put("o_regdate", order.getO_regdate());
			map.put("o_sendDate", order.getO_sendDate());
			map.put("o_receiver", order.getO_receiver());
			map.put("o_sender", order.getO_sender());
			map.put("senderSign", order.getSenderSign());
			map.put("receiverSign", order.getReceiverSign());
			check = dao.Insert("order.insert", map); // city는 내가 선택한 도시명
		} catch (Exception e) {
			System.out.println(e.toString());
		}

		return check;

	}

}
