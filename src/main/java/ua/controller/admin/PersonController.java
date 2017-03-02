package ua.controller.admin;
import static ua.util.ParamBuilder.buildParams;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import ua.entity.Person;
import ua.service.PersonService;
import ua.validator.PersonValidator;

@Controller
@RequestMapping("/admin/person")
@SessionAttributes("person")
public class PersonController {

	@Autowired
	private PersonService service;

	@ModelAttribute("person")
	public Person getForm(){
		return new Person();
	}

	@InitBinder("person")
	protected void initBinder(WebDataBinder binder){
		binder.setValidator(new PersonValidator(service));
	}

	@GetMapping
	public String show(Model model, @PageableDefault Pageable pageable){
		model.addAttribute("persons", service.findAll(pageable));
		return "person";
	}

	@GetMapping("/delete/{id}")
	public String delete(@PathVariable int id, @PageableDefault Pageable pageable){
		service.delete(id);
		return "redirect:/admin/person"+buildParams(pageable);
	}

	@GetMapping("/update/{id}")
	public String update(@PathVariable int id, Model model, @PageableDefault Pageable pageable){
		model.addAttribute("person", service.findOne(id));
		show(model, pageable);
		return "person";
	}

	@GetMapping("/cancel")
	public String cancel(SessionStatus status, @PageableDefault Pageable pageable){
		status.setComplete();
		return "redirect:/admin/person"+buildParams(pageable);
	}

	@PostMapping
	public String save(@ModelAttribute("person") @Valid Person entity, BindingResult br, SessionStatus status, @PageableDefault Pageable pageable, Model model){
		if(br.hasErrors()){
			show(model, pageable);
			return "person";
		}
		service.save(entity);
		status.setComplete();
		return "redirect:/admin/person"+buildParams(pageable);
	}
}

