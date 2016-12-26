package delivery.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DeliveryController {
	@Autowired
	DeliveryService service;
	
	@RequestMapping("/delivery/deliveryInfo")
	public ModelAndView info() {
		return new ModelAndView("deliveryInfo", "deliveryList", service.allMem());
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
	
	public void setService(DeliveryService service) {
		this.service = service;
	}
}
