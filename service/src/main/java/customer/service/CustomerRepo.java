package customer.service;

import customer.model.Customer;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CustomerRepo extends CrudRepository<Customer, String> {
    List<Customer> findAll();
}


