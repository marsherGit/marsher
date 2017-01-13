package spring.order;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import mj.Product.controller.ProductDataBean;
import spring.message.MsgService;
import spring.message.ReceiveMsg;
import spring.message.SendMsg;

@Controller
public class OrderController {

	private OrderService service;

	@Autowired
	public void setService(OrderService service) {
		this.service = service;
	}

	ModelAndView mav = null;
	
	@ModelAttribute("products")
	public List<ProductDataBean> getProductList() {
		List<ProductDataBean> pro = new ArrayList<ProductDataBean>();
		pro = service.getProductList();
		
		return pro;
	}

	@RequestMapping(value = "/order/orderList")
	public ModelAndView orderList() {
		List<OrderDataBean> orderList = service.getOrderList();
		ModelAndView mav = new ModelAndView("orderList", "orderList", orderList);
		return mav;
	}

	/* orderContent.jsp */
	@RequestMapping(value = "/order/orderContent", method = RequestMethod.GET)
	public String contents(@RequestParam("o_ref") int o_ref, Model model) throws Throwable {

		List<OrderProducts> proList = null;
		OrderDataBean ordering = new OrderDataBean();

	    proList = service.getOrderProducts(o_ref); 
		ordering = service.getOrder(o_ref);

		model.addAttribute("o_ref", o_ref);
		model.addAttribute("ordering", ordering);
		model.addAttribute("proList", proList);

		return "orderContent";
	}

	// orderWriteForm
	@RequestMapping("/order/orderWriteForm")
	public String orderWriteForm(@ModelAttribute("ordering") OrderDataBean ordering, @ModelAttribute("proList") OrderProducts proList) {
		return "orderWriteForm";
	}

	// orderWritePro
	@RequestMapping(value = "/order/orderWritePro")
	public String orderWritePro(OrderDataBean ordering, List<OrderProducts> proList, HttpServletRequest request) throws Throwable {
		
		service.insertOrder(ordering);
	
		return "/orderWritePro";
	}
	
	
	/* saengSan */
	@RequestMapping(value = "/order/saengSanList")
	public ModelAndView saengSanList() {
		List<OrderDataBean> orderList = service.getOrderList();
		ModelAndView mav = new ModelAndView("orderList", "orderList", orderList);
		return mav;
	}

	
	@RequestMapping(value = "/order/saengSanContent", method = RequestMethod.GET)
	public String saengSancontents(@RequestParam("o_ref") int o_ref, Model model) throws Throwable {

		List<OrderProducts> proList = null;
		OrderDataBean ordering = new OrderDataBean();

	    proList = service.getOrderProducts(o_ref); 
		ordering = service.getOrder(o_ref);

		model.addAttribute("o_ref", new Integer(o_ref));
		model.addAttribute("ordering", ordering);
		model.addAttribute("proList", proList);

		return "saengSanContent";
	}

	
	@RequestMapping("/order/saengSanWriteForm")
	public String saengSanWriteForm(@ModelAttribute("ordering") OrderDataBean ordering, @ModelAttribute("proList") OrderProducts proList) {
		return "saengSanWriteForm";
	}


	@RequestMapping(value = "/order/saengSanWritePro")
	public String saengSanWritePro(OrderDataBean ordering, OrderProducts proList, HttpServletRequest request) throws Throwable {
		service.insertOrder(ordering);
		return "/saengSanWritePro";
	}
	
	



	
}
