package uts.bank.model.DAO;

import uts.bank.model.Contact;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ContactDAO {

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

    public void addContact(Contact contact)throws SQLException{
        String sql = "INSERT INTO account (owner_email, contact_name, contact_nic_name, contact_email) VALUES (?, ?, ?, ?)";
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);) {

            stmt.setString(1, contact.getOwnerEmail());
            stmt.setString(2, contact.getContactName());
            stmt.setString(3, contact.getContactNicName());
            stmt.setString(4, contact.getContactEmail());


            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public List<Contact> findContacts(String userEmail) {
        List<Contact> contacts = new ArrayList<>();
        String sql = "SELECT * FROM contacts WHERE owner_email = ?";
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);){
            System.out.println("database connected in find accounts");
            stmt.setString(1, userEmail);
            ResultSet rs = stmt.executeQuery();

            while(rs.next()){
                String ownerEmail = rs.getString("owner_email");
                String contactName = rs.getString("contact_name");
                String contactNicName = rs.getString("contact_nic_name");
                String contactEmail = rs.getString("contact_email");
                contacts.add(new Contact(ownerEmail, contactName, contactNicName, contactEmail));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return contacts;
    }
}
