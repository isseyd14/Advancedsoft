package uts.bank.Controller;
import uts.bank.model.DAO.AdminDAO;
import uts.bank.model.Account;
import uts.bank.model.Transaction;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.*;
import java.sql.*;

public class TestDB {

    private AdminDAO adminDAO;
    private Connection conn;
    public TestDB() {
        this.adminDAO = new AdminDAO();

    }

    public void testCases() throws SQLException {
        testDeleteAccounts();
        testFindUser();
        testFindAccounts();
        testUpdateAccount();
        testGetTransactionsByEmail();
    }

    public void testFindUser() {
        String email = "test";
        try {
            adminDAO.findUser(email);
            System.out.println("Test Passed User Found");
        } catch (SQLException ex) {
            Logger.getLogger(TestDB.class.getName()).log(Level.SEVERE, null, ex);

        }
    }

    public void testFindAccounts() {
        String email = "test";
        try {
            ArrayList<Account> accounts = adminDAO.findAccounts(email);

            for (Account account : accounts) {
                System.out.println("Account Number: " + account.getAccountNumber());
                System.out.println("Account Name: " + account.getAccountName());
                System.out.println("Current Funds: " + account.getAccountCurrentFunds());
                System.out.println("Available Funds: " + account.getAccountAvailableFunds());
                System.out.println();
            }
            System.out.println("Accounts Found");
        } catch (SQLException ex) {
            Logger.getLogger(TestDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void testDeleteAccounts() throws SQLException {
        int accountNumber = 11110004;
        adminDAO.deleteAccount(accountNumber);
        System.out.println("Account Successfully deleted");
    }

    public void testGetAccount(int accountNumber) throws SQLException {

        Account account = adminDAO.getAccount(accountNumber);

        System.out.println("Account_id: " + accountNumber);
        System.out.println("Email: " + account.getAccountEmail());
        System.out.println("Name: " + account.getAccountName());
        System.out.println("Type: " + account.getAccountType());
        System.out.println("Available Funds: " + account.getAccountAvailableFunds());
        System.out.println("Current Funds: " + account.getAccountCurrentFunds());
        System.out.println("Account Successfully Found");
    }

    public void testUpdateAccount() throws SQLException {
        int accountNumber = 11110281;
        String name = "Investments";
        double availableFunds = 400.00;

        adminDAO.updateAccount(accountNumber, name, availableFunds);

        testGetAccount(11110281);
    }

    public void testGetTransactionsByEmail() throws SQLException {
        String email = "test";
        ArrayList<Transaction> transactions = adminDAO.getTransactionsByEmail(email);

        for (Transaction transaction : transactions) {
            System.out.println("TransactionId: " + transaction.getTransaction_id());
            System.out.println("Amount: " + transaction.getAmount());
            System.out.println("Owner Email: " + transaction.getOwner_email());
            System.out.println("Payee Email: " + transaction.getPayee_email());
            System.out.println("Owner Account Id: " + transaction.getAccount_id());
            System.out.println("Payee Account Id: " + transaction.getPayee_accountid());
            System.out.println();
        }


    }


    public static void main(String[] args) throws SQLException {
        new TestDB().testCases();

    }
}
