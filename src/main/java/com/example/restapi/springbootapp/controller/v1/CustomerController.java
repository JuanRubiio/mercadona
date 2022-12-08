package com.example.restapi.springbootapp.controller.v1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.restapi.springbootapp.dto.Customer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {

    private static Map<Integer, Customer> customers = new HashMap<>();

    @PostMapping("/customer")
    public String addCustomer(@RequestBody Customer customer) {
        customers.put(customer.getId(), customer);
        return "Cliente agregado correctamente.";
    }

    @GetMapping("/customer")
    public List<Customer> getCustomers() {
        return new ArrayList<Customer>(customers.values());
    }

}