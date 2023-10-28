package uts.bank.Controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import uts.bank.model.Contact;
import uts.bank.model.DAO.ContactDAO;

import java.io.IOException;
import java.sql.SQLException;

import jakarta.servlet.http.HttpSession;

@WebServlet("/AddContactServlet")
public class AddContactServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private ContactDAO contactDAO;

    //constructor
    public AddContactServlet() {
        this.contactDAO = new ContactDAO();
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //Handles if this servlet is handeled in a dopost fashion - sends streight to the do get method
        this.doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // gets the current session
        HttpSession session = request.getSession();
        // getting all the elements from the form, and putting them into an contact object
        String email = (String) session.getAttribute("email");
        String contactName = request.getParameter("ContactName");
        String contactNicName = request.getParameter("ContactNicName");
        String contactEmail = request.getParameter("ContactEmail");
        int accountNumber = Integer.parseInt(request.getParameter("accountNumber"));
        System.out.println(accountNumber);

        Contact newContact = new Contact(email, contactName, contactNicName, contactEmail, accountNumber);
        // putting the new contact object into the database
        try {
            contactDAO.addContact(newContact);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        // sending the user back to the main contacts page
        response.sendRedirect("savecontactservlet");

    }





}



