package uts.bank.DAO;

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
                String firstName = rs.getString("fName");
                String lastName = rs.getString("lName");
                String address = rs.getString("Address");
                String DOB = rs.getDate("DOB").toString();
                String phone = rs.getString("Phone");
                return new User(userEmail, password, type, firstName, lastName, address, DOB, phone);
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
}