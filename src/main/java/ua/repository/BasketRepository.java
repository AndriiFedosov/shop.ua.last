package ua.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import ua.entity.Basket;

import java.util.List;

public interface BasketRepository extends JpaRepository<Basket, Integer> {

//    @Query("select email,role,production,dataship,is_deleted from basket  join person on email=person.email" +
//            " and role= person.role join production on production=production.id where basket.id=?1")
//    Basket findOne(int id);
//
//    @Query("select email,role,production,dataship,is_deleted from basket  join person on email=person.email" +
//            " and role= person.role join production on production=production.id")
//    List<Basket>findAll();
}
