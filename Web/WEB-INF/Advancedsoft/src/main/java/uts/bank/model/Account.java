package uts.bank.model;

public class Account {
    private String accountEmail;
    private String accountName;
    private String accountType;
    private double accountAvailableFunds;
    private double AccountCurrentFunds;


    public Account(String accountEmail, String accountName, String accountType, double accountAvailableFunds, double accountCurrentFunds) {
        this.accountEmail = accountEmail;
        this.accountName = accountName;
        this.accountType = accountType;
        this.accountAvailableFunds = accountAvailableFunds;
        AccountCurrentFunds = accountCurrentFunds;
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
