
import org.junit.jupiter.api.*;
import uts.bank.model.DAO.UserDAO;
import uts.bank.model.user;
import java.sql.Date;


import static org.junit.jupiter.api.Assertions.assertEquals;

import java.sql.SQLException;
import java.util.List;

public class UserUpdTest {
    static UserDAO testuserDao = new UserDAO();

    static user testAccount;

    @BeforeAll
    public static void setUp(){
        Date specificSQLDate = Date.valueOf("2002-08-30");

        testAccount = new user("unit test email", "pass", "customer", "t", "t",specificSQLDate,"23233","t");
    }
    @Test
    public void testupdateUser() throws SQLException {
        Date specificSQLDate = Date.valueOf("2002-08-30");

        user updatedAccount = new user("unit test email", "passt", "customert", "t", "t",specificSQLDate,"232323","tt");
        testuserDao.addUser(testAccount);
        testuserDao.updateUser(testAccount, "passt", "customert", "232323","tt");
        user Faccount = testuserDao.findUser(testAccount.getEmail());
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