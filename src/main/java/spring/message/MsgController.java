package spring.message;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

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
	@RequestMapping(value = "/message/receiveMsgList")
	public ModelAndView receiveMsgList() {
		List<ReceiveMsg> receiveMsgList = service.receiveMsg_list();
		ModelAndView mav = new ModelAndView("receiveMsgList", "receiveMsgList", receiveMsgList);
		return mav;
	}

	// sendMsgList
	@RequestMapping(value = "/message/sendMsgList")
	public ModelAndView sendMsgList() {
		List<SendMsg> sendMsgList = service.sendMsg_list();
		ModelAndView mav = new ModelAndView("sendMsgList", "sendMsgList", sendMsgList);
		return mav;
	}

	// writeMsgForm
	@RequestMapping("/message/writeMsgForm")
	public String writeMsgForm(@ModelAttribute("message") SendMsg message) {
		return "writeMsgForm";
	}

	// writeMsgPro
	@RequestMapping(value = "/message/writeMsgPro")
	public String writeMsgPro(SendMsg seMessage, ReceiveMsg reMessage, HttpServletRequest request) throws Throwable {
		service.inputSeMsg(seMessage);
		service.inputReMsg(reMessage);
		return "/writeMsgPro";
	}

	// receiveMsgContent
	@RequestMapping(value = "/message/receiveMsgContent", method = RequestMethod.GET)
	public ModelAndView reContents(@RequestParam("re_num") int re_num) throws Exception {
		ModelAndView mav = new ModelAndView("receiveMsgContent");
		ReceiveMsg msg = new ReceiveMsg();
		msg = service.getReceiveMsg(re_num);
		mav.addObject("msg", msg);
		return mav;
	}

	// sendMsgContent
	@RequestMapping(value = "/message/sendMsgContent", method = RequestMethod.GET)
	public ModelAndView seContents(@RequestParam("se_num") int se_num) throws Exception {
		ModelAndView mav = new ModelAndView("sendMsgContent");
		SendMsg msg = new SendMsg();
		msg = service.getSendMsg(se_num);
		mav.addObject("msg", msg);
		return mav;
	}

	// deleteReceive
	@RequestMapping("/message/deleteReceive")
	public String deleteReceive(int re_num) {
		int check = service.deleteReceive(re_num);
		return "redirect:/message/receiveMsgList";
	}

	// deleteSend
	@RequestMapping("/message/deleteSend")
	public String deleteSend(int se_num) {
		int check = service.deleteSend(se_num);
		return "redirect:/message/sendMsgList";
	}

}
