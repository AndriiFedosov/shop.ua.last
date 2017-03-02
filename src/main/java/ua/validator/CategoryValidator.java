package ua.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import ua.entity.Category;
import ua.service.CategoryService;

import static ua.entity.Production_.category;

public class CategoryValidator implements Validator {

    private final CategoryService service;

    public CategoryValidator(CategoryService service) {
        this.service = service;
    }


    public boolean supports(Class<?> clazz) {
        return Category.class.equals(clazz);
    }


    public void validate(Object target, Errors errors) {
        Category entity = (Category) target;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nameCategory", "", "enter category please!");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "model", "", "enter model");
        if(service.findByNameCategory(entity.getNameCategory())!=null&&service.findByModel(entity.getModel())!=null) {
            errors.rejectValue("nameCategory","","This description of category and model already exist!");

        }



    }
}