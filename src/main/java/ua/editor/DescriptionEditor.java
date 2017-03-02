package ua.editor;

import ua.entity.Description;
import ua.service.DescriptionService;

import java.beans.PropertyEditorSupport;

/**
 * Created by shink on 28.01.2017.
 */
public class DescriptionEditor extends PropertyEditorSupport {

    private final DescriptionService service;

    public DescriptionEditor(DescriptionService service) {
        this.service = service;
    }

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        Description description = service.findOne(Integer.valueOf(text));
        setValue(description);
    }
}
