package uts.bank.model.DAO;

import java.util.ArrayList;
import java.util.List;

import uts.bank.model.Transaction;

//import org.hibernate.mapping.List;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class TransDAO{
    String url = "jdbc:mysql://advancedsoftwareserver.mysql.database.azure.com:3306/bank?useSSL=false";
    String username = "advancedsoftware";
    String password = "Welcome1!";
    String driver = "com.mysql.cj.jdbc.Driver";
    protected Connection getConnection(){
        Connection conn = null;
        try{
            Class.forName(driver);
            
            conn = DriverManager.getConnection(url, username, password);
            return conn;
        } catch (SQLException | ClassNotFoundException e){
            throw new RuntimeException("Error connecting to the database", e);
        }
       
        
    }

    public List<Transaction> findTransByAccountId(String accountId) {
        List<Transaction> trans = new ArrayList<>();
        String sql = "SELECT * FROM transaction WHERE account_id = ?";
        try (Connection conn = getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql);){

            stmt.setString(1, accountId);
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
                String owner_email = rs.getString("owner_email");
                String payee_email = rs.getString("payee_email");
                double amount = rs.getDouble("amount");
                int transaction_id = rs.getInt("transaction_id");
                
                trans.add(new Transaction(transaction_id, amount, owner_email, payee_email, Integer.parseInt(accountId)));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return trans;
    }

    //find all tansactions in the database
    public List<Transaction> findAllTransactions() {
        List<Transaction> trans = new ArrayList<>();
        String sql = "SELECT * FROM transaction";
        try (Connection conn = getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql);){

            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
                String owner_email = rs.getString("owner_email");
                String payee_email = rs.getString("payee_email");
                double amount = rs.getDouble("amount");
                int transaction_id = rs.getInt("transaction_id");
                int accountId = rs.getInt("account_id");
                trans.add(new Transaction(transaction_id, amount, owner_email, payee_email, accountId));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return trans;
    }

    //search histroy
    public List<Transaction> findTransByKeyword(String accountId, String keyword) {
        List<Transaction> trans = new ArrayList<>();
        String sql = "SELECT * FROM transaction WHERE account_id = ? and payee_email like ?";
        try (Connection conn = getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql);){
            stmt.setString(1, accountId);
            stmt.setString(2, "%"+keyword+"%");
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
                String owner_email = rs.getString("owner_email");
                String payee_email = rs.getString("payee_email");
                double amount = rs.getDouble("amount");
                int transaction_id = rs.getInt("transaction_id");
                trans.add(new Transaction(transaction_id, amount, owner_email, payee_email, Integer.parseInt(accountId)));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return trans;
    }

}