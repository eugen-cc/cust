package cc.eugen.ph.customer.service.controller;

import cc.eugen.ph.customer.model.CustomerRepo;
import cc.eugen.ph.customer.model.NoteRepo;
import cc.eugen.ph.customer.model.entity.Customer;
import cc.eugen.ph.customer.model.entity.Note;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class CustomerController {

    private static final String CUSTOMER_OVERVIEW = "list";
    private static final String EDIT_CUSTOMER = "edit";
    private static final String EDIT_NOTE = "note";

    @Autowired
    private CustomerRepo customerRepo;

    @Autowired
    private NoteRepo noteRepo;

    /**
     * a redirect to the correct entry point
     */
    @GetMapping("/")
    public String start() {
        return "redirect:/customer/list";
    }

    @GetMapping(value = "/customer/list")
    public String customerList(Model model, @RequestParam(value = "sort", required = false) String sortBy) {
        List<Customer> customerList;
        if (sortBy != null) {
            switch (sortBy.toUpperCase()) {
                case "FIRSTNAME":
                    customerList = customerRepo.findAllByOrderByFirstNameAsc();
                    break;
                case "LASTNAME":
                    customerList = customerRepo.findAllByOrderByLastNameAsc();
                    break;
                case "STATUS":
                    customerList = customerRepo.findAllByOrderByStatusAsc();
                    break;
                default:
                    customerList = customerRepo.findAllByOrderByIdAsc();
                    break;
            }
        } else {
            customerList = customerRepo.findAll();
        }

        model.addAttribute("customerList", customerList);
        return CUSTOMER_OVERVIEW;
    }

    @PostMapping(value = "/customer/find")
    public String findCustomers(Model model, @RequestParam String search) {
        if (search != null) {
            model.addAttribute("customerList", customerRepo.findAllByQuery(search));
        }
        return CUSTOMER_OVERVIEW;
    }

    @GetMapping(value = "/customer/{id}")
    public String findCustomer(Model model, @PathVariable(name = "id") Long id) {
        model.addAttribute("customer", customerRepo.findById(id).orElse(new Customer()));
        return EDIT_CUSTOMER;
    }

    @PostMapping(value = "/customer/add")
    public String findCustomer(Model model) {
        model.addAttribute("customer", new Customer());
        return EDIT_CUSTOMER;
    }

    @GetMapping(value = "/note/{id}")
    public String findCustomerNote(Model model, @PathVariable(name = "id") Long id) {
        model.addAttribute("note", noteRepo.findById(id).orElse(new Note()));
        return EDIT_NOTE;
    }

    @PutMapping(value = "/note/update")
    public String updateNote(Model model, Note note) {
        Note updated = noteRepo.save(note);
        model.addAttribute("customer", updated.getCustomer());
        return EDIT_CUSTOMER;
    }

    @PutMapping(value = "/customer/update")
    public String updateCustomer(Model model, Customer customer) {
        Customer updated = customerRepo.save(customer);
        updated.setNotes(noteRepo.findNotesByCustomer(updated));
        model.addAttribute("customer", updated);
        return EDIT_CUSTOMER;
    }

    @PostMapping(value = "/note/add")
    public String addEmptyNote(Model model, Customer customer) {
        Note note = new Note();
        note.setCustomer(customer);
        model.addAttribute("note", note);
        return EDIT_NOTE;
    }
}
