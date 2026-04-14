package com.wellsfargo.portfolio.entities;

import javax.persistence.*;

@Entity
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long clientId;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column(nullable = false, unique = true)
    private String email;

    @ManyToOne
    @JoinColumn(name = "advisor_id", nullable = false)
    private FinancialAdvisor advisor;

    @OneToOne(mappedBy = "client", cascade = CascadeType.ALL)
    private Portfolio portfolio;

    public Client() {
    }

    public Client(String firstName, String lastName, String email, FinancialAdvisor advisor, Portfolio portfolio) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.advisor = advisor;
        this.portfolio = portfolio;
    }

    public Long getClientId() {
        return clientId;
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

    public FinancialAdvisor getAdvisor() {
        return advisor;
    }

    public Portfolio getPortfolio() {
        return portfolio;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAdvisor(FinancialAdvisor advisor) {
        this.advisor = advisor;
    }

    public void setPortfolio(Portfolio portfolio) {
        this.portfolio = portfolio;
    }
}