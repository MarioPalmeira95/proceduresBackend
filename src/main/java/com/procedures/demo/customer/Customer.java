package com.procedures.demo.customer;

import java.util.List;

import com.procedures.demo.appointment.Appointment;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String lastname;

    @Column(nullable = false)
    private String nickname;

    @Column(name="whatsapp_user", columnDefinition = "boolean default false")
    private Boolean whatsappUser;

    private String observation;

    @OneToMany(mappedBy = "customer")
    private List<Appointment> appointment;

    public Customer(){}

    public Customer(String name, String lastname, String nickname, Boolean whatsappUser, String observation) {
        this.name = name;
        this.lastname = lastname;
        this.nickname = nickname;
        this.whatsappUser = whatsappUser;
        this.observation = observation;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public void setWhatsappUser(Boolean whatsappUser) {
        this.whatsappUser = whatsappUser;
    }

    public void setObservation(String observation) {
        this.observation = observation;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLastname() {
        return lastname;
    }

    public String getNickname() {
        return nickname;
    }

    public Boolean getWhatsappUser() {
        return whatsappUser;
    }

    public String getObservation() {
        return observation;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((lastname == null) ? 0 : lastname.hashCode());
        result = prime * result + ((nickname == null) ? 0 : nickname.hashCode());
        result = prime * result + ((whatsappUser == null) ? 0 : whatsappUser.hashCode());
        result = prime * result + ((observation == null) ? 0 : observation.hashCode());
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
        Customer other = (Customer) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        if (lastname == null) {
            if (other.lastname != null)
                return false;
        } else if (!lastname.equals(other.lastname))
            return false;
        if (nickname == null) {
            if (other.nickname != null)
                return false;
        } else if (!nickname.equals(other.nickname))
            return false;
        if (whatsappUser == null) {
            if (other.whatsappUser != null)
                return false;
        } else if (!whatsappUser.equals(other.whatsappUser))
            return false;
        if (observation == null) {
            if (other.observation != null)
                return false;
        } else if (!observation.equals(other.observation))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Customer [name=" + name + ", lastname=" + lastname + ", nickname=" + nickname + ", whatsappUser="
                + whatsappUser + ", observation=" + observation + "]";
    }
}
