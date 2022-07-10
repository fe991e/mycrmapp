package com.javaproject.crmapp.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.javaproject.crmapp.entity.Customer;
import com.javaproject.crmapp.service.CustomerServ;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	private List<Customer> theCustomers;
	
	private CustomerServ custServ;
//	private List<Customer> theCustomers;
//	@PostConstruct
//	private void loadData() {
//		theCustomers = new ArrayList<>();
//		theCustomers.add(new Customer(1, "Johnny", "Depp", "jd@gmail.com"));
//		theCustomers.add(new Customer(2, "Amber", "Heard", "ah@gmail.com"));
//		theCustomers.add(new Customer(3, "Jamiey", "Lee", "jl@gmail.com"));
//		
//	}
	public CustomerController(CustomerServ custServ) {
		this.custServ = custServ;
	}
	
	@GetMapping("/list")
	public String getCustomers(Model model) {
		theCustomers = custServ.findAll();
		model.addAttribute("customers", theCustomers);
		return "customer/customers-page";
	}

	@PostMapping("/save")
	public String saveCustomer(@ModelAttribute("customer") Customer c) {
		if (c == null) {
			custServ.addCust(c);
		} else {
			custServ.updateCust(c);
		}
		
		return "redirect:/customer/list";
	}
	
	@GetMapping("/form")
	public String showAddUpdateForm(@RequestParam("custId") int id, Model m) {
		Customer newCust;
		if(id == 0) {
			newCust = new Customer();
		} else {
			newCust = custServ.findById(id);
		}
		m.addAttribute("customer", newCust);
		return "/customer/customer-form";
	}
	
	@GetMapping("/update")
	public String updateCustomer(int id) {
		Customer cust = custServ.findById(id);
		custServ.updateCust(cust);
		return "/customer/customers-page";
	}
	
	@GetMapping("/del")
	public String delCustomer(@RequestParam("custId") int id) {
		custServ.deleteCust(id);
		return "redirect:/customer/list";
	}
}
