package delivery.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import mj.Product.controller.ProductDataBean;
import mj.Store.service.memberDataBean;
import spring.order.OrderDataBean;

@Controller
public class DeliveryController {
	@Autowired
	DeliveryService service;
	
	@ModelAttribute("products")
	public List<ProductDataBean> getProductList() {
		List<ProductDataBean> pro = new ArrayList<ProductDataBean>();
		pro = service.getProductList();
		
		return pro;
	}
	@ModelAttribute("stores")
	public List<memberDataBean> getStoreList() {
		List<memberDataBean> st = new ArrayList<memberDataBean>();
		st = service.getStoreList();
		
		return st;
	}
	
	@RequestMapping("/delivery/deliveryInfo")
	public ModelAndView info() {
		return new ModelAndView("deliveryInfo", "deliveryList", service.allMem());
	}
	
	@RequestMapping("/delivery/deliveryState")
	public String stateList(String pageNum, String searchText, @RequestParam(defaultValue="0") String productSelect, @RequestParam(defaultValue="0") String storeSelect, @RequestParam(defaultValue="0") int daySelect, Model model) throws Throwable {

		if (pageNum == null) {
			pageNum = "1";
		}
		int pageSize = 10;
		int currentPage = Integer.parseInt(pageNum);
		int startRow = (currentPage - 1) * pageSize + 1;
		int endRow = currentPage * pageSize;
		int count = 0;
		int number = 0;

		List<OrderDataBean> articleList = null;

		count = service.getArticleCount(searchText, productSelect, storeSelect, daySelect);

		if (count > 0) {
			articleList = service.getArticles(startRow, endRow, searchText, productSelect, storeSelect, daySelect);
		} else {
			articleList = Collections.emptyList();
		}
		number = count - (currentPage - 1) * pageSize;
		
		model.addAttribute("currentPage", new Integer(currentPage));
		model.addAttribute("startRow", new Integer(startRow));
		model.addAttribute("endRow", new Integer(endRow));
		model.addAttribute("count", new Integer(count));
		model.addAttribute("pageSize", new Integer(pageSize));
		model.addAttribute("number", new Integer(number));
		model.addAttribute("articleList", articleList);
		
		return "deliveryState";
	}
	
	@RequestMapping("/delivery/deliveryOrder")
	public String order() {
		return "deliveryOrder";
	}
	
	@RequestMapping("/delivery/deliveryUnsolved")
	public String unsolved(String pageNum, String searchText, @RequestParam(defaultValue="0") String productSelect, @RequestParam(defaultValue="0") String storeSelect, @RequestParam(defaultValue="0") int daySelect, Model model) throws Throwable {

		if (pageNum == null) {
			pageNum = "1";
		}
		int pageSize = 10;
		int currentPage = Integer.parseInt(pageNum);
		int startRow = (currentPage - 1) * pageSize + 1;
		int endRow = currentPage * pageSize;
		int count = 0;
		int number = 0;

		List<OrderDataBean> articleList = null;

		count = service.getArticleCount(searchText, productSelect, storeSelect, daySelect);

		if (count > 0) {
			articleList = service.getArticles(startRow, endRow, searchText, productSelect, storeSelect, daySelect);
		} else {
			articleList = Collections.emptyList();
		}
		number = count - (currentPage - 1) * pageSize;
		
		model.addAttribute("currentPage", new Integer(currentPage));
		model.addAttribute("startRow", new Integer(startRow));
		model.addAttribute("endRow", new Integer(endRow));
		model.addAttribute("count", new Integer(count));
		model.addAttribute("pageSize", new Integer(pageSize));
		model.addAttribute("number", new Integer(number));
		model.addAttribute("articleList", articleList);
		
		return "deliveryUnsolved";
	}
	
	public void setService(DeliveryService service) {
		this.service = service;
	}
}
