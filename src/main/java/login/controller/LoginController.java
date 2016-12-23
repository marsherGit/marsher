package login.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import mj.Store.service.memberDataBean;


@Controller
public class LoginController {
	
	@Autowired
	private LoginService service;
	
	public void setService(LoginService service) {
		this.service = service;
	}

	@Autowired
	LoginDao loginDao;
	
	@RequestMapping("/login/login")
	public String form() {
		return "loginForm";
	}
	
	@RequestMapping(value="/login/main", method=RequestMethod.GET)
	public String loginback() {
		return "main";
	}
	@RequestMapping(value="/login/main", method=RequestMethod.POST)
	public String submit(String st_id, String passwd, HttpSession session) {
		String dbpasswd = "";
		dbpasswd = loginDao.getArticle(st_id);
		if(!passwd.equals(dbpasswd)) {
			return "loginForm";
		}
		session.setAttribute("passwd", dbpasswd);
		session.setAttribute("memId", st_id);
		return "main";
	}
	
	@RequestMapping("/login/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
	
	@RequestMapping("/login/adminpage")
	public String adminpage() {
		return "adminpage";
	}
	

	public void setLoginDao(LoginDao loginDao) {
		this.loginDao = loginDao;
	}
	
	
	// �������� ���� form ������ (����)
	@RequestMapping(value = "/login/mypage", method = RequestMethod.GET)
	public String update(String st_id, HttpSession session, Model model) throws Throwable {

		String memId = (String) session.getAttribute("memId");

		memberDataBean memberInfo = null;
		memberInfo = service.getMember2(memId);
		System.out.println("����������:::" + memId);

		// �ش� �信�� ����� �Ӽ�
		model.addAttribute("st_id", memId);
		model.addAttribute("member", memberInfo);

		return "mypage";// �ش��
	}

	// ���� �Ŵ��� ���� ���� ���� Pro
	@RequestMapping(value = "/login/mypagePro.do")
	public String updatePro(memberDataBean member, String st_id, Model model) throws Throwable {

		int check = service.updateMember(member, st_id);

		model.addAttribute("st_id", st_id);
		model.addAttribute("check", check);

		return "mypagePro";
	}
	
	// ������ ���� ���� form ������ (����)
	@RequestMapping(value = "/login/adminpage", method = RequestMethod.GET)
	public String update2(String st_id, HttpSession session, Model model) throws Throwable {

		String memId = (String) session.getAttribute("memId");

		memberDataBean memberInfo = null;
		memberInfo = service.getMember2(memId);
		System.out.println("����������:::" + memId);

		// �ش� �信�� ����� �Ӽ�
		model.addAttribute("st_id", memId);
		model.addAttribute("member", memberInfo);

		return "adminpage";// �ش��
	}
	
	// ������ ���� ���� Pro
		@RequestMapping(value = "/login/AdminpagePro.do")
		public String updatePro2(memberDataBean member, String st_id, Model model) throws Throwable {

			int check = service.updateMember(member, st_id);

			model.addAttribute("st_id", st_id);
			model.addAttribute("check", check);

			return "adminpagePro";
		}
	
	
	// ������ �������� ���� List ������
	@RequestMapping(value = "/login/AdminUpdateList.do", method = RequestMethod.GET)
	public String showList3(Model model) {
		List<memberDataBean> showList = new ArrayList<memberDataBean>();
		showList = service.showList();

		model.addAttribute("showList", showList);

		System.out.println(showList);

		return "Admin_memberList";// �ش��

	}

	// ������ �������� ���� form ������(�ӽ�)
	@RequestMapping(value = "/login/AdminUpdateForm.do", method = RequestMethod.GET)
	public String AdminUpdate(String st_id, Model model) {

		memberDataBean memberInfo = null;
		memberInfo = service.getMember2(st_id);
		System.out.println("����������:::" + st_id);

		// �ش� �信�� ����� �Ӽ�
		model.addAttribute("st_id", new String(st_id));
		model.addAttribute("member", memberInfo);

		return "Admin_memberUpdate";// �ش��

	}

	// ������ �������� ���� Pro
	@RequestMapping(value = "/login/AdminUpdatePro.do")
	public String AdminUpdatePro(memberDataBean member, String st_id, Model model) throws Throwable {

		int check = service.updateMember(member, st_id);

		model.addAttribute("st_id", st_id);
		model.addAttribute("check", check);

		return "Admin_memberUpdatePro";
	}

}
