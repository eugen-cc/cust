package cc.eugen.ph.customer.model;

import cc.eugen.ph.customer.model.entity.Customer;
import cc.eugen.ph.customer.model.entity.Note;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * CRUD Repository for Note entities
 */
@Repository
public interface NoteRepo extends CrudRepository<Note, Long> {
    
    /**
     * @param c a customer entity
     * @return a list of notes for given customer or an empty list if not found
     */
    List<Note> findNotesByCustomer(Customer c);
}


