package cc.eugen.ph.customer.service.controller;

import cc.eugen.ph.customer.model.CustomerRepo;
import cc.eugen.ph.customer.model.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.Optional;

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
    public String findCustomer(Model model, @PathVariable(name = "id") Long id) {

        Optional<Customer> customer = repo.findById(id);
        model.addAttribute("customer", customer.get());

        return "edit";
    }

    @PutMapping(value = "/customer/update")
    public String updateCustomer(Model model, Customer customer) {
        Customer byId = repo.findById(customer.getId()).get();
        customer.setNotes(byId.getNotes());
        customer.setCreated(byId.getCreated());
        Customer saved = repo.save(customer);
        model.addAttribute("customer", saved);
        return "edit";
    }

}
