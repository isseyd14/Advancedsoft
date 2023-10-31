
import org.junit.jupiter.api.*;
import uts.bank.model.DAO.UserDAO;
import uts.bank.model.User;
import java.sql.Date;


import static org.junit.jupiter.api.Assertions.assertEquals;

import java.sql.SQLException;

public class UserUpdTest {
    static UserDAO testuserDao = new UserDAO();

    static User testAccount;

    @BeforeAll
    public static void setUp(){

        testAccount = new User("unit test email", "pass", "customer", "fname", "lname","2002-08-30","23233","t");
    }
    @Test
    public void testupdateUser() throws SQLException {

        User updatedAccount = new User("unit test email", "passt", "customert", "t", "t","2002-08-30","232323","tt");
        testuserDao.addUser(testAccount);
        testuserDao.updateUser(testAccount, "t", "t", "232323","tt");
        User Faccount = testuserDao.findUser(testAccount.getEmail());
        // Check if the actual list contains the testAccount
        boolean userFound = false;

        if (updatedAccount.getFname().equals(Faccount.getFname())&&updatedAccount.getLname().equals(Faccount.getLname())) {
            userFound = true;
        }
        // Check if the account with the specified username was found in the list
        Assertions.assertTrue(userFound, "Account not found in the database.");
        // Check if there is only one account with the specified username
    }
    @AfterAll
    public static void tearDown() throws Exception{
        testuserDao.deleteAccount("unit Test email");
    }

}