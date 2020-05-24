package com.example.cruddemo.controllers;

import javax.validation.Valid;

import com.example.cruddemo.entities.Customer;
import com.example.cruddemo.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CustomerController {
    
    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerController(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }
    
    @GetMapping("/new")
    public String showSignUpForm(Customer customer) {
        return "add-customer";
    }
    

    @GetMapping("/edit/{id}")
    public String showUpdateForm(@PathVariable("id") long id, Model model) {
        Customer customer = customerRepository.findById(id).get();
        // .orElseThrow(() -> new IllegalArgumentException("Invalid customer Id:" + id));
        model.addAttribute("customer", customer);
        return "update-customer";
    }

    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") long id, Model model) {
        Customer customer = customerRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid customer Id:" + id));
        customerRepository.delete(customer);
        model.addAttribute("customers", customerRepository.findAll());
        return "index";
    }

    @PostMapping("/addcustomer")
    public String addUser(@Valid Customer customer, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "add-customer";
        }

        customerRepository.save(customer);
        model.addAttribute("customers", customerRepository.findAll());

        return "index";
    }

    @PostMapping("/update/{id}")
    public String updateUser(@PathVariable("id") long id, @ModelAttribute Customer customer , BindingResult result, Model model) {
         Customer customerToUpdate = customerRepository.findById(id).get();

         String newemail = customer.getEmail();
         String newName = customer.getName();
         String newSurname = customer.getSurname();
         customerToUpdate.setEmail(newemail);
         customerToUpdate.setName(newName);
         customerToUpdate.setSurname(newSurname);
         customerRepository.save(customerToUpdate);
         model.addAttribute("customers", customerRepository.findAll());
          return "index";
    }

    @GetMapping("/list")
    public String listUser(Model model) {


        model.addAttribute("customers", customerRepository.findAll());
        return "index";
    }

}
