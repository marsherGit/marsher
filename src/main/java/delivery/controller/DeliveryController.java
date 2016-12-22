package delivery.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DeliveryController {
	@Autowired
	DeliveryDao deliveryDao;
	
	@RequestMapping("/delivery/deliveryInfo")
	public String info() {
		return "deliveryInfo";
	}
	
	@RequestMapping("/delivery/deliveryState")
	public String stateList() {
		return "deliveryState";
	}
	
	@RequestMapping("/delivery/deliveryOrder")
	public String order() {
		return "deliveryOrder";
	}
	
	@RequestMapping("/delivery/deliveryUnsolved")
	public String unsolved() {
		return "deliveryUnsolved";
	}
	
	

	public void setDeliveryDao(DeliveryDao deliveryDao) {
		this.deliveryDao = deliveryDao;
	}
}
