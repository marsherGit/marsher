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
import mj.Notice.controller.NoticeDataBean;
import mj.Store.service.memberDataBean;


@Controller
public class LoginController {
	
	@Autowired
	private LoginService service;
	
	public void setService(LoginService service) {
		this.service = service;
	}

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
	public String loginback(Model model) {
		List<NoticeDataBean> calNoticeList = new ArrayList<NoticeDataBean>();
		calNoticeList = service.calNoticeList();	
		
		model.addAttribute("calNoticeList", calNoticeList);
		
		return "main";
	}
	@RequestMapping(value="/login/main", method=RequestMethod.POST)
	public ModelAndView submit(String st_id, String passwd, String logintype, HttpSession session) {
		List<NoticeDataBean> calNoticeList = new ArrayList<NoticeDataBean>();
		calNoticeList = service.calNoticeList();		
		
		
		/**
		 * check = -1 	:: 아이디 불일치 
		 * check =  0  	:: 비밀번호 불일치
		 * check =  1	:: 타입 불일치 (ex: 매장아이디로 관리자모드 체크할 경우)
		 * check =  2	:: type,id,passwd 모두 일치
		 */
		int check = -1;
		String dbpasswd = "";
		String dbtype = "";
		ModelAndView mav = new ModelAndView("loginForm");
		
		dbpasswd = service.getPasswd(st_id); //id가 없다면 'null'저장됨.
		// id 일치
		if(dbpasswd != null) {
			// 비번 불일치
			if(!passwd.equals(dbpasswd)) { 
				check = 0;
			} else {
				check = 1;
				// type비교
				dbtype = service.getLogintype(st_id);
				// id,비번,type 일치
				if(logintype.equals(dbtype)) {
					session.setAttribute("passwd", dbpasswd);
					session.setAttribute("memId", st_id);
					session.setAttribute("logintype", logintype);
					check = 2;
					mav.setViewName("main");
				}
			}
		}
		
		// id 불일치
		mav.addObject("check", check);
		mav.addObject("st_id", st_id);
		mav.addObject("calNoticeList", calNoticeList);
		return mav;
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
	
	
	// 
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
	
	//Admin_memberDelte
	@RequestMapping(value = "/login/AdminDeletePro.do")
	public String AdminDeletePro(String st_id) throws Throwable {
		
		int check = service.deleteMember(st_id);
		
		return "Admin_memberDelete";
	
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
	public String deliveryUpdate(@ModelAttribute("command") DeliveryCommand command, HttpServletRequest request) {
		HttpSession session = request.getSession();
		String contextRoot = session.getServletContext().getRealPath("/"); //컨텍스트루트 구하기.
		int check = service.updateDelivery(command, contextRoot);
		
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
		HttpSession session = request.getSession();
		String contextRoot = session.getServletContext().getRealPath("/"); //컨텍스트루트 구하기.
		System.out.println("input넘어온 값 : " + command);		//test code
		int check = service.inputDelivery(command, contextRoot);
		
		return "redirect:/login/admin_deliveryList";
	}
	
	// deliveryDelete
	@RequestMapping("/login/admin_deliveryDelete")
	public String deliveryDelete(int delivery_num, HttpServletRequest request) {
		HttpSession session = request.getSession();
		String contextRoot = session.getServletContext().getRealPath("/"); //컨텍스트루트 구하기.
		int check = service.deleteDelivery(delivery_num, contextRoot);
		
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
	public String factoryUpdate(@ModelAttribute("command") FactoryCommand command, HttpServletRequest request) {
		HttpSession session = request.getSession();
		String contextRoot = session.getServletContext().getRealPath("/"); //컨텍스트루트 구하기.
		System.out.println("넘어온 값 : " + command);		//test code
		int check = service.updateFactory(command,contextRoot);
		
		return "redirect:/login/admin_factoryList";
	}

	// factoryDelete
	@RequestMapping("/login/admin_factoryDelete")
	public String factoryDelete(int fac_id, HttpServletRequest request) {
		HttpSession session = request.getSession();
		String contextRoot = session.getServletContext().getRealPath("/"); //컨텍스트루트 구하기.
		int check = service.deleteFactory(fac_id,contextRoot);
		
		return "redirect:/login/admin_factoryList";
	}

	// calendarView
	@RequestMapping(value = "login/calendarView")
	public String getNotice(String calendar_date, HttpServletRequest request, Model model) throws Throwable {

		NoticeDataBean notice = service.getNotice3(calendar_date);

		System.out.println(notice);

		model.addAttribute("calendar_date", calendar_date);
		model.addAttribute("notice", notice);

		return "calendarView"; // (in notice folder!)
	}

}
