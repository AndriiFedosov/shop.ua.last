package ua.validator;


        import org.springframework.validation.Errors;
        import org.springframework.validation.ValidationUtils;
        import org.springframework.validation.Validator;
        import ua.entity.Description;
        import ua.service.DescriptionService;


public class DescriptionValidator implements Validator {

    private final DescriptionService service;

    public DescriptionValidator(DescriptionService service) {
        this.service = service;
    }


    public boolean supports(Class<?> clazz) {
        return Description.class.equals(clazz);
    }


    public void validate(Object target, Errors errors) {
        Description entity = (Description) target;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "color", "", "enter color please!");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "size", "", "enter size please!");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "material", "", "enter material please!");
        if(service.findByColor(entity.getColor())!=null&&service.findBySize(entity.getSize())!=null&&
                service.findByMaterial(entity.getMaterial())!=null){
            errors.rejectValue("color","","This description already exist!");
        }

    }
}
