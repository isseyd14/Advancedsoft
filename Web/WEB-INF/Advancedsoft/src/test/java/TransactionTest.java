import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import uts.bank.model.Account;
import uts.bank.model.Contact;
import uts.bank.model.DAO.AccountDAO;
import uts.bank.model.DAO.ContactDAO;
import uts.bank.model.DAO.TransactionDAO;
import uts.bank.model.DAO.UserDAO;
import uts.bank.model.Transaction;
import uts.bank.model.User;

import java.sql.SQLException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TransactionTest {
    static AccountDAO testAccountDao = new AccountDAO();
    static Account testAccount;
    static UserDAO testuserDao = new UserDAO();

    static TransactionDAO testTransactionDao = new TransactionDAO();
    static ContactDAO testContactDao = new ContactDAO();

    static User testUser;
    static Contact testContact;
    static Transaction testTransaction;

    @BeforeAll
    public static void setUp() throws SQLException {
        testUser = new User("unit test email", "pass", "customer", "t", "t", "2002-08-30", "23233", "t");
        testuserDao.addUser(testUser);
        testAccount = new Account(testAccountDao.getNextAccountId(), "unit test email", "unit Test Account", "Savings", 1000.0, 1000.0);
        testAccountDao.addAccount(testAccount);
        testContact = new Contact("unit test email", "testtras@gmail.com", "testtras@gmail.com", "testtras@gmail.com",11110001);
        testTransaction = new Transaction(testTransactionDao.getNexttransactionId(), 5, "unit test email", "testtras@gmail.com", 11110001);
    }

    @Test
    public void testAddAccount() throws SQLException {
        testTransactionDao.addTransaction(testTransaction);
        List<Transaction> actual = testTransactionDao.findTransactions("unit test email");
        // Check if the actual list contains the testAccount
        boolean accountFound = false;

        for (Transaction transaction : actual) {
            if (transaction.getTransaction_id() == testTransaction.getTransaction_id()) {
                accountFound = true;
                break; // Exit the loop as soon as the account is found
            }
        }

        // Check if the account with the specified username was found in the list
        Assertions.assertTrue(accountFound, "Account not found in the database.");
        // Check if there is only one account with the specified username
        assertEquals(1,actual.size());
        System.out.println("add account test");
        testTransactionDao.deleteTransaction(testTransaction.getTransaction_id());
    }

    @AfterAll
    public static void tearDown() throws Exception{
        testAccountDao.deleteAccount("unit Test Account");
        testuserDao.deleteAccount("unit test email");
    }
}
