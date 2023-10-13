

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import uts.bank.model.Contact;
import uts.bank.model.DAO.AccountDAO;
import uts.bank.model.DAO.AdminDAO;
import uts.bank.model.DAO.UserDAO;
import uts.bank.model.User;
import uts.bank.model.Account;


import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class AdminTest {

    static AdminDAO testAdminDAO = new AdminDAO();

    static AccountDAO testAccountDao = new AccountDAO();

    static UserDAO testuserDao = new UserDAO();
    static User testUser;
    static Account testAccount;



    @BeforeAll
    public static void setUp() throws SQLException {
        testUser = new User("unit test email1", "pass", "customer", "t", "t","2002-08-30","23233","t");
        testuserDao.addUser(testUser);
        testAccount = new Account(11110007, "unit test email1", "unit Test Account", "Savings", 1000.0, 1000.0);
        testAccountDao.addAccount(testAccount);
    }

    @Test
    public void testFindUser() throws SQLException {
        String email = "unit test email1";
        //testUser = new User(email, "pass", "customer", "t", "t","2002-08-30","23233","t");
        //testuserDao.addUser(testUser);

        testUser = testAdminDAO.findUser(email);
        boolean userFound = testUser != null;

        // Check if the account with the specified username was found in the list
        Assertions.assertTrue(userFound, "User not found in the database.");
        System.out.println("add admin test");
        //testuserDao.deleteAccount("unit test email1");
    }

    @Test
    public void testAFindAccount () throws SQLException {
        //testAccount = new Account(testAccountDao.getNextAccountId(), "unit test email1", "unit Test Account", "Savings", 1000.0, 1000.0);
        //testAccountDao.addAccount(testAccount);

        ArrayList<Account> actual = testAdminDAO.findAccounts("unit test email1");
        boolean accountFound = false;
        for (Account account : actual) {
            if (account.getAccountEmail().equals("unit test email1")) {
                accountFound = true;
            }
        }

        // Check if the account with the specified username was found in the list
        Assertions.assertTrue(accountFound, "Account not found in the database.");
        System.out.println("add admin test");
        //testAccountDao.deleteAccount("unit test email1");
    }

   /* @Test
    public void testDeleteAccount () throws SQLException {
            //testAccountDao.addAccount(testAccount);
            testAdminDAO.deleteAccount(11110007);
            List<Account> actual = testAdminDAO.findAccounts("unit test email1");
            assertEquals(0, actual.size());
            System.out.println("delete account test");
        }*/

    @Test
    public void testDeleteAccount() throws Exception{
        //testAccountDao.deleteAccount("unit test email1");
        testuserDao.deleteAccount("unit test email1");

    }


}
