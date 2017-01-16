package spring.order;

import java.beans.PropertyEditorSupport;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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

import factory.controller.FactoryCommand;
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

	@ModelAttribute("factorys")
	public List<FactoryCommand> getFactoryList() {
		List<FactoryCommand> factory = new ArrayList<FactoryCommand>();
		factory = service.getFactoryList();

		return factory;
	}

	// manager login-> orderList (show list by o_sender)
	@RequestMapping(value = "/order/orderList", method = RequestMethod.GET)
	public String orderList(@RequestParam("o_sender") String o_sender, HttpSession session, Model model) {

		String memId = (String) session.getAttribute("memId");

		List<OrderDataBean> orderList = new ArrayList<OrderDataBean>();

		orderList = service.getOrderList(memId);

		model.addAttribute("o_sender", memId);
		model.addAttribute("orderList", orderList);

		return "orderList";
	}

	// admin login-> show all orders sent by managers
	@RequestMapping(value = "/order/allOrders", method = RequestMethod.GET)
	public String orderList(HttpSession session, Model model) {

		String memId = (String) session.getAttribute("memId");

		List<OrderDataBean> orderList = new ArrayList<OrderDataBean>();

		orderList = service.getAllOrders();
		model.addAttribute("memId", memId);
		model.addAttribute("orderList", orderList);

		return "orderList";
	}

	// saengSanList: admin login-> show all saengSanList sent by admin
	@RequestMapping(value = "/order/saengSanList", method = RequestMethod.GET)
	public String saengSanList(HttpSession session, Model model) {
		String memId = (String) session.getAttribute("memId");

		List<OrderDataBean> saengSanList = new ArrayList<OrderDataBean>();

		saengSanList = service.getSaengSanList();
		model.addAttribute("memId", memId);
		model.addAttribute("saengSanList", saengSanList);

		return "saengSanList";
	}

	// orderContent
	@RequestMapping(value = "/order/orderContent", method = RequestMethod.GET)
	public String orderContent(@RequestParam("o_ref") int o_ref, Model model) throws Throwable {

		List<OrderProducts> proList = new ArrayList<OrderProducts>();
		OrderDataBean ordering = new OrderDataBean();

		proList = service.getOrderProducts(o_ref);
		ordering = service.getOrder(o_ref);

		model.addAttribute("o_ref", o_ref);
		model.addAttribute("ordering", ordering);
		model.addAttribute("proList", proList);

		return "orderContent";
	}

	/* orderWriteForm.jsp */
	@RequestMapping(value = "/order/orderWriteForm", method = RequestMethod.GET)
	public String orderWriteForm() {
		return "orderWriteForm";
	}

	/* orderWritePro.jsp */
	@RequestMapping(value = "/order/orderWritePro")
	public String orderWritePro(OrderDataBean ordering, String[] pro_name, int[] pro_count) {
		service.insertOrder(ordering, pro_name, pro_count);

		return "orderWriteForm";
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

	/* saengSanWriteForm.jsp */
	@RequestMapping(value = "/order/saengSanWriteForm", method = RequestMethod.GET)
	public String saengSanWriteForm() {
		return "saengSanWriteForm";
	}

	/* saengSanWritePro */
	@RequestMapping(value = "/order/saengSanWritePro")
	public String saengSanWritePro(OrderDataBean ordering, String[] pro_name, int[] pro_count) {
		service.insertOrder(ordering, pro_name, pro_count);

		return "saengSanWriteForm";
	}

	@InitBinder
	public void initBinder(WebDataBinder binder) throws Exception {
		binder.registerCustomEditor(Date.class, new PropertyEditorSupport() {

			public void setAsText(String o_deadline) throws IllegalArgumentException {
				try {
					setValue(new SimpleDateFormat("yyyy-MM-dd").parse(o_deadline));
				} catch (ParseException e) {
					setValue(null);
				}
			}
		});
	}

}
