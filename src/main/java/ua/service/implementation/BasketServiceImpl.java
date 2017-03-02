package ua.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.entity.Basket;
import ua.repository.BasketRepository;
import ua.service.BasketService;

@Service
public class BasketServiceImpl implements BasketService{
	
	@Autowired
	private BasketRepository basketRepository;
	public List<Basket> findAll() {
		return basketRepository.findAll();
	}
	
	public void delete(int id) {
		basketRepository.delete(id);
	}

	public Basket findOne(int id) {
		return basketRepository.findOne(id);
	}

	public void save(Basket basket) {
		basketRepository.save(basket);
	}
	
}
