package com.kingslayer.CustomerRelationshipManagement.controller;

import com.kingslayer.CustomerRelationshipManagement.entity.Customer;
import com.kingslayer.CustomerRelationshipManagement.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/customers")
public class CustomerManagementController {

    @Autowired
    private CustomerService customerService;

    @RequestMapping("/home")
    public String homePage(Model model) {
        listCustomer(model);
        return "home-page";
    }

    @RequestMapping("/listCustomer")
    public void listCustomer(Model model) {
        List<Customer> customers = customerService.findAll();
        model.addAttribute("Customers", customers);
    }

    @RequestMapping("/addCustomer")
    public String addCustomer(Model model) {
        Customer customer = new Customer();
        model.addAttribute("Customer", customer);
        return "customer-form";
    }

    @RequestMapping("/updateCustomer")
    public String updateCustomer(@RequestParam("id") int id, Model model) {
        Customer customer = customerService.findById(id);
        model.addAttribute("Customer", customer);
        return "customer-form";
    }

    @RequestMapping("/deleteCustomer")
    public String deleteCustomer(@RequestParam("id") int id) {
        customerService.deleteById(id);
        return "redirect:/customers/home";
    }

    @RequestMapping ("/saveCustomer")
    public String saveCustomer(Model model, @RequestParam("id") int id,
                               @RequestParam("email") String email,
                              @RequestParam("firstName") String firstName,
                              @RequestParam("lastName") String lastName) {
        Customer customer;
        if (id != 0) {
            customer = customerService.findById(id);
            customer.setFirstName(firstName);
            customer.setLastName(lastName);
            customer.setEmail(email);
        } else {
            customer = new Customer(email, firstName, lastName);
        }
        customerService.saveOrUpdate(customer);
        listCustomer(model);
        return "redirect:/customers/home";
    }
}
