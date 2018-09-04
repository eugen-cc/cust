package cc.eugen.ph.customer.service;

import java.util.List;

import cc.eugen.ph.customer.model.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepo extends CrudRepository<Customer, String> {
    List<Customer> findAll();
}


