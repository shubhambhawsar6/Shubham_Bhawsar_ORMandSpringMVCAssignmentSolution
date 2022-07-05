package com.greatlearning.management.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.greatlearning.management.entity.Customer;
import com.greatlearning.management.service.CustomerService;

@Controller
@RequestMapping("/customers")
public class CustomerController {

	@Autowired
	public CustomerService customerService;

	@RequestMapping("/list")
	public String findAll(Model model) {
		List<Customer> customerList = customerService.findAll();
		model.addAttribute("customer", customerList);
		return "Customers";
	}

	@RequestMapping("/save")
	public String save(@RequestParam("id") int id, @RequestParam("firstName") String firstName,
			@RequestParam("lastName") String lastName, @RequestParam("email") String email) {

		Customer customer = null;
		if ((id != -1)) {
			customer = customerService.findByid(id);
			customer.setFirstName(firstName);
			customer.setLastName(lastName);
			customer.setEmail(email);
			
		} else
			customer = new Customer(firstName, lastName, email );
		customerService.save(customer);
		return "redirect:list";
	}

	@RequestMapping("/addCustomer")
	public String addStudent(@RequestParam("id") int id, Model model) {

		if ((id != -1)) {
			Customer customer = customerService.findByid(id);
			model.addAttribute("customer", customer);
		} else {
			Customer customer = new Customer();
			customer.setId(-1);
			model.addAttribute("customer", customer);
		}
		return "CustomerForm";
	}

	@RequestMapping("/deleteCustomer")
	public String delete(@RequestParam("id") int id) {

		Customer customer = null;
		if ((id != -1)) {
			customer = customerService.findByid(id);
			customerService.delete(customer);
		}
		return "redirect:list";
	}

	
	  @RequestMapping("/search") 
	  public String findByfirstName(@RequestParam("firstName")String firstName,Model model) { 
		  List<Customer> custList=customerService.findByfirstName(firstName);
	  System.out.println(custList); 
	  if(custList.size()!=0)
	  model.addAttribute("customer", custList); 
	  else 
		  model.addAttribute("error","No customers Found"); 
	  return "Customers"; 
	  }
}
