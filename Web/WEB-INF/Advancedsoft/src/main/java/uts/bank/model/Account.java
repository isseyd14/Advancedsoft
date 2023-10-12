package uts.bank.model;

public class Account {

    private int accountNumber;
    private String accountEmail;
    private String accountName;
    private String accountType;
    private double accountAvailableFunds;
    private double AccountCurrentFunds;


    public Account(int accountNumber, String accountEmail, String accountName, String accountType, double accountAvailableFunds, double accountCurrentFunds) {
        this.accountNumber = accountNumber;
        this.accountEmail = accountEmail;
        this.accountName = accountName;
        this.accountType = accountType;
        this.accountAvailableFunds = accountAvailableFunds;
        AccountCurrentFunds = accountCurrentFunds;
    }

    public int getAccountNumber() {
        return this.accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAccountEmail() {
        return accountEmail;
    }

    public void setAccountEmail(String accountEmail) {
        this.accountEmail = accountEmail;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public double getAccountAvailableFunds() {
        return accountAvailableFunds;
    }

    public void setAccountAvailableFunds(double accountAvailableFunds) {
        this.accountAvailableFunds = accountAvailableFunds;
    }

    public double getAccountCurrentFunds() {
        return AccountCurrentFunds;
    }

    public void setAccountCurrentFunds(double accountCurrentFunds) {
        AccountCurrentFunds = accountCurrentFunds;
    }
}
