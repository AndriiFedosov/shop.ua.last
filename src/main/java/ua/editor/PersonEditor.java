package ua.editor;

import ua.entity.Person;
import ua.service.PersonService;

import java.beans.PropertyEditorSupport;

/**
 * Created by shink on 28.01.2017.
 */
public class PersonEditor extends PropertyEditorSupport {

    private final PersonService service;

    public PersonEditor(PersonService service) {
        this.service = service;
    }


    public void setAsText(String text) throws IllegalArgumentException {
        Person person = service.findOne(Integer.valueOf(text));
        setValue(person);
    }


}
