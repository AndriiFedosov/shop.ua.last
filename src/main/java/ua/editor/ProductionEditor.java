package ua.editor;

import ua.entity.Production;
import ua.service.ProductionService;

import java.beans.PropertyEditorSupport;

/**
 * Created by shink on 28.01.2017.
 */
public class ProductionEditor extends PropertyEditorSupport {

    private final ProductionService service;

    public ProductionEditor(ProductionService service) {
        this.service = service;
    }

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        Production production = service.findOne(Integer.valueOf(text));
        setValue(production);
    }
}
