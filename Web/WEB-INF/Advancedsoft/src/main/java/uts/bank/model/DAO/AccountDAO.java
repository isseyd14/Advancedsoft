package uts.bank.model.DAO;

import uts.bank.model.Account;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AccountDAO {
    String url = "jdbc:mysql://127.0.0.1:3306/bank?allowPublicKeyRetrieval=true&useSSL=false";
    String username = "root";
    String password = "root";


    protected Connection getConnection(){
        Connection conn = null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");

            conn = DriverManager.getConnection(url, username, password);
            return conn;
        } catch (SQLException | ClassNotFoundException e){
            throw new RuntimeException("Error connecting to the database", e);
        }


    }

    public void addAccount(Account account)throws SQLException{
        String sql = "INSERT INTO account (Email, name, type, avaliable_funds, currentt_funds) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);) {

            stmt.setString(1, account.getAccountEmail());
            stmt.setString(2, account.getAccountName());
            stmt.setString(3, account.getAccountType());
            stmt.setDouble(4, account.getAccountAvailableFunds());
            stmt.setDouble(5, account.getAccountCurrentFunds());


            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    //find all accounts by customer email
    public List<Account> findaccounts(String customerId) {
        List<Account> account = new ArrayList<>();
        String sql = "SELECT * FROM account WHERE Email = ?";
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);){
            System.out.println("database connected in find accounts");
            stmt.setString(1, customerId);
            ResultSet rs = stmt.executeQuery();

            while(rs.next()){
                String accountEmail = rs.getString("Email");
                String accountName = rs.getString("name");
                String accountType = rs.getString("type");
                double accountAvaliableFunds = rs.getDouble("avaliable_funds");
                double accountCurrentFunds = rs.getDouble("current_funds");
                account.add(new Account(accountEmail, accountName, accountType, accountAvaliableFunds, accountCurrentFunds));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return account;
    }

//    public void deleteAccount(String cardNumber) throws SQLException{
//        String sql = "DELETE FROM card WHERE card_number = ?";
//        try (Connection conn = getConnection();
//             PreparedStatement stmt = conn.prepareStatement(sql);) {
//
//            stmt.setString(1, cardNumber);
//            stmt.executeUpdate();
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
}
