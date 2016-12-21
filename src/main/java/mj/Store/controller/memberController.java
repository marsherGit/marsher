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
	

	@RequestMapping(value = "/member/register.do")
	public String add(@ModelAttribute("member") memberDataBean member) throws Throwable {
		System.out.println(member);
		return "memberRegister";// �ش� ��
	}

	@RequestMapping(value = "/member/registerPro.do")
	public String addPro(memberDataBean member, HttpServletRequest request) throws Throwable {
		service.insert(member);
		System.out.println(member);
		return "member/memberRegisterPro";
	}
	
	@RequestMapping(value = "member/info.do", method = RequestMethod.GET)
	public String requestPro(@RequestParam("st_id") String st_id, Model model) {

		memberDataBean memberInfo = null;
		memberInfo = service.getMember(st_id);
		System.out.println(st_id);

		// �ش� �信�� ����� �Ӽ�
		model.addAttribute("st_id", new String(st_id));
		model.addAttribute("member", memberInfo);

		return "memberInfo";// �ش� ��
	}
	
	/*//�������� ���� form ������ (����)
	@RequestMapping(value = "/member/updateForm.do", method = RequestMethod.GET)
	public String update(String st_id, HttpServletRequest request, Model model) throws Throwable {
		
		
		String Id = (String)request.getSession().getAttribute("st_id");
		
		memberDataBean memberInfo = null;
		 memberInfo = service.getMember(Id);
		 System.out.println("����������:::" + Id);

		// �ش� �信�� ����� �Ӽ�
		 model.addAttribute("st_id", new String(Id));
		 model.addAttribute("member", memberInfo);

		return "memberUpdate";// �ش��
	}*/

	//�������� ���� form ������(�ӽ�)
		@RequestMapping(value = "/member/updateForm.do", method = RequestMethod.GET)
		public String update(String st_id, HttpServletRequest request, Model model) throws Throwable {
			
				
			memberDataBean memberInfo = null;
			 memberInfo = service.getMember2(st_id);
			 System.out.println("����������:::" + st_id);

			// �ش� �信�� ����� �Ӽ�
			 model.addAttribute("st_id", new String(st_id));
			 model.addAttribute("member", memberInfo);

			return "memberUpdate";// �ش��
		}
	

	
	
	//���� ���� ���� Pro
@RequestMapping(value = "/member/updatePro.do")
	public String updatePro(memberDataBean member, String st_id, Model model) throws Throwable {
		
	int check = service.updateMember(member, st_id);

		model.addAttribute("st_id", st_id);
		model.addAttribute("check", check);

		return "member/memberUpdatePro";
	}
	
	
}
