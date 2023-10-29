package uts.bank.model.DAO;

import uts.bank.model.User;

import java.sql.*;


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
    public boolean passvalid(String pass, String email) throws SQLException{
        String sql = "SELECT COUNT(*) FROM passcode WHERE Email = ? AND Passcode = ?";
        try (Connection con = getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, email);
            ps.setString(2, pass);
            ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    return true; // Password exists if count is greater than 0
                }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false; // Password doesn't exist or an error occurred
    }
    public void passcode( String email, String pass)throws SQLException{
        String sql = "INSERT INTO bank.passcode (Email,Passcode) VALUES(?,? )";
        try (Connection con = getConnection();
             PreparedStatement ps = con.prepareStatement(sql);) {
            ps.setString(1, email);
            ps.setString(2, pass);
            ps.executeUpdate();
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void updateUser(User account, String fname, String lname, String phone, String Address)throws SQLException{
        String sql = "UPDATE bank.user SET fname=?, lname=?, phone=?, address=? WHERE Email=?";;
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


        public void addUser(User account)throws SQLException{
        String sql = "INSERT INTO bank.user (Email, Pass, Type, fname, lname, Address, DOB, Phone) VALUES(?,?,?,?,?,?,?,? )";


        try (Connection con = getConnection();
             PreparedStatement ps = con.prepareStatement(sql);) {
            ps.setString(1, account.getEmail());
            ps.setString(2, account.getPassword());
            ps.setString(3, "customer");
            ps.setString(4, account.getFname());
            ps.setString(5, account.getLname());
            ps.setString(6, account.getAddress());
            ps.setDate(7, Date.valueOf(account.getDob()));
            ps.setString(8, account.getPhone());
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    public User findUser(String customerEmail) {
        String emailDB = "";
        String passwordDB = "";
        String typeDB = "customer";
        String nameDB = "";
        String LnameDB = "";
        String Address = "";
        String Phone = "";
        double bal = 0;
        String dob = "";
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
                dob = rs.getDate("dob").toString();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        User acco = new User(emailDB,passwordDB,typeDB,nameDB,LnameDB,dob,Phone,Address);

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


