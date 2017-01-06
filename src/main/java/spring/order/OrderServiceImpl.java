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
		try { // city�� mepper������ id���� �ش��Ѵ�.
			list = dao.getOrders(startRow, endRow);
		} catch (Exception e) {

			e.printStackTrace();
		}

		return list;
	}

	public OrderDataBean getOrder(int o_num) {
		OrderDataBean list = null;
		System.out.println(o_num);
		try { // city�� mepper������ id���� �ش��Ѵ�.
			list = dao.getOrder(o_num);
		} catch (Exception e) {

			e.printStackTrace();
		}

		return list;
	}

	public int insertOrder(OrderDataBean order) {
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
			check = dao.Insert("order.insert", map); // city�� ���� ������ ���ø�
		} catch (Exception e) {
			System.out.println(e.toString());
		}

		return check;

	}

}
