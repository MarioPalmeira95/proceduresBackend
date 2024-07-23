package com.procedures.demo.customer;

public class CustomerDTO {
    private String name;
    private String lastname;
    private String nickname;
    private Boolean whatsappUser;
    private String observation;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getLastname() {
        return lastname;
    }
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
    public String getNickname() {
        return nickname;
    }
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
    public Boolean getWhatsappUser() {
        return whatsappUser;
    }
    public void setWhatsappUser(Boolean whatsappUser) {
        this.whatsappUser = whatsappUser;
    }
    public String getObservation() {
        return observation;
    }
    public void setObservation(String observation) {
        this.observation = observation;
    }

    public Customer toCustomer() {
        return new Customer(name, lastname, nickname, whatsappUser, observation);
    }
}
