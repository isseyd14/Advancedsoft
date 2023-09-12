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
    private String URL = "jdbc:mysql://localhost:3306/bank?userSSL=false";    
    private String dbuser = "root";
    private String dbpass = "admin123";  
   

    protected Connection getConnection(){
        Connection conn = null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            conn = DriverManager.getConnection(URL, dbuser, dbpass);
            return conn;
        } catch (SQLException | ClassNotFoundException e){
            throw new RuntimeException("Error connecting to the database", e);
        }
       
        
    }



    // add card to database
    public void addCard(Card card) throws SQLException{
        String sql = "INSERT INTO card (cardNumber, cardHolder, expiryDate, CVV, cardType, cardStatus, customerId, accountId, balance, pin) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
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
                String cardHolder = rs.getString("cardHolder");
                String expiryDate = rs.getString("expiryDate");
                String cvv = rs.getString("CVV");
                String cardType = rs.getString("cardType");
                String cardStatus = rs.getString("cardStatus");
                String customerId = rs.getString("customerId");
                String accountId = rs.getString("accountId");
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
                String cardNumber = rs.getString("cardNumber");
                String cardHolder = rs.getString("cardHolder");
                String expiryDate = rs.getString("expiryDate");
                String cvv = rs.getString("CVV");
                String cardType = rs.getString("cardType");
                String cardStatus = rs.getString("cardStatus");
                String accountId = rs.getString("accountId");
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
                String cardNumber = rs.getString("cardNumber");
                String cardHolder = rs.getString("cardHolder");
                String expiryDate = rs.getString("expiryDate");
                String cvv = rs.getString("CVV");
                String cardType = rs.getString("cardType");
                String cardStatus = rs.getString("cardStatus");
                String customerId = rs.getString("customerId");
                String accountId = rs.getString("accountId");
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