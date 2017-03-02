package ua.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import ua.entity.Category;

public interface CategoryService {
	
	List<Category>findAll();
	
	void delete (int id);
	
	Category findOne(int id);
	
	void save(Category category);

	Page<Category> findAll(Pageable pageable);

	Category findByNameCategory(String nameCategory);

	Category findByModel(String model);

}
