package uts.bank.model;

public class Contact {
    private String ownerEmail;
    private String contactName;
    private String contactEmail;
    private String ContactNicName;
    private int contactId;

    private int accountNumber;

    // constructor for contact
    public Contact(String ownerEmail, String contactName,  String contactNicName,String contactEmail, int accountNumber) {
        this.ownerEmail = ownerEmail;
        this.contactName = contactName;
        this.contactEmail = contactEmail;
        ContactNicName = contactNicName;
        this.accountNumber = accountNumber;
    }


    //getters and setters for contact
    public String getOwnerEmail() {
        return ownerEmail;
    }

    public void setOwnerEmail(String ownerEmail) {
        this.ownerEmail = ownerEmail;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getContactEmail() {
        return contactEmail;
    }

    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }

    public String getContactNicName() {
        return ContactNicName;
    }

    public void setContactNicName(String contactNicName) {
        ContactNicName = contactNicName;
    }

    public int getContactId() {
        return contactId;
    }

    public void setContactId(int contactId) {
        this.contactId = contactId;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }
}
