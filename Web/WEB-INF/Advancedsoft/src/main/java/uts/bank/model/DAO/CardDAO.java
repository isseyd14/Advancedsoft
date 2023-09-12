package uts.bank.model.DAO;

import uts.bank.model.Card;
import java.util.ArrayList;
import java.util.List;

//import org.hibernate.mapping.List;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class CardDAO{

    String url = "jdbc:mysql://127.0.0.1:3306/bank?useSSL=false";
    String username = "root";
    String password = "admin123"; 
   

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



    // add card to database
    public void addCard(Card card) throws SQLException{
        String sql = "INSERT INTO card (card_number, card_holder, expiry_date, CVV, card_type, card_status, customer_id, account_id, balance, pin) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql);) {
                  
            stmt.setString(1, card.getCardNumber());
            stmt.setString(2, card.getCardHolder());
            stmt.setString(3, card.getExpiryDate());
            stmt.setString(4, card.getCVV());
            stmt.setString(5, card.getCardType());
            stmt.setString(6, card.getCardStatus());
            stmt.setString(7, card.getCustomerId());
            stmt.setString(8, card.getAccountId());
            stmt.setDouble(9, card.getBalance());
            stmt.setString(10, card.getPin());

            stmt.executeUpdate();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
       
    }

    // find card information by card number
    public Card findCard(String cardNumber) {
        Card card = null;
        String sql = "SELECT * FROM card WHERE cardNumber = ?";
        try (Connection conn = getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql);){

            stmt.setString(1, cardNumber);
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
                
                String cardHolder = rs.getString("card_holder");
                String expiryDate = rs.getString("expiry_date");
                String cvv = rs.getString("CVV");
                String cardType = rs.getString("card_type");
                String cardStatus = rs.getString("card_status");
                String customerId = rs.getString("customer_id");
                String accountId = rs.getString("account_id");
                Double balance = rs.getDouble("balance");
                String pin = rs.getString("pin");
                card = new Card(cardNumber, cardHolder, expiryDate, cvv, cardType, cardStatus, customerId, accountId, balance, pin);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return card;
    }

    // find card information by customer id
    public List<Card> findCardByCustomerId(String customerId) {
        List<Card> cards = new ArrayList<>();
        String sql = "SELECT * FROM card WHERE customerId = ?";
        try (Connection conn = getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql);){

            stmt.setString(1, customerId);
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
                String cardNumber = rs.getString("card_number");
                String cardHolder = rs.getString("card_holder");
                String expiryDate = rs.getString("expiry_date");
                String cvv = rs.getString("CVV");
                String cardType = rs.getString("card_type");
                String cardStatus = rs.getString("card_status");
                
                String accountId = rs.getString("account_id");
                Double balance = rs.getDouble("balance");
                String pin = rs.getString("pin");
                cards.add(new Card(cardNumber, cardHolder, expiryDate, cvv, cardType, cardStatus, customerId, accountId, balance, pin));
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cards;
    }

    public List<Card> findAllCards(){
        List<Card> cards = new ArrayList<>();
        String sql = "SELECT * FROM card";
        try (Connection conn = getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql);){

            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
                String cardNumber = rs.getString("card_number");
                String cardHolder = rs.getString("card_holder");
                String expiryDate = rs.getString("expiry_date");
                String cvv = rs.getString("CVV");
                String cardType = rs.getString("card_type");
                String cardStatus = rs.getString("card_status");
                String customerId = rs.getString("customer_id");
                String accountId = rs.getString("account_id");
                Double balance = rs.getDouble("balance");
                String pin = rs.getString("pin");
                cards.add(new Card(cardNumber, cardHolder, expiryDate, cvv, cardType, cardStatus, customerId, accountId, balance, pin));
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cards;
    }

    // find card information by account id
    

    // set card status to "active"
    
    




}