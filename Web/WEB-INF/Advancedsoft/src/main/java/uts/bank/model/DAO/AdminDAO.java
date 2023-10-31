package uts.bank.model.DAO;

import uts.bank.model.Account;
import uts.bank.model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;

public class AdminDAO {

    private Connection conn;

    public AdminDAO() {
        conn = getConnection();
    }


    public Connection getConnection() {
        try {
            String url = "jdbc:mysql://advancedsoftwareserver.mysql.database.azure.com:3306/bank?useSSL=false";
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            return DriverManager.getConnection(url, "advancedsoftware", "Welcome1!");
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException("Error connecting to the database", e);
        }
    }

    public ArrayList<Account> findAccounts(String email) throws SQLException {
        String sql = "SELECT * FROM account WHERE Email = ?";
        ArrayList<Account> accounts = new ArrayList<>();
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, email);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                int accountNum = rs.getInt("account_id");
                String accountEmail = rs.getString("Email");
                String accountName = rs.getString("name");
                String accountType = rs.getString("type");
                double accountAvailableFunds = rs.getDouble("avaliable_funds");
                double accountCurrentFunds = rs.getDouble("current_funds");
                accounts.add(new Account(accountNum, accountEmail, accountName, accountType, accountAvailableFunds, accountCurrentFunds));
            }
        }
        return accounts;
    }

    public User findUser(String email) throws SQLException {
        String sql = "SELECT * FROM USER WHERE Email = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, email);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                String userEmail = rs.getString("Email");
                String password = rs.getString("Pass");
                String type = rs.getString("Type");
                String firstName = rs.getString("fname");
                String lastName = rs.getString("lname");
                String address = rs.getString("Address");
                String DOB = rs.getDate("DOB").toString();
                String phone = rs.getString("Phone");
                return new User(userEmail, password, type, firstName, lastName, DOB, phone, address);
            }
        }
        return null;
    }

    public void deleteAccount(int accountNumber) throws SQLException {
        String sql = "DELETE FROM account WHERE account_id = '" + accountNumber + "'";
        try {
            conn.createStatement().executeUpdate(sql);
        } catch (SQLException ex) {
            System.err.println("Error deleting account: " + ex.getMessage());
            throw ex;
        }
    }

    public String getEmailbyAccount(int accountNumber) throws SQLException {
        String sql = "SELECT Email FROM account WHERE account_id = ?";
        String userEmail = "";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, String.valueOf(accountNumber));
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                userEmail = rs.getString("Email");
            }
        }
        return userEmail;
    }

    public Account getAccount(int accountNumber) throws SQLException {
        String sql = "SELECT * FROM account WHERE account_id = ?";
        Account account = null;
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, String.valueOf(accountNumber));
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                String userEmail = rs.getString("Email");
                String name = rs.getString("name");
                String type = rs.getString("type");
                double available_funds = rs.getDouble("avaliable_funds");
                double current_funds = rs.getDouble("current_funds");
                account = new Account(accountNumber, userEmail, name, type, available_funds, current_funds);
            }
        }
        return account;
    }

    public void updateAccount(int accountNumber, String name, double available_funds) {
        String sql = "UPDATE account SET name = ?, avaliable_funds = ? WHERE account_id = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, name);
            pstmt.setDouble(2, available_funds);
            pstmt.setInt(3, accountNumber);
            pstmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void deposit(int accountNumber, double current_funds) {
        String sql = "UPDATE account SET current_funds = ?, avaliable_funds = ? WHERE account_id = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setDouble(1, current_funds);
            pstmt.setDouble(2, current_funds);
            pstmt.setInt(3, accountNumber);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void withdraw(int accountNumber, double current_funds) {
        String sql = "UPDATE account SET current_funds = ?, avaliable_funds = ? WHERE account_id = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setDouble(1, current_funds);
            pstmt.setDouble(2, current_funds);
            pstmt.setInt(3, accountNumber);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
