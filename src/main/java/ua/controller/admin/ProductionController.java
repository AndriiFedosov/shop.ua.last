package ua.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import ua.editor.CategoryEditor;
import ua.editor.DescriptionEditor;
import ua.entity.Category;
import ua.entity.Description;
import ua.entity.Production;
import ua.service.CategoryService;
import ua.service.DescriptionService;
import ua.service.ProductionService;

/**
 * Created by shink on 28.01.2017.
 */

@Controller
@RequestMapping("/admin/production")
@SessionAttributes("production")
public class ProductionController {

    @Autowired
    private ProductionService service;

    @Autowired
    private DescriptionService descriptionService;

    @Autowired
    private CategoryService categoryService;

    @InitBinder("production")
    protected void initBinder(WebDataBinder binder){
        binder.registerCustomEditor(Category.class, new CategoryEditor(categoryService));
        binder.registerCustomEditor(Description.class, new DescriptionEditor(descriptionService));
    }

    @ModelAttribute("production")
    public Production getForm(){
        return new Production();
    }

    @GetMapping
    public String show(Model model){
        model.addAttribute("productions", service.findAll());
        model.addAttribute("categories", categoryService.findAll());
        model.addAttribute("descriptions", descriptionService.findAll());
        return "production";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable int id){
        service.delete(id);
        return "redirect:/admin/production";
    }

    @GetMapping("/update/{id}")
    public String update(@PathVariable int id, Model model){
        model.addAttribute("production", service.findOne(id));
        show(model);
        return "production";
    }

    @GetMapping("/cancel")
    public String cancel(SessionStatus status){
        status.setComplete();
        return "redirect:/admin/production";
    }

    @PostMapping
    public String save(@ModelAttribute("production") Production entity, SessionStatus status){
        service.save(entity);
        status.setComplete();
        return "redirect:/admin/production";
    }
}
