package uts.bank.Controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import uts.bank.model.Contact;
import uts.bank.model.DAO.ContactDAO;

import java.io.IOException;
import java.io.Serializable;
import java.sql.SQLException;

import jakarta.servlet.http.HttpSession;

@WebServlet("/updateContactServlet")
public class updateContactServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private ContactDAO contactDAO;

    //constructor
    public updateContactServlet(){this.contactDAO = new ContactDAO();}

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //Handles if this servlet is handeled in a dopost fashion - sends streight to the do get method
        this.doGet(request, response);
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // gets current session
        HttpSession session = request.getSession();
        // gets all elements from form and puts them into a contact object
        String contactName = request.getParameter("contactName");
        String contactNicName = request.getParameter("contactNicName");

        // Inside your updateContactServlet's doPost method
        String contactEmail = request.getParameter("contactEmail");
        String accountNumberStr = request.getParameter("accountNumber");

        // Validate the email format using a regular expression
        if (!contactEmail.matches("^[A-Za-z0-9+_.-]+@(.+)$")) {
            // Handle invalid email format
            response.sendRedirect("edit-contact.jsp?error=invalid-email");
        } else {
            // Try to parse the account number as a valid integer
            try {
                int accountNumber = Integer.parseInt(accountNumberStr);
                Contact contact = (Contact) session.getAttribute("contact");
                contact.setContactId((Integer) session.getAttribute("contactId"));
                contact.setContactName(contactName);
                contact.setContactNicName(contactNicName);
                contact.setContactEmail(contactEmail);
                contact.setAccountNumber(accountNumber);
                // updates the contact in the database
                try {
                    contactDAO.updateContact(contact);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                // sends to the main contact page
                response.sendRedirect("savecontactservlet");
            } catch (NumberFormatException e) {
                // Handle the case where parsing as an integer fails
                response.sendRedirect("edit-contact.jsp?error=invalid-account-number");
            }
        }


    }
}
