package cc.eugen.ph.customer.model;

import cc.eugen.ph.customer.model.entity.Customer;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 *  CRUD Repository for Customer - Entities
 */
@Repository
public interface CustomerRepo extends CrudRepository<Customer, Long> {
    List<Customer> findAll();
    List<Customer> findAllByOrderByIdAsc();
    List<Customer> findAllByOrderByFirstNameAsc();
    List<Customer> findAllByOrderByLastNameAsc();
    List<Customer> findAllByOrderByStatusAsc();

    @Query("select c from Customer c where c.firstName like CONCAT('%',:criteria,'%') or c.lastName like CONCAT('%',:criteria,'%') or c.status like CONCAT('%',:criteria,'%')")
    List<Customer> findAllByQuery(@Param("criteria") String criteria);
}


