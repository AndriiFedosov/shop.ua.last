package ua.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ua.entity.Category;
public interface CategoryRepository extends JpaRepository<Category, Integer>{

    Category findByNameCategory(String nameCategory);

    Category findByModel(String model);



}
