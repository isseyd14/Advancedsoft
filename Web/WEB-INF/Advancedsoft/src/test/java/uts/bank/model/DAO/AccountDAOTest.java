package uts.bank.model.DAO;

import uts.bank.model.Account;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.sql.SQLException;
import java.util.List;

public class AccountDAOTest {

    private AccountDAO accountDAO;

    @BeforeEach
    public void setUp() {
        accountDAO = new AccountDAO();
    }

    @Test
    public void testAddAccount() throws SQLException {
        // Create a sample account
        Account account = new Account("test", "unit Test Account", "Savings", 1000.0, 1000.0);

        // Call the addAccount method
        accountDAO.addAccount(account);

        // You can add additional assertions here to check the result of the operation if needed

        // Clean up by deleting the test data (if necessary)
        accountDAO.deleteAccount("unit Test Account");
        // Implement this based on your application's requirements
    }

    @Test
    public void testFindAccounts() {
        // Provide a sample customer email for testing
        String customerEmail = "test";

        // Call the findaccounts method
        List<Account> accounts = accountDAO.findaccounts(customerEmail);

        // Assert that the returned list is not null and contains at least one account
        assertEquals(false, accounts.isEmpty());

        // You can add additional assertions here to check the correctness of the retrieved accounts
    }
}
