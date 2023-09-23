package uts.bank.model;

import java.util.Date;

public class User {
    private String Email;
    private String Pass;
    private String Type;
    private String fname;
    private String lname;
    private String Address;
    private double Balance;
    private Date DOB;

    public User(String email, String pass, String type, String fname, String lname, String address, double balance, Date DOB) {
        Email = email;
        Pass = pass;
        Type = type;
        this.fname = fname;
        this.lname = lname;
        Address = address;
        Balance = balance;
        this.DOB = DOB;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPass() {
        return Pass;
    }

    public void setPass(String pass) {
        Pass = pass;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public double getBalance() {
        return Balance;
    }

    public void setBalance(double balance) {
        Balance = balance;
    }

    public Date getDOB() {
        return DOB;
    }

    public void setDOB(Date DOB) {
        this.DOB = DOB;
    }
}
