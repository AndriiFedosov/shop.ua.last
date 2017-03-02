package ua.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import ua.entity.Description;

public interface DescriptionService {
	
	List<Description>findAll();
	
	void delete (int id);
	
	Description findOne(int id);
	
	void save(Description description);

	Description findByColor (String color);

	Description findBySize (String size);

	Description findByMaterial (String material);

	Page<Description> findAll(Pageable pageable);

}
