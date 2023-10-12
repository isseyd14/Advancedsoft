package uts.bank.model.DAO;

import uts.bank.model.Contact;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ContactDAO {

    protected Connection getConnection(){
        Connection con = null;
        try{
            String url="jdbc:mysql://advancedsoftwareserver.mysql.database.azure.com:3306/bank?useSSL=false";
            Class.forName("com.mysql.cj.jdbc.Driver");
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
            stmt.setString(1, userEmail);
            ResultSet rs = stmt.executeQuery();

            while(rs.next()){
                String ownerEmail = rs.getString("owner_email");
                String contactName = rs.getString("contact_name");
                String contactNicName = rs.getString("contact_nic_name");
                String contactEmail = rs.getString("contact_email");
                int contactId = rs.getInt("contacts_id");
                Contact contact = new Contact(ownerEmail, contactName, contactNicName, contactEmail);
                contact.setContactId(contactId);
                contacts.add(contact);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return contacts;
    }

    public Contact findOneContact(int contactID){
        String ownerEmail ="";
        String contactName ="";
        String contactNicName ="";
        String contactEmail ="";
        String sql = "SELECT * FROM contacts WHERE contacts_id = ?";
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);){
            stmt.setInt(1, contactID);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) { // Move the cursor to the first row of the result set
                ownerEmail = rs.getString("owner_email");
                contactName = rs.getString("contact_name");
                contactNicName = rs.getString("contact_nic_name");
                contactEmail = rs.getString("contact_email");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return new Contact(ownerEmail, contactName, contactNicName, contactEmail);
    }

    public void updateContact(Contact contact) throws SQLException {
        String sql = "UPDATE contacts SET owner_email=?, contact_name=?, contact_nic_name=?, contact_email=? WHERE contacts_id=?";
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);) {

            stmt.setString(1, contact.getOwnerEmail());
            stmt.setString(2, contact.getContactName());
            stmt.setString(3, contact.getContactNicName());
            stmt.setString(4, contact.getContactEmail());
            stmt.setInt(5, contact.getContactId()); // Assuming you have a method to get the contact ID

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteContact(String contact_email) throws SQLException {
        String sql = "DELETE FROM bank.contacts WHERE contact_email = ?";
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);) {

            stmt.setString(1, contact_email);
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
