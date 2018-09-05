package cc.eugen.ph.customer.model;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepo extends CrudRepository<Customer, String> {
    List<Customer> findAll();
}


