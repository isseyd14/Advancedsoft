


import java.util.List;

import org.junit.jupiter.api.*;

import uts.bank.model.Card;
import uts.bank.model.DAO.CardDAO;


public class TestCardDAO {


//test methods in CardDAO.java
    static CardDAO aCardDAO = new CardDAO();
    static Card aCard;
    @BeforeAll
    public static void setUp() {
        aCard = new Card("5125763023039519", "John Doe", "12/25", "123", "Visa", "Active", "6001", "6001", 0, "1234");
        
    }
    
    @Test
    //test addCard method
    public void testAddCard() throws Exception {
        aCardDAO.addCard(aCard);
        Card expected = aCard;
        Card actual = aCardDAO.findCard("5125763023039519");
        Assertions.assertEquals(expected.getCardNumber(), actual.getCardNumber());
    }
    
    @Test
    //test findCardbyaccountid method
    public void testAFindCardByAccountId() throws Exception {

        List<Card> actual = aCardDAO.findCardByAccountId("6001");
        //System.out.println(expected);
        System.out.println(actual.size());
        Assertions.assertEquals(1, actual.size());
    }

    
    @Test
    //test blockCard method
    public void testBlockCard() throws Exception {
        aCardDAO.deactivateCard("5125763023039519");
        String expected = "Inactive";
        Card actual = aCardDAO.findCard("5125763023039519");
        Assertions.assertEquals(expected, actual.getCardStatus());
    }
    
    @Test
    //test activate card method
    public void testCActiveCard() throws Exception {
        aCardDAO.activateCard("5125763023039519");
        String expected = "Active";
        Card actual = aCardDAO.findCard("5125763023039519");
        Assertions.assertEquals(expected, actual.getCardStatus());
    }
    
    @Test
    //test change pin method
    public void testChangePin() throws Exception {
        aCardDAO.changePin("5125763023039519", "4321");
        String expected = "4321";
        Card actual = aCardDAO.findCard("5125763023039519");
        Assertions.assertEquals(expected, actual.getPin());
    }

    @AfterAll
    public static void testDelete() throws Exception {
        aCardDAO.deleteCard("5125763023039519");
    }

    


}
