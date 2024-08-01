package com.procedures.demo.customer;

import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    
    @Autowired
    private CustomerRepository customerRepository;

    @RequestMapping("/add")
    public ResponseEntity<String> addCustomer(@RequestBody Customer body) {
        Customer customer = new Customer();    
        customer.setName(body.getName()); 
        customer.setLastname(body.getLastname()); 
        customer.setNickname(body.getNickname()); 
        customer.setWhatsappUser(body.getWhatsappUser()); 
        customer.setObservation(body.getObservation());
        customerRepository.save(customer);
        return new ResponseEntity<>("Saved", HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Optional<Customer>> getById(@PathVariable("id") Long id) {
        return new ResponseEntity<>(customerRepository.findById(id), HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<Iterable<Customer>> getAllCustomer() {
        return new ResponseEntity<>(customerRepository.findAll(), HttpStatus.OK);
    }
}
