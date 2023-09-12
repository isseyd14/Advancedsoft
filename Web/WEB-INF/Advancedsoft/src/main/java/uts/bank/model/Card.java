package uts.bank.model;

import java.io.Serializable;

public class Card implements Serializable{

    private String cardNumber;
    private String cardHolder;
    private String expiryDate;
    private String CVV;
    private String cardType;
    private String cardStatus;
    private String customerId;
    private String accountId;
    private double balance;
    private String pin;
    

    public Card(){}

    public Card(String cardNumber, String cardHolder, String expiryDate, String CVV, String cardType, String cardStatus, String customerId, String accountId, double balance, String pin) { 
        this.cardNumber = cardNumber;
        this.cardHolder = cardHolder;
        this.expiryDate = expiryDate;
        this.CVV = CVV;
        this.cardType = cardType;
        this.cardStatus = cardStatus;
        this.customerId = customerId;
        this.accountId = accountId;
        this.balance = balance;
        this.pin = pin;
        
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public String getCardHolder() {
        return cardHolder;
    }

    public String getExpiryDate() {
        return expiryDate;
    }

    public String getCVV() {
        return CVV;
    }

    public String getCardType() {
        return cardType;
    }

    public String getCardStatus() {
        return cardStatus;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public void setCardHolder(String cardHolder) {
        this.cardHolder = cardHolder;
    }

    public void setExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate;
    }

    public void setCVV(String CVV) {
        this.CVV = CVV;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    public void setCardStatus(String cardStatus) {
        this.cardStatus = cardStatus;
    }


    public String getAccountId() {
        return accountId;
    }

    public double getBalance() {
        return balance;
    }

    public String getPin() {
        return pin;
    }
    

}

   
    
    