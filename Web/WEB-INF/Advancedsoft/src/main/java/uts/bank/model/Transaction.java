package uts.bank.model;

public class Transaction {
    private int transaction_id;
    private double amount;
    private String owner_email;
    private String payee_email;
    private int account_id;

    public Transaction(int transaction_id, double amount, String owner_email,  String payee_email, int account_id) {
        this.transaction_id = transaction_id;
        this.owner_email = owner_email;
        this.amount = amount;
        this.payee_email = payee_email;
        this.account_id = account_id;
    }

    public int getTransaction_id() {
        return transaction_id;
    }

    public void setTransaction_id(int transaction_id) {
        this.transaction_id = transaction_id;
    }

    public String getOwner_email() {
        return owner_email;
    }

    public void setOwner_email(String owner_email) {
        this.owner_email = owner_email;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getPayee_email() {
        return payee_email;
    }

    public void setPayee_email(String payee_email) {
        this.payee_email = payee_email;
    }

    public int getAccount_id() {
        return account_id;
    }

    public void setAccount_id(int account_id) {
        this.account_id = account_id;
    }
}
