package ua.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import ua.entity.Person;
import ua.service.PersonService;

/**
 * Created by shink on 02.02.2017.
 */
public class PersonValidator implements Validator {

    private final PersonService service;

    public PersonValidator(PersonService service) {
        this.service = service;
    }


    public boolean supports(Class<?> clazz) {
        return Person.class.equals(clazz);
    }


    public void validate(Object target, Errors errors) {
        Person person= (Person) target;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "", "enter email please!");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"passwordUser","","enter password");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"role","","enter role");
        if(service.findByEmail(person.getEmail())!=null){
            errors.rejectValue("email", "", "Already exist");
        }

    }
}
