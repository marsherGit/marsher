package factory.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class FactoryController {
	@Autowired
	FactoryService service;
	
	// factoryInfo
	@RequestMapping("/factory/factoryInfo")
	public ModelAndView info() {
		return new ModelAndView("factoryInfo", "factoryList", service.allFactory());
	}
	
	// factoryInputForm
	@RequestMapping("/factory/factoryInputForm")
	public String factoryInputForm(@ModelAttribute("command") FactoryCommand command) {
		return "factoryInput";
	}
	
	// factoryInput
	@RequestMapping("/factory/factoryInput")
	public String factoryInput(@ModelAttribute("command") FactoryCommand command, HttpServletRequest request) {
		int check = service.inputFactory(command);
		return "redirect:/factory/factoryInfo";
	}
		
	public void setService(FactoryService service) {
		this.service = service;
	}
}
