package com.wellsfargo.portfolio.entities;

import javax.persistence.*;
import java.util.List;

@Entity
public class FinancialAdvisor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long advisorId;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column(nullable = false, unique = true)
    private String email;

    @OneToMany(mappedBy = "advisor", cascade = CascadeType.ALL)
    private List<Client> clients;

    // Default constructor required by JPA
    public FinancialAdvisor() {
    }

    // Constructor initializing all instance variables (except ID)
    public FinancialAdvisor(String firstName, String lastName, String email, List<Client> clients) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.clients = clients;
    }

    // Getters
    public Long getAdvisorId() {
        return advisorId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public List<Client> getClients() {
        return clients;
    }

    // Setters (No setter for advisorId per requirements)
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setClients(List<Client> clients) {
        this.clients = clients;
    }
}