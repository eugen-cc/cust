package cc.eugen.ph.customer.service.controller;

import java.util.Optional;

import cc.eugen.ph.customer.model.CustomerRepo;
import cc.eugen.ph.customer.model.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

@Controller
public class CustomerController {

    @Autowired
    private CustomerRepo repo;

    @GetMapping(value = "/customer/all")
    public String customerList(Model model) {
        model.addAttribute("customerList", repo.findAll());
        return "list";
    }

    @GetMapping(value = "/customer/{id}")
    public String findCustomer(Model model, @PathVariable(name = "id", required = false) Long id) {

        Optional<Customer> customer = repo.findById(id);
        model.addAttribute("customer", customer.orElse(new Customer()));

        return "edit";
    }

    @PutMapping(value = "/customer/update")
    public String updateCustomer(Model model, Customer customer) {
        Customer saved;
        if(customer.getId() == null) {
            saved = repo.save(customer);
        } else {

            Customer byId = repo.findById(customer.getId()).get();
            customer.setNotes(byId.getNotes()); //TODO
            saved = repo.save(customer);
        }
        model.addAttribute("customer", saved);
        return "edit";
    }

}
