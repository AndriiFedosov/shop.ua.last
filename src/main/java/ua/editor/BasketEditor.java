package ua.editor;

import ua.entity.Basket;
import ua.entity.Production;
import ua.service.BasketService;

import java.beans.PropertyEditorSupport;

/**
 * Created by shink on 28.01.2017.
 */
public class BasketEditor extends PropertyEditorSupport {

    private final BasketService service;

    public BasketEditor(BasketService service) {
        this.service = service;
    }

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        Basket basket = service.findOne(Integer.valueOf(text));
        setValue(basket);
        System.out.println();
    }


}
