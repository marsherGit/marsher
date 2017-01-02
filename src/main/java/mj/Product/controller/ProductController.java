package mj.Product.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import mj.Store.service.memberDataBean;
@Controller
public class ProductController {
	
	ProductService service;

	public void setService(ProductService service) {
		this.service = service;
	}

	@RequestMapping("/product/authorityCheck")
	public String authorityCheck(HttpSession session) {
		return "authorityCheck";
	}

	
// product Register Form
	@RequestMapping(value = "/product/proRegister")
	public String add(@ModelAttribute("product") ProductDataBean product) throws Throwable {
		System.out.println(product);
		return "proRegister";
	}

	// product Register Pro
	@RequestMapping(value = "/product/proRegisterPro")
	public String addPro(ProductDataBean product, HttpServletRequest request) throws Throwable {
		service.insert(product);
		System.out.println(product);
		return "product/proRegisterPro";
	}

	
	// soda Product form
	@SuppressWarnings("unchecked") 
	@RequestMapping(value = "product/productSoda", method = RequestMethod.GET)
	public String sodaList(HttpServletRequest request, HttpServletResponse response) throws Throwable {

		String pageNum = request.getParameter("pageNum");

		if (pageNum == null) {
			pageNum = "1";
		}
		int pageSize = 8;
		int currentPage = Integer.parseInt(pageNum);
		int startRow = (currentPage - 1) * pageSize + 1;
		int endRow = currentPage * pageSize;
		int count = 0;

		List<Object> sodaList = null;

		count = service.sodaListCount();

		if (count > 0) {
			sodaList = service.sodaList(startRow, endRow);
		} else {
			sodaList = Collections.EMPTY_LIST;
		}

		request.setAttribute("currentPage", new Integer(currentPage));
		request.setAttribute("startRow", new Integer(startRow));
		request.setAttribute("endRow", new Integer(endRow));
		request.setAttribute("count", new Integer(count));
		request.setAttribute("pageSize", new Integer(pageSize));
		request.setAttribute("sodaList", sodaList);

		return "productSoda";

	}

	// drink Product form
	@SuppressWarnings("unchecked") 
	@RequestMapping(value = "product/productDrink", method = RequestMethod.GET)
	public String drinkList(HttpServletRequest request, HttpServletResponse response) throws Throwable {

		String pageNum = request.getParameter("pageNum");

		if (pageNum == null) {
			pageNum = "1";
		}
		int pageSize = 8;
		int currentPage = Integer.parseInt(pageNum);
		int startRow = (currentPage - 1) * pageSize + 1;
		int endRow = currentPage * pageSize;
		int count = 0;

		List<Object> drinkList = null;

		count = service.drinkListCount();

		if (count > 0) {
			drinkList = service.drinkList(startRow, endRow);
		} else {
			drinkList = Collections.EMPTY_LIST;
		}

		request.setAttribute("currentPage", new Integer(currentPage));
		request.setAttribute("startRow", new Integer(startRow));
		request.setAttribute("endRow", new Integer(endRow));
		request.setAttribute("count", new Integer(count));
		request.setAttribute("pageSize", new Integer(pageSize));
		request.setAttribute("drinkList", drinkList);

		return "productDrink";

	}

	// juice Product form
	@SuppressWarnings("unchecked") 
	@RequestMapping(value = "product/productJuice", method = RequestMethod.GET)
	public String juiceList(HttpServletRequest request, HttpServletResponse response) throws Throwable {

		String pageNum = request.getParameter("pageNum");

		if (pageNum == null) {
			pageNum = "1";
		}
		int pageSize = 8;
		int currentPage = Integer.parseInt(pageNum);
		int startRow = (currentPage - 1) * pageSize + 1;
		int endRow = currentPage * pageSize;
		int count = 0;

		List<Object> juiceList = null;

		count = service.juiceListCount();

		if (count > 0) {
			juiceList = service.juiceList(startRow, endRow);
		} else {
			juiceList = Collections.EMPTY_LIST;
		}

		request.setAttribute("currentPage", new Integer(currentPage));
		request.setAttribute("startRow", new Integer(startRow));
		request.setAttribute("endRow", new Integer(endRow));
		request.setAttribute("count", new Integer(count));
		request.setAttribute("pageSize", new Integer(pageSize));
		request.setAttribute("juiceList", juiceList);

		return "productJuice";

	}

	// milk Product form
	@SuppressWarnings("unchecked") 
	@RequestMapping(value = "product/productMilk", method = RequestMethod.GET)
	public String milkList(HttpServletRequest request, HttpServletResponse response) throws Throwable {

		String pageNum = request.getParameter("pageNum");// 페이지 번호

		if (pageNum == null) {
			pageNum = "1";
		}
		int pageSize = 8;
		int currentPage = Integer.parseInt(pageNum);
		int startRow = (currentPage - 1) * pageSize + 1;
		int endRow = currentPage * pageSize;
		int count = 0;

		List<Object> milkList = null;

		count = service.milkListCount();

		if (count > 0) {
			milkList = service.milkList(startRow, endRow);
		} else {
			milkList = Collections.EMPTY_LIST;
		}

		request.setAttribute("currentPage", new Integer(currentPage));
		request.setAttribute("startRow", new Integer(startRow));
		request.setAttribute("endRow", new Integer(endRow));
		request.setAttribute("count", new Integer(count));
		request.setAttribute("pageSize", new Integer(pageSize));
		request.setAttribute("milkList", milkList);

		return "productMilk";

	}

}
