package ua.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import ua.editor.PersonEditor;
import ua.editor.ProductionEditor;
import ua.entity.Basket;
import ua.entity.Person;
import ua.entity.Production;
import ua.service.BasketService;
import ua.service.PersonService;
import ua.service.ProductionService;

/**
 * Created by shink on 30.01.2017.
 */
@Controller
@RequestMapping("/admin/basket")
@SessionAttributes("basket")
public class BasketController {

    @Autowired
    private BasketService service;

    @Autowired
    private ProductionService productionService;

    @Autowired
    private PersonService personService;

    @InitBinder("basket")
    protected void initBinder(WebDataBinder binder){
        binder.registerCustomEditor(Person.class, new PersonEditor(personService));
        binder.registerCustomEditor(Production.class, new ProductionEditor(productionService));
    }

    @ModelAttribute("basket")
    public Basket getForm(){
        return new Basket();
    }

    @GetMapping
    public String show(Model model){
        model.addAttribute("baskets", service.findAll());
        model.addAttribute("persons", personService.findAll());
        model.addAttribute("productions", productionService.findAll());
        return "basket";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable int id){
        service.delete(id);
        return "redirect:/admin/basket";
    }

    @GetMapping("/update/{id}")
    public String update(@PathVariable int id, Model model){
        model.addAttribute("basket", service.findOne(id));
        show(model);
        return "basket";
    }

    @GetMapping("/cancel")
    public String cancel(SessionStatus status){
        status.setComplete();
        return "redirect:/admin/basket";
    }

    @PostMapping
    public String save(@ModelAttribute("basket") Basket entity, SessionStatus status){
        service.save(entity);
        status.setComplete();
        return "redirect:/admin/basket";
    }
}
