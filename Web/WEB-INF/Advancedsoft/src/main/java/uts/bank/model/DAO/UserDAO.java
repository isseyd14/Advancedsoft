package uts.bank.model.DAO;

import uts.bank.model.user;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;




public class UserDAO {
    protected Connection getConnection(){
        Connection con;
        try{
            String url="jdbc:mysql://advancedsoftwareserver.mysql.database.azure.com:3306/bank?useSSL=false";
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection(url, "advancedsoftware", "Welcome1!");
            return con;
        } catch (SQLException | ClassNotFoundException e){
            throw new RuntimeException("Error connecting to the database", e);
        }
    }
    public void updateUser(user account, String fname, String lname, String phone, String Address)throws SQLException{
        String sql = "UPDATE bank.user SET fname=?, lname=?, phone=?, address=? WHERE Email=?";
        try (Connection con = getConnection();
             PreparedStatement ps = con.prepareStatement(sql);) {
            ps.setString(1, fname);
            ps.setString(2, lname);
            ps.setString(3, phone);
            ps.setString(4, Address);
        ps.setString(5, account.getEmail());
        ps.executeUpdate();
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }


        public void addUser(user account)throws SQLException{
        String sql = "INSERT INTO bank.user (Email, Pass, Type, fname, lname, Address, DOB,Phone) VALUES(?,?,?,?,?,?,?,? )";
        java.sql.Date sqlDate = new java.sql.Date(account.getDob().getTime());

        try (Connection con = getConnection();
             PreparedStatement ps = con.prepareStatement(sql);) {
            ps.setString(1, account.getEmail());
            ps.setString(2, account.getPassword());
            ps.setString(3, "customer");
            ps.setString(4, account.getFname());
            ps.setString(5, account.getLname());
            ps.setString(6, account.getAddress());
            ps.setDate(7, sqlDate);
            ps.setString(8, account.getPhone());
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    public user findUser(String customerEmail) {
        String emailDB = "";
        String passwordDB = "";
        String typeDB = "customer";
        String nameDB = "";
        String LnameDB = "";
        String Address = "";
        String Phone = "";
        double bal = 0;
        Date dob = null;
        String sql = "SELECT * FROM bank.user WHERE Email = ?";
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);){
            System.out.println("database connected in find accounts");
            stmt.setString(1, customerEmail);
            ResultSet rs = stmt.executeQuery();

            while(rs.next()){
                emailDB = rs.getString("email");
                passwordDB = rs.getString("PASS");
                typeDB = rs.getString("Type");
                nameDB = rs.getString("Fname");
                LnameDB = rs.getString("Lname");
                Address = rs.getString("Address");
                Phone = rs.getString("Phone");
                dob = rs.getDate("dob");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        user acco = new user(emailDB,nameDB,LnameDB,passwordDB,typeDB,dob,Phone,Address);

        return acco;
    }
    public void deleteAccount(String email) throws SQLException {
        String sql = "DELETE FROM bank.user WHERE Email = ?";
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);) {

            stmt.setString(1, email);
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}


