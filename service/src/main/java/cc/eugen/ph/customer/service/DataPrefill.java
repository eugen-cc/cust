package cc.eugen.ph.customer.service;

import cc.eugen.ph.customer.model.CustomerRepo;
import cc.eugen.ph.customer.model.entity.ContactDetails;
import cc.eugen.ph.customer.model.entity.Customer;
import cc.eugen.ph.customer.model.entity.Note;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import static java.util.Arrays.asList;

/**
 * Just for demo
 * inserts some data when application is ready
 */

@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
public class DataPrefill implements ApplicationListener<ApplicationReadyEvent> {

    @Autowired
    private CustomerRepo repo;

    @Override
    public void onApplicationEvent(ApplicationReadyEvent e) {
        repo.save(newCustomer());
    }

    private Customer newCustomer() {
        Customer customer = new Customer();
        customer.setFirstName("Eugen");
        customer.setLastName("Gross");
        customer.setDetails(createContactDetails());
        customer.setStatus(Customer.Status.PROSPECTIVE);
        customer.setNotes(asList(newDescription(customer, "Interesting!"), newDescription(customer, "Some more text!")));
        return customer;
    }

    private Note newDescription(Customer c, String s) {
        Note note = new Note();
        note.setCustomer(c);
        note.setDescription(s);
        return note;
    }

    private ContactDetails createContactDetails() {
        ContactDetails details = new ContactDetails();
        details.setCity("München");
        details.setCountry("Germany");
        details.setEmail("mail@eugen.cc");
        details.setPhone("+4989217541");
        return details;
    }
}
