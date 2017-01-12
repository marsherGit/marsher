package mj.Notice.controller;

import java.util.ArrayList;
import java.util.Calendar;
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

@Controller
public class NoticeController {
	
	private NoticeService service;
	
	public void setService(NoticeService service) {
		this.service = service;
	}

	// noticeList
	@RequestMapping(value = "notice/noticeList", method = RequestMethod.GET)
	public String noticeList(HttpServletRequest request, HttpServletResponse response) {

		String pageNum = request.getParameter("pageNum");

		if (pageNum == null) {
			pageNum = "1";
		}
		int pageSize = 10;
		int currentPage = Integer.parseInt(pageNum);
		int startRow = (currentPage - 1) * pageSize + 1;
		int endRow = currentPage * pageSize;
		int count = 0;

		List<Object> noticeList = null;

		count = service.noticeListCount();

		if (count > 0) {
			noticeList = service.noticeList(startRow, endRow);
		} else {
			noticeList = Collections.EMPTY_LIST;
		}

		request.setAttribute("currentPage", new Integer(currentPage));
		request.setAttribute("startRow", new Integer(startRow));
		request.setAttribute("endRow", new Integer(endRow));
		request.setAttribute("count", new Integer(count));
		request.setAttribute("pageSize", new Integer(pageSize));
		request.setAttribute("noticeList", noticeList);

		System.out.println(noticeList);

		return "noticeList";

	}

	// noticeWriteForm
	@RequestMapping(value = "notice/noticeWriteForm", method = RequestMethod.GET)
	public String writeForm(@ModelAttribute("notice") NoticeDataBean notice) throws Throwable {
		System.out.println(notice);
		return "noticeWriteForm";
	}

	// noticeWritePro
	@RequestMapping(value = "notice/noticeWritePro")
	public String writePro(NoticeDataBean notice, HttpServletRequest request) throws Throwable {
		service.insert(notice);
		System.out.println(notice);
		return "redirect:/notice/noticeList";
	}

	// noticeContent
	@RequestMapping(value = "notice/noticeContent")
	public String getNotice(String no_num, String calDate, int pageNum, HttpServletRequest request, Model model)
			throws Throwable {

		NoticeDataBean notice = service.getNotice(no_num);

		System.out.println(notice);

		model.addAttribute("no_num", new String(no_num));
		model.addAttribute("calDate", request.getParameter("calendar_date"));
		model.addAttribute("pageNum", new Integer(pageNum));
		model.addAttribute("notice", notice);

		return "noticeContent";
	}

	// noticeUpdateForm
	@RequestMapping(value = "notice/noticeUpdateForm")
	public String getNotice2(String no_num, Model model) throws Throwable {

		NoticeDataBean notice = service.getNotice2(no_num);

		System.out.println(notice);

		model.addAttribute("no_num", new String(no_num));
		model.addAttribute("notice", notice);

		return "noticeUpdateForm";
	}

	// noticeUpdatePro
	@RequestMapping(value = "notice/noticeUpdatePro")
	public String updateNotice(NoticeDataBean notice, String no_num, Model model) throws Throwable {

		int check = service.updateNotice(notice, no_num);

		model.addAttribute("no_num", no_num);
		model.addAttribute("check", check);

		return "notice/noticeUpdatePro";
	}

	// sodaProduct delete
	@RequestMapping(value = "/notice/noticeDeletePro")
	public String deleteNotice(int no_num) throws Throwable {

		int check = service.deleteNotice(no_num);

		return "redirect:/notice/noticeList";

	}
	

}
