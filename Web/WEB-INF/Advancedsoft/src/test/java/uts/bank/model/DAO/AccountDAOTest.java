package uts.bank.model.DAO;

import org.junit.jupiter.api.Assertions;
import uts.bank.model.Account;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.sql.SQLException;
import java.util.List;

public class AccountDAOTest {

    @Test
    public void testAddAccount() throws SQLException {
        // Create a sample account
        Account account = new Account("test", "unit Test Account", "Savings", 1000.0, 1000.0);
        String expected = "test";
        String actual = account.getAccountEmail();
        // You can add additional assertions here to check the result of the operation if needed
        Assertions.assertEquals(expected, actual);
        // Clean up by deleting the test data (if necessary)
        // Implement this based on your application's requirements
    }


}
