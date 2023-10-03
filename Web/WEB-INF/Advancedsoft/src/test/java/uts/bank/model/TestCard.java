package uts.bank.model;


import org.junit.jupiter.api.*;


public class TestCard {

    
    static Card aCard = new Card();
    @BeforeAll
    public static void setUp() {
        aCard = new Card("1234567890123456", "John Doe", "12/25", "123", "Visa", "Active", "1001", "2001", 0, "1234");
    }
    @Test
    public void testGetCardNumber() {
        String expected = "1234567890123456";
        String actual = aCard.getCardNumber();

        Assertions.assertEquals(expected, actual);
        
    }


}
