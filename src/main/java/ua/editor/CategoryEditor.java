package ua.editor;

import ua.entity.Category;
import ua.service.CategoryService;

import java.beans.PropertyEditorSupport;

/**
 * Created by shink on 28.01.2017.
 */
public class CategoryEditor extends PropertyEditorSupport{

    private final CategoryService service;

    public CategoryEditor(CategoryService service) {
        this.service = service;
    }

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        Category category = service.findOne(Integer.valueOf(text));
        setValue(category);
    }
}
