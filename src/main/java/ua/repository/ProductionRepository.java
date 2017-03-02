package ua.repository;

import com.oracle.deploy.update.UpdateCheck;
import org.hibernate.Session;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ua.entity.Production;

import java.util.List;

/**
 * Created by shink on 28.01.2017.
 */
public interface ProductionRepository extends JpaRepository<Production,Integer> {

    @Query("SELECT a FROM Production a LEFT JOIN FETCH a.category LEFT JOIN FETCH a.description WHERE a.id = ?1")
    Production findOne(int id);

    @Query("SELECT a FROM Production a LEFT JOIN FETCH a.category LEFT JOIN FETCH a.description")
    List<Production> findAll();

//    @Query("update from production set category_id=null ,production_id = null where production.id=?1")
//    Production delete(int id);





}
