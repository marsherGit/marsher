package spring.message;

import java.util.Collections;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MsgController {
	private MsgService service;

	@Autowired
	public void setService(MsgService service) {
		this.service = service;
	}

	// receiveMsgList
	@SuppressWarnings("unchecked")  
	@RequestMapping(value = "/message/receiveMsgList")
	public String receiveMsgList(HttpServletRequest request) {
		String pageNum = request.getParameter("pageNum");
		HttpSession session = request.getSession();
		String memId = (String) session.getAttribute("memId");

		if (pageNum == null) {
			pageNum = "1";
		}
		int pageSize = 10;
		int currentPage = Integer.parseInt(pageNum);
		int startRow = (currentPage - 1) * pageSize + 1;
		int endRow = currentPage * pageSize;
		int count = 0;
		int number=0;
		
		List<Object> receiveMsgList = null;
		
		count = service.receiveMsg_count(memId);
		
		if (count > 0) {
			receiveMsgList = service.receiveMsg_list(startRow, endRow);
		} else {
			receiveMsgList = Collections.EMPTY_LIST;			
		}
		number=count-(currentPage-1)*pageSize;//글목록에 표시할 글번호
		
		request.setAttribute("currentPage", new Integer(currentPage));
		request.setAttribute("startRow", new Integer(startRow));
		request.setAttribute("endRow", new Integer(endRow));
		request.setAttribute("count", new Integer(count));
		request.setAttribute("pageSize", new Integer(pageSize));
		request.setAttribute("number", new Integer(number));
		request.setAttribute("memId", memId);
		request.setAttribute("receiveMsgList", receiveMsgList);
		
		return "receiveMsgList"; 
	}

	// sendMsgList
	@SuppressWarnings("unchecked") 
	@RequestMapping(value = "/message/sendMsgList")
	public String sendMsgList(HttpSession session, HttpServletRequest request) {
		String memId = (String) session.getAttribute("memId");
		String pageNum = request.getParameter("pageNum");
 
		if (pageNum == null) {
			pageNum = "1";
		}
		int pageSize = 10;
		int currentPage = Integer.parseInt(pageNum);
		int startRow = (currentPage - 1) * pageSize + 1;
		int endRow = currentPage * pageSize;
		int count = 0;
		int number=0;

	
		List<Object> sendMsgList = null;
		count = service.sendMsg_count(memId);
		
		if (count > 0) {
			sendMsgList = service.sendMsg_list(startRow, endRow);
		} else {
			sendMsgList = Collections.EMPTY_LIST;			
		}	
		number=count-(currentPage-1)*pageSize;//글목록에 표시할 글번호
		
		request.setAttribute("currentPage", new Integer(currentPage));
		request.setAttribute("startRow", new Integer(startRow));
		request.setAttribute("endRow", new Integer(endRow));
		request.setAttribute("count", new Integer(count));
		request.setAttribute("pageSize", new Integer(pageSize));
		request.setAttribute("number", new Integer(number));
		request.setAttribute("sendMsgList", sendMsgList);
		request.setAttribute("memId",memId);
		return "sendMsgList";
	}

	// writeMsgForm
	@RequestMapping("/message/writeMsgForm")
	public String writeMsgForm(@ModelAttribute("message") SendMsg message) {
		return "writeMsgForm";
	}

	// writeMsgPro
	@RequestMapping(value = "/message/writeMsgPro")
	public String writeMsgPro(SendMsg seMessage, HttpServletRequest request) throws Throwable {
		service.inputSeMsg(seMessage);
		int num = service.maxNum();
		System.out.println(num);
		System.out.println(seMessage);
		service.inputReMsg(num);
		return "/writeMsgPro"; 
	}

	// receiveMsgContent
	@RequestMapping(value = "/message/receiveMsgContent", method = RequestMethod.GET)
	public ModelAndView reContents(@RequestParam("num") int num, int pageNum) throws Exception {
		service.updateReCheckDate(num);
		service.updateSeCheckDate(num);
		
		ModelAndView mav = new ModelAndView("receiveMsgContent");
		ReceiveMsg msg = new ReceiveMsg();
		msg = service.getReceiveMsg(num);
		
		mav.addObject("pageNum", new Integer(pageNum));
		mav.addObject("msg", msg);
		return mav;
	}
	
	

	// sendMsgContent
	@RequestMapping(value = "/message/sendMsgContent", method = RequestMethod.GET)
	public ModelAndView seContents(@RequestParam("num") int num, int pageNum) throws Exception {
		ModelAndView mav = new ModelAndView("sendMsgContent");
		SendMsg msg = new SendMsg();
		msg = service.getSendMsg(num);
		mav.addObject("pageNum", new Integer(pageNum));
		mav.addObject("msg", msg);
		return mav;
	}

	// deleteReceive
	@RequestMapping("/message/deleteReceive")
	public String deleteReceive(int num) {
		int check = service.deleteReceive(num);
		return "redirect:/message/receiveMsgList";
	}

	// deleteSend
	@RequestMapping("/message/deleteSend")
	public String deleteSend(int num) {
		int check = service.deleteSend(num);
		return "redirect:/message/sendMsgList";
	}

}
