package com.procedures.demo.appointment;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.procedures.demo.customer.Customer;
import com.procedures.demo.customer.CustomerRepository;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/appointment")
public class AppointmentController {

    @Autowired
    private AppointmentRepository appointmentRepository;

    @Autowired
    private CustomerRepository customerRepository;
    
    @PostMapping("/add")    
    public ResponseEntity<String> addAppointment(@RequestBody AppointmentDTO body) {
        Customer customer = customerRepository.findById(body.getCustomerId()).orElse(null);
        
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime dt = LocalDateTime.parse(body.getAppointmentDate(), formatter);

        Appointment appointment = new Appointment();
        appointment.setType(body.getType());
        appointment.setAppointmentDate(dt);
        appointment.setCustomer(customer);

        appointmentRepository.save(appointment);

        return new ResponseEntity<>("Saved", HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Optional<Appointment>> getById(@PathVariable("id") Long id) {
        return new ResponseEntity<>(appointmentRepository.findById(id), HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<Iterable<Appointment>> getAllAppointments() {
        return new ResponseEntity<>(appointmentRepository.findAll(), HttpStatus.OK);
    }

    // @GetMapping("/find/date")
    // public ResponseEntity<List<Appointment>> getAllAppointmentsByDate(@RequestParam String dateFilter) {
        
    //     LocalDate localDate = LocalDate.parse(dateFilter);
    //     LocalDateTime initialDate = localDate.atStartOfDay();
    //     LocalDateTime finalDate = initialDate.plusHours(23).plusMinutes(59);


    //     return new ResponseEntity<>(appointmentRepository.findAllByAppointmentDate(initialDate, finalDate), HttpStatus.OK);
    // }
}
