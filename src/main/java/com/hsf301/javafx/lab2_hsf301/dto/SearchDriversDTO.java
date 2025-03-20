package com.hsf301.javafx.lab2_hsf301.dto;

import jakarta.persistence.Column;

import java.util.Date;

public class SearchDriversDTO {
    private int agentID;
    private String agentName;
    private String status;
    private String email;
    private String address;
    private Date registerDate;
    private double accountBalance;
    private String password;

    public SearchDriversDTO() {
    }

    public SearchDriversDTO(int agentID, String agentName, String status, String email, String address, Date registerDate, double accountBalance, String password) {
        this.agentID = agentID;
        this.agentName = agentName;
        this.status = status;
        this.email = email;
        this.address = address;
        this.registerDate = registerDate;
        this.accountBalance = accountBalance;
        this.password = password;
    }

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
