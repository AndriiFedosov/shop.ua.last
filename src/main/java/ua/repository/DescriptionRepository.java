package ua.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import ua.entity.Description;

public interface DescriptionRepository extends JpaRepository<Description, Integer>{

    Description findByColor (String color);
    Description findBySize (String size);
    Description findByMaterial (String material);

    Page<Description> findAll(Pageable pageable);

}
