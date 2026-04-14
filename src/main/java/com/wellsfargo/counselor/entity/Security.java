package com.wellsfargo.portfolio.entities;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
public class Security {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long securityId;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String category;

    @Column(nullable = false)
    private Date purchaseDate;

    @Column(nullable = false, precision = 19, scale = 4)
    private BigDecimal purchasePrice;

    @Column(nullable = false)
    private Integer quantity;

    @ManyToOne
    @JoinColumn(name = "portfolio_id", nullable = false)
    private Portfolio portfolio;

    public Security() {
    }

    public Security(String name, String category, Date purchaseDate, BigDecimal purchasePrice, Integer quantity, Portfolio portfolio) {
        this.name = name;
        this.category = category;
        this.purchaseDate = purchaseDate;
        this.purchasePrice = purchasePrice;
        this.quantity = quantity;
        this.portfolio = portfolio;
    }

    public Long getSecurityId() {
        return securityId;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public Date getPurchaseDate() {
        return purchaseDate;
    }

    public BigDecimal getPurchasePrice() {
        return purchasePrice;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public Portfolio getPortfolio() {
        return portfolio;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setPurchaseDate(Date purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public void setPurchasePrice(BigDecimal purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public void setPortfolio(Portfolio portfolio) {
        this.portfolio = portfolio;
    }
}