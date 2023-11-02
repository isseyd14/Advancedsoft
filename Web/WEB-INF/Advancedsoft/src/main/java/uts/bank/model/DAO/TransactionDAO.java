package uts.bank.model.DAO;

import uts.bank.model.Account;
import uts.bank.model.Contact;
import uts.bank.model.Transaction;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

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
    public void addTransaction(Transaction transaction) throws SQLException {
        String sql = "INSERT INTO transaction (transaction_id, amount, owner_email, payee_email, account_id, payee_accountid) VALUES (?, ?, ?, ?, ?,?)";
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);) {

            stmt.setInt(1, transaction.getTransaction_id());
            stmt.setDouble(2, transaction.getAmount());
            stmt.setString(3, transaction.getOwner_email());
            stmt.setString(4, transaction.getPayee_email());
            stmt.setInt(5, transaction.getAccount_id());
            stmt.setInt(6, transaction.getAccount_id());

            stmt.executeUpdate();
            System.out.println("done???");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // finds the next avaliable transaction id
    public int getNexttransactionId() throws SQLException {
        int transactionid = 0;
        String sql = "SELECT MAX(transaction_id) AS next_available_id FROM transaction";
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);) {
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                transactionid = rs.getInt("next_available_id") + 1;
            } else {
                // If there are no existing account IDs, you can start from 1 or any desired initial value.
                transactionid = 100000;
            }

            return transactionid;
        }
    }

    public void deleteTransaction(int transactionId) throws SQLException {
        String sql = "DELETE FROM transaction WHERE transaction_id = ?";
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);) {

            stmt.setInt(1, transactionId);
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Transaction> findTransactions(String owner_email) {
        List<Transaction> transaction = new ArrayList<>();
        String sql = "SELECT * FROM transaction WHERE owner_email = ?";
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);){
            stmt.setString(1, owner_email);
            ResultSet rs = stmt.executeQuery();

            while(rs.next()){
                int transaction_idDB = rs.getInt("transaction_id");
                double amountDB = rs.getDouble("amount");
                String owner_emailDB = rs.getString("owner_email");
                String payee_emailDB = rs.getString("payee_email");
                int account_idDB = rs.getInt("account_id");
                int payee_accountIdDB = rs.getInt("payee_accountid");
                transaction.add(new Transaction(transaction_idDB, amountDB, owner_emailDB, payee_emailDB, account_idDB, payee_accountIdDB));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return transaction;
    }

}
