package ua.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import ua.entity.Person;
import ua.service.PersonService;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Controller
public class IndexController {

	@RequestMapping("/")
	public String index(){
		return "index";
	}

	@Autowired
	private PersonService userService;


	@RequestMapping("/admin")
	public String admin(){
		return "admin";
	}

	@RequestMapping("/login")
	public String login(){
		return "login";
	}

	@RequestMapping("/registration")
	public String registration(Model model){
		model.addAttribute("userForm", new Person());
		return "registration";
	}

	@RequestMapping(value="/registration", method=POST)
	public String registration(@ModelAttribute Person user){
		userService.save(user);
		return "redirect:/login";
	}

}
