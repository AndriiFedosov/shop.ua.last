package ua.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import ua.entity.Description;
import ua.repository.DescriptionRepository;
import ua.service.DescriptionService;

@Service
public class DescriptionServiceImpl implements DescriptionService{
	
	@Autowired
	private DescriptionRepository descriptionRepository;
	
	public List<Description> findAll() {
		return descriptionRepository.findAll();
	}

	public void delete(int id) {
		descriptionRepository.delete(id);
	}

	public Description findOne(int id) {
		return descriptionRepository.findOne(id);
	}

	public void save(Description description) {
		descriptionRepository.save(description);
		
	}

	@Override
	public Description findByColor(String color) {
		return descriptionRepository.findByColor(color);
	}

	@Override
	public Description findBySize(String size) {
		return descriptionRepository.findBySize(size);
	}

	@Override
	public Description findByMaterial(String material) {
		return descriptionRepository.findByMaterial(material);
	}

	@Override
	public Page<Description> findAll(Pageable pageable) {
		return descriptionRepository.findAll(pageable);
	}

}
