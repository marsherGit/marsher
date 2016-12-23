package mj.Store.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import mj.Store.service.memberDataBean;
import mj.Store.service.memberService;



@Controller
public class memberController {
	
	
	private memberService service;
	

	
	public void setService(memberService service) {
		this.service = service;
	}
	
//매장 등록 폼
	@RequestMapping(value = "/member/register.do")
	public String add(@ModelAttribute("member") memberDataBean member) throws Throwable {
		System.out.println(member);
		return "memberRegister";// 해당 뷰
	}

//매장 등록 Pro
	@RequestMapping(value = "/member/registerPro.do")
	public String addPro(memberDataBean member, HttpServletRequest request) throws Throwable {
		service.insert(member);
		System.out.println(member);
		return "member/memberRegisterPro";
	}
	
	
//매장 찾기 form
	@RequestMapping(value ="member/info.do", method = RequestMethod.GET)
	public String showList(Model model) {
		List<memberDataBean> showList = new ArrayList<memberDataBean>();
		showList=service.showList();
		
		model.addAttribute("showList", showList);
		
		System.out.println(showList);
		
		return "memberInfo";

	}
		
			
}
