package cc.eugen.ph.customer.model;

import cc.eugen.ph.customer.model.entity.Customer;
import cc.eugen.ph.customer.model.entity.Note;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NoteRepo extends CrudRepository<Note, Long> {
    List<Note> findNotesByCustomer(Customer c);
}


