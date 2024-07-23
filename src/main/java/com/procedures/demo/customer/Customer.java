package com.procedures.demo.customer;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String lastname;
    private String nickname;
    private Boolean whatsappUser;
    private String observation;

    public Customer(){}
    
    public Customer(String name, String lastname, String nickname, Boolean whatsappUser, String observation){}

    public void setId(Integer id) {
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


    public Integer getId() {
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
