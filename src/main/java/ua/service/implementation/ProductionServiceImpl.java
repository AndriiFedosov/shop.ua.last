package ua.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.entity.Production;
import ua.repository.ProductionRepository;
import ua.service.ProductionService;

@Service
public class ProductionServiceImpl implements ProductionService{
	
	@Autowired
	private ProductionRepository productionRepository;

	
	public List<Production> findAll() {
		return productionRepository.findAll();
	}

	public void delete(int id) {
		productionRepository.delete(id);
	}

	public Production findOne(int id) {
		return productionRepository.findOne(id);
	}

	public void save(Production production) {
		productionRepository.save(production);
	}

}
