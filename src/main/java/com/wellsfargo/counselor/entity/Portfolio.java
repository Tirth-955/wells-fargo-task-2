package com.wellsfargo.portfolio.entities;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Portfolio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long portfolioId;

    @Column(nullable = false)
    private String accountType;

    @Column(nullable = false)
    private Date dateCreated;

    @OneToOne
    @JoinColumn(name = "client_id", nullable = false)
    private Client client;

    @OneToMany(mappedBy = "portfolio", cascade = CascadeType.ALL)
    private List<Security> securities;

    public Portfolio() {
    }

    public Portfolio(String accountType, Date dateCreated, Client client, List<Security> securities) {
        this.accountType = accountType;
        this.dateCreated = dateCreated;
        this.client = client;
        this.securities = securities;
    }

    public Long getPortfolioId() {
        return portfolioId;
    }

    public String getAccountType() {
        return accountType;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public Client getClient() {
        return client;
    }

    public List<Security> getSecurities() {
        return securities;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public void setSecurities(List<Security> securities) {
        this.securities = securities;
    }
}