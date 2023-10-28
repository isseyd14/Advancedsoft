package uts.bank.model.DAO;

import uts.bank.model.Account;
import uts.bank.model.Contact;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TransactionDAO {

    // creates connection to the database
    protected Connection getConnection() {
        Connection con = null;
        try {
            String url = "jdbc:mysql://advancedsoftwareserver.mysql.database.azure.com:3306/bank?useSSL=false";
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, "advancedsoftware", "Welcome1!");
            return con;
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException("Error connecting to the database", e);
        }
    }

    // adds a transaction to the database
    public void addTransaction(Contact contact, Account account, int amount){
        System.out.println(account.getAccountEmail());
        String sql = "INSERT INTO transaction (amount, owner_email, payee_email, account_id) VALUES (?, ?, ?, ?)";
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);) {

            stmt.setInt(1, amount);
            stmt.setString(2, account.getAccountEmail());
            stmt.setString(3, contact.getContactEmail());
            stmt.setInt(4, account.getAccountNumber());

            stmt.executeUpdate();
            System.out.println("done???");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
