package uts.bank.model.DAO;

import org.junit.jupiter.api.*;
import uts.bank.DAO.AccountDAO;
import uts.bank.model.Account;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.sql.SQLException;
import java.util.List;

public class AccountDAOTest {
    static AccountDAO testCardDao = new AccountDAO();
    static Account testAccount;

    @BeforeAll
    public static void setUp() throws SQLException {
        testAccount = new Account(testCardDao.getNextAccountId(), "unit test email", "unit Test Account", "Savings", 1000.0, 1000.0);
    }
    @Test
    public void testAddAccount() throws SQLException {
        testCardDao.addAccount(testAccount);
        List<Account> actual = testCardDao.findaccounts("unit test email");
        // Check if the actual list contains the testAccount
        boolean accountFound = false;

        for (Account account : actual) {
            if (account.getAccountEmail().equals(testAccount.getAccountEmail())) {
                accountFound = true;
                break; // Exit the loop as soon as the account is found
            }
        }

        // Check if the account with the specified username was found in the list
        Assertions.assertTrue(accountFound, "Account not found in the database.");
        // Check if there is only one account with the specified username
        Assertions.assertEquals(1,actual.size());

    }

    @AfterAll
    public static void tearDown() throws Exception{
        testCardDao.deleteAccount("unit Test Account");
    }


}
