package cc.eugen.ph.customer.model;

import cc.eugen.ph.customer.model.entity.Customer;
import org.springframework.data.repository.CrudRepository;
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
}


