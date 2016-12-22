package spring.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class OrderController {
	@Autowired
	private OrderService service;

	public void setService(OrderService service) {
		this.service = service;
	}
	
	@RequestMapping(value = "/orderContent.do", method = RequestMethod.GET)
	public String requestPro(@RequestParam(value="o_num", defaultValue="1") int o_num, Model model) {

		Order orderContent = null;
		orderContent = service.getOrder(o_num);

		model.addAttribute("o_num", new Integer(o_num));
		model.addAttribute("order", orderContent);

		return "orderContent";// ÇØ´ç ºä
	}


	
	@RequestMapping(value="/orderWriteForm.do", method=RequestMethod.GET)
	public String writeOrder(){
		return "order/orderWriteForm";
	}
	
	
	
}
