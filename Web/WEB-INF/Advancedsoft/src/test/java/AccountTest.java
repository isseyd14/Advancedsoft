// import org.junit.jupiter.api.*;
// import uts.bank.model.Account;
// import uts.bank.model.DAO.AccountDAO;
// import uts.bank.model.DAO.UserDAO;
// import uts.bank.model.User;


// import static org.junit.jupiter.api.Assertions.*;

// import java.sql.Date;
// import java.sql.SQLException;
// import java.util.List;

// public class AccountTest {
//     static AccountDAO testAccountDao = new AccountDAO();
//     static Account testAccount;
//     static UserDAO testuserDao = new UserDAO();

//     static User testUser;

//     @BeforeAll
//     public static void setUp() throws SQLException {
//         testAccount = new Account(testAccountDao.getNextAccountId(), "unit test email", "unit Test Account", "Savings", 1000.0, 1000.0);

//         Date specificSQLDate = Date.valueOf("2002-08-30");
//         testUser = new User("unit test email", "pass", "customer", "t", "t","04-10-1996","23233","t");
//         testuserDao.addUser(testUser);
//     }
//     @Test
//     public void testAddAccount() throws SQLException {
//         testAccountDao.addAccount(testAccount);
//         List<Account> actual = testAccountDao.findaccounts("unit test email");
//         // Check if the actual list contains the testAccount
//         boolean accountFound = false;

//         for (Account account : actual) {
//             if (account.getAccountEmail().equals(testAccount.getAccountEmail())) {
//                 accountFound = true;
//                 break; // Exit the loop as soon as the account is found
//             }
//         }

//         // Check if the account with the specified username was found in the list
//         Assertions.assertTrue(accountFound, "Account not found in the database.");
//         // Check if there is only one account with the specified username
//         assertEquals(1,actual.size());
//         System.out.println("add account test");
//         testAccountDao.deleteAccount("unit Test Account");
//     }

//     @Test
//     public void testDeleteAccount() throws SQLException {
//         testAccountDao.addAccount(testAccount);
//         testAccountDao.deleteAccount("unit Test Account");
//         List<Account> actual = testAccountDao.findaccounts("unit test email");
//         assertEquals(0, actual.size());
//         System.out.println("delete account test");
//     }

//     @AfterAll
//     public static void tearDown() throws Exception{
//         testuserDao.deleteAccount("unit test email");
//     }


// }