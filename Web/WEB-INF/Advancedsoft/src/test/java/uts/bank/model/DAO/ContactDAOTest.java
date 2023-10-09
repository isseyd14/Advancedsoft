package uts.bank.model.DAO;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import uts.bank.model.Account;
import uts.bank.model.Contact;

import java.sql.SQLException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ContactDAOTest {

    static ContactDAO testContactDAO = new ContactDAO();
    static Contact testContact;

    @BeforeAll
    public static void setUp(){
        testContact = new Contact("unit test email", "unit Test Contact", "unit test", "unit test nic");
    }

    @Test
    void addContact() throws SQLException {
        testContactDAO.addContact(testContact);
        List<Contact> actual = testContactDAO.findContacts("unit test email");
        boolean accountFound = false;

        for (Contact contact : actual) {
            if (contact.getOwnerEmail().equals(testContact.getOwnerEmail())) {
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
        testContactDAO.deleteAccount("unit test email");
    }


}