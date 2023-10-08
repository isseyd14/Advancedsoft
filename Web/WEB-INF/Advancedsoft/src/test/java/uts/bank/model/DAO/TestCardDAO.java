package uts.bank.model.DAO;


import java.util.List;

import org.junit.jupiter.api.*;

import uts.bank.model.Card;


public class TestCardDAO {

//test methods in CardDAO.java
    static CardDAO aCardDAO = new CardDAO();
    static Card aCard;
    @BeforeAll
    public static void setUp() {
        aCard = new Card("5125763023039519", "John Doe", "12/25", "123", "Visa", "Active", "5001", "6001", 0, "1234");
        
    }
    @Test
    //test addCard method
    public void testAddCard() throws Exception {
        aCardDAO.addCard(aCard);
        Card expected = aCard;
        Card actual = aCardDAO.findCard("5125763023039519");
        System.out.println(expected);
        System.out.println(actual);
        Assertions.assertEquals(expected.getCardNumber(), actual.getCardNumber());
    }
    @Test
    //test findCardbycustomerid method
    public void testFindCardByCustomerId() throws Exception {

        List<Card> actual = aCardDAO.findCardByCustomerId("5001");
        //System.out.println(expected);
        System.out.println(actual.size());
        Assertions.assertEquals(1, actual.size());
    }
    @Test
    //test findCardbyaccountid method
    public void testFindCardByAccountId() throws Exception {

        List<Card> actual = aCardDAO.findCardByAccountId("6001");
        //System.out.println(expected);
        System.out.println(actual.size());
        Assertions.assertEquals(1, actual.size());
    }

    @AfterAll
    public static void tearDown() throws Exception {
        aCardDAO.deleteCard("5125763023039519");
    }

    


}
