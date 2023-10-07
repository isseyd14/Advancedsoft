package uts.bank.model.DAO;


import org.junit.jupiter.api.*;

import uts.bank.model.Card;


public class TestCardDAO {

//test methods in CardDAO.java
    static CardDAO aCardDAO = new CardDAO();
    static Card aCard;
    @BeforeAll
    public static void setUp() {
        aCard = new Card("5125763023039519", "John Doe", "12/25", "123", "Visa", "Active", "1001", "2001", 0, "1234");
     
    }
    @Test
    //test addCard method
    public void testAddCard() throws Exception {
        //Card aCard = new Card("5125763023039519", "John Doe", "12/25", "123", "Visa", "Active", "1001", "2001", 0, "1234");
        aCardDAO.addCard(aCard);
        Card expected = aCard;
        Card actual = aCardDAO.findCard("5125763023039519");
        System.out.println(expected);
        System.out.println(actual);
        Assertions.assertEquals(expected.getCardNumber(), actual.getCardNumber());
    }
    @AfterAll
    public static void tearDown() throws Exception {
        aCardDAO.deleteCard("5125763023039519");
    }

    


}
