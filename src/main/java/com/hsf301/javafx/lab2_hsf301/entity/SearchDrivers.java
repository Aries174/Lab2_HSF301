package com.hsf301.javafx.lab2_hsf301.entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "SearchDrivers")
public class SearchDrivers {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Agent_ID")
    private int agentID;
    @Column(name = "Agent_Name", length = 255)
    private String agentName;
    @Column(name="Status",length = 50)
    private String status;
    @Column(name = "Email",length = 255)
    private String email;
    @Column(name = "Address",length = 255)
    private String address;
    @Column(name = "Register_date")
    private Date registerDate;
    @Column(name = "Account_Balance")
    private double accountBalance;
    @Column(name="Password")
    private String password;

    public int getAgentID() {
        return agentID;
    }

    public void setAgentID(int agentID) {
        this.agentID = agentID;
    }

    public String getAgentName() {
        return agentName;
    }

    public void setAgentName(String agentName) {
        this.agentName = agentName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(Date registerDate) {
        this.registerDate = registerDate;
    }

    public double getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(double accountBalance) {
        this.accountBalance = accountBalance;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
