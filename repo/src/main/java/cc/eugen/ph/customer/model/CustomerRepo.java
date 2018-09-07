package cc.eugen.ph.customer.model;

import java.util.List;

import cc.eugen.ph.customer.model.entity.Customer;
import cc.eugen.ph.customer.model.entity.Note;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepo extends CrudRepository<Customer, Long> {
    List<Customer> findAll();
    //Customer findCustomerByNoteAndId(Note n);
}


