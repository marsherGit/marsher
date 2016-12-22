package login.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class LoginController {
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
	
	@RequestMapping("/login/mypage")
	public String mypage() {
		return "mypage";
	}
	
	public void setLoginDao(LoginDao loginDao) {
		this.loginDao = loginDao;
	}
}
