package uts.bank.DAO;

import uts.bank.model.Contact;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ContactDAO {

    protected Connection getConnection(){
        Connection con = null;
        try{
            String url="jdbc:mysql://advancedsoftwareserver.mysql.database.azure.com:3306/bank?useSSL=false";
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection(url, "advancedsoftware", "Welcome1!");
            return con;
        } catch (SQLException | ClassNotFoundException e){
            throw new RuntimeException("Error connecting to the database", e);
        }
    }

    public void addContact(Contact contact)throws SQLException{
        String sql = "INSERT INTO contacts (owner_email, contact_name, contact_nic_name, contact_email) VALUES (?, ?, ?, ?)";
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
