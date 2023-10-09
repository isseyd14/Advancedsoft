package uts.bank.model;

import java.io.Serializable;
import java.util.Date;

public class user implements Serializable {
    private String email;
    private String fname;
    private String lname;
    private String password;
    private String type;
    private Date dob;
    private String phone;
    private String address; // Add an address field

    public user(String email, String fname, String lname, String password, String type, Date dob, String phone, String address) {
        this.email = email;
        this.fname = fname;
        this.lname = lname;
        this.password = password;
        this.type = type;
        this.dob = dob;
        this.phone = phone;
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}