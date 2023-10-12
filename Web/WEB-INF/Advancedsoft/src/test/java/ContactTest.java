

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import uts.bank.model.Contact;
import uts.bank.model.DAO.ContactDAO;
import uts.bank.model.DAO.UserDAO;
import uts.bank.model.user;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ContactTest {

    static ContactDAO testContactDAO = new ContactDAO();
    static Contact testContact;
    static UserDAO testuserDao = new UserDAO();

    static user testUser;

    @BeforeAll
    public static void setUp() throws SQLException {
        Date specificSQLDate = Date.valueOf("2002-08-30");
        testUser = new user("unit test email", "pass", "customer", "t", "t",specificSQLDate,"23233","t");
        testuserDao.addUser(testUser);
    }

    @Test
    public void testAddContact() throws SQLException {
        testContact = new Contact("unit test email", "unit Test Contact", "unit test", "unit test nic");
        testContactDAO.addContact(testContact);
        List<Contact> actual = testContactDAO.findContacts("unit test email");
        boolean accountFound = false;

        for (Contact contact : actual) {
            System.out.println(contact.getContactEmail());
            if (contact.getOwnerEmail().equals(testContact.getOwnerEmail())) {
                accountFound = true;
                break; // Exit the loop as soon as the account is found
            }
        }

        // Check if the account with the specified username was found in the list
        Assertions.assertTrue(accountFound, "Account not found in the database.");
        // Check if there is only one account with the specified username
        Assertions.assertEquals(1,actual.size());
        System.out.println("add contact test");
        testContactDAO.deleteContact("unit test");
    }

    @Test
    public void testUpdateContact () throws SQLException {
        testContact = new Contact("unit test email", "unit Test Contact", "unit test", "unit test nic");
        testContactDAO.addContact(testContact);
        testContact.setContactEmail("updated unit test email");
        testContact.setContactNicName("updated unit test nic");
        testContact.setContactName("updated unit test name");

        List<Contact> actual = testContactDAO.findContacts("updated unit test email");
        for (Contact contact : actual) {
            System.out.println(contact.getContactEmail());
        }
        assertEquals(0, actual.size());
        System.out.println("delete contact test");

        testContactDAO.deleteContact("unit test");
    }

    @Test
    public void testDeleteContact () throws SQLException {
        testContact = new Contact("unit test email", "unit Test Contact", "unit test", "unit test nic");
        testContactDAO.addContact(testContact);
        testContactDAO.deleteContact("unit test");
        List<Contact> actual = testContactDAO.findContacts("unit test email");
        for (Contact contact : actual) {
            System.out.println(contact.getContactEmail());
        }
        assertEquals(0, actual.size());
        System.out.println("delete contact test");
    }

    @AfterAll
    public static void tearDown() throws Exception{
        testuserDao.deleteAccount("unit test email");
    }


}