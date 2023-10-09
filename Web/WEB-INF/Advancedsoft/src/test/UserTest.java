package uts.bank.model.DAO;

import org.junit.jupiter.api.*;
import uts.bank.model.user;
import java.sql.Date;


import static org.junit.jupiter.api.Assertions.assertEquals;

import java.sql.SQLException;
import java.util.List;

public class UserTest {
    static UserDAO testuserDao = new UserDAO();

    static User testAccount;

    @BeforeAll
    public static void setUp(){
        Date specificSQLDate = Date.valueOf("2002-08-30");

        testUser = new User("unit test email", "pass", "customer", "t", "t","t",specificSQLDate,23233);
    }
    @Test
    public void testAddUser() throws SQLException {
        testuserDao.addUser(testAccount);
        User Faccount = testuserDao.findUser(testUser);
        // Check if the actual list contains the testAccount
        boolean userFound = false;

            if (testAccount.getEmail.equals(Faccount)) {
                userFound = true;
        }
        // Check if the account with the specified username was found in the list
        Assertions.assertTrue(accountFound, "Account not found in the database.");
        // Check if there is only one account with the specified username
    }
    @AfterAll
    public static void tearDown() throws Exception{
        testCardDao.deleteAccount("unit Test email");
    }


}