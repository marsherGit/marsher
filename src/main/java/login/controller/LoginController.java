package login.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import delivery.controller.DeliveryCommand;
import delivery.controller.DeliveryInfo;
import factory.controller.FactoryCommand;
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
	
	@ModelAttribute("factorys")
	public List<Integer> factory(){
		List<Integer> list = new ArrayList<Integer>();
		int total = service.totalFactory();
		for(int i=1; i<total+1; i++) {
			list.add(i);
		}
		return list;
	}
	
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
	
	// deliveryList
	@RequestMapping("/login/admin_deliveryList")
	public ModelAndView deliveryList() {
		List<DeliveryInfo> delivery_list = service.getDeliveryList();
		ModelAndView mav = new ModelAndView("admin_deliveryList","delivery_list",delivery_list);
		
		return mav;
	}
	
	// deliveryUpdateForm
	@RequestMapping(value = "/login/admin_deliveryUpdateForm")
	public ModelAndView deliveryUpdateForm(@ModelAttribute("command") DeliveryCommand command, int delivery_num) {
		ModelAndView mav = new ModelAndView("admin_deliveryUpdate");
		command = service.getDelivery(delivery_num);
		mav.addObject("command", command);
		
		return mav;
	}
	// deliveryUpdate
	@RequestMapping(value = "/login/admin_deliveryUpdate")
	public String deliveryUpdate(@ModelAttribute("command") DeliveryCommand command) {
		int check = service.updateDelivery(command);
		
		return "redirect:/login/admin_deliveryList";
	}
	
	// deliveryInputForm
	@RequestMapping("/login/admin_deliveryInputForm")
	public String deliveryInputForm(@ModelAttribute("command") DeliveryCommand command) {
		return "admin_deliveryInput";
	}
	
	// deliveryInput
	@RequestMapping("/login/admin_deliveryInput")
	public String deliveryInput(@ModelAttribute("command") DeliveryCommand command, HttpServletRequest request) {
		int check = service.inputDelivery(command);
		return "redirect:/login/admin_deliveryList";
	}
	
	// deliveryDelete
	@RequestMapping("/login/admin_deliveryDelete")
	public String deliveryDelete(int delivery_num) {
		int check = service.deleteDelivery(delivery_num);
		return "redirect:/login/admin_deliveryList";
	}
	
	// factoryList
	@RequestMapping("/login/admin_factoryList")
	public ModelAndView factoryList() {
		List<FactoryCommand> factory_list = service.getFactoryList();
		ModelAndView mav = new ModelAndView("admin_factoryList","factory_list",factory_list);
		
		return mav;
	}
	
	// factoryUpdateForm
	@RequestMapping(value = "/login/admin_factoryUpdateForm")
	public ModelAndView factoryUpdateForm(@ModelAttribute("command") FactoryCommand command, int fac_id) {
		ModelAndView mav = new ModelAndView("admin_factoryUpdate");
		command = service.getFactory(fac_id);
		mav.addObject("command", command);
		
		return mav;
	}
	
	// factoryUpdate
	@RequestMapping(value = "/login/admin_factoryUpdate")
	public String factoryUpdate(@ModelAttribute("command") FactoryCommand command) {
		int check = service.updateFactory(command);
		
		return "redirect:/login/admin_factoryList";
	}
	
	// factoryDelete
	@RequestMapping("/login/admin_factoryDelete")
	public String factoryDelete(int fac_id) {
		int check = service.deleteFactory(fac_id);
		return "redirect:/login/admin_factoryList";
	}

}
