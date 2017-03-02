package ua.service;

import java.util.List;

import ua.entity.Basket;

public interface BasketService {
	
	List<Basket>findAll();
	
	void delete (int id);
	
	Basket findOne(int id);
	
	void save(Basket basket);
}
