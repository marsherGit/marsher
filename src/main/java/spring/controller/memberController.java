package spring.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import spring.service.memberDataBean;
import spring.service.memberService;


@Controller
public class memberController {
	
	
	private memberService service;
	

	
	public void setService(memberService service) {
		this.service = service;
	}
	

	@RequestMapping(value = "/member/register.do")
	public String add(@ModelAttribute("member") memberDataBean member) throws Throwable {
		return "member/memberRegister";// 해당 뷰
	}

	@RequestMapping(value = "/member/registerPro.do")
	public String addPro(memberDataBean member, HttpServletRequest request) throws Throwable {
		service.insert(member);
		System.out.println(member);
		return "member/memberRegister";
	}
	
	@RequestMapping(value = "member/info.do", method = RequestMethod.GET)
	public String requestPro(@RequestParam("st_id") int st_id, Model model) {

		memberDataBean memberInfo = null;
		memberInfo = service.getMember(st_id);// 해당 글번호에 대한 해당 레코드
		System.out.println(st_id);

		// 해당 뷰에서 사용할 속성
		model.addAttribute("st_id", new Integer(st_id));
		model.addAttribute("member", memberInfo);

		return "member/memberInfo";// 해당 뷰
	}
}
