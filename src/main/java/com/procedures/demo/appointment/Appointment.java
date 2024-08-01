package com.procedures.demo.appointment;

import java.time.LocalDateTime;

import org.springframework.format.annotation.DateTimeFormat;

import com.procedures.demo.customer.Customer;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Appointment {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @Column(nullable=false)
    private String type;

    @DateTimeFormat(pattern = "yyyy-MM-ddThh:mm:ss")
    @Column(nullable=false, name="appointment_date")
    private LocalDateTime appointmentDate;

    @ManyToOne
    @JoinColumn(name="customer_id")
    private Customer customer;

    public Appointment() {
    }   

    public Appointment(Long id, String type, LocalDateTime appointmentDate, Customer customer) {
        this.id = id;
        this.type = type;
        this.appointmentDate = appointmentDate;
        this.customer = customer;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public LocalDateTime getAppointmentDate() {
        return appointmentDate;
    }

    public void setAppointmentDate(LocalDateTime appointmentDate) {
        this.appointmentDate = appointmentDate;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((type == null) ? 0 : type.hashCode());
        result = prime * result + ((appointmentDate == null) ? 0 : appointmentDate.hashCode());
        result = prime * result + ((customer == null) ? 0 : customer.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Appointment other = (Appointment) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (type == null) {
            if (other.type != null)
                return false;
        } else if (!type.equals(other.type))
            return false;
        if (appointmentDate == null) {
            if (other.appointmentDate != null)
                return false;
        } else if (!appointmentDate.equals(other.appointmentDate))
            return false;
        if (customer == null) {
            if (other.customer != null)
                return false;
        } else if (!customer.equals(other.customer))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Appointment [id=" + id + ", type=" + type + ", appointmentDate=" + appointmentDate + ", customer="
                + customer.getName() +" "+ customer.getLastname() + "]";
    }
}
