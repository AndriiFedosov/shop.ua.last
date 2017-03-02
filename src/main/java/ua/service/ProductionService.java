package ua.service;

import java.util.List;
import ua.entity.Production;

public interface ProductionService {
	
	List<Production>findAll();
	
	void delete (int id);
	
	Production findOne(int id);
	
	void save(Production production);

}
