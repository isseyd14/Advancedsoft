package uts.bank.Controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import uts.bank.model.Contact;
import uts.bank.model.DAO.ContactDAO;

import java.io.IOException;

@WebServlet("/editContactServlet")
public class editContactServlet extends HttpServlet {

    private ContactDAO contactDAO;

    //constructor
    public editContactServlet() {this.contactDAO = new ContactDAO();}

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, IOException {
        // gets the contact id from the edit button
        int contactId = Integer.parseInt(request.getParameter("contactId"));

        // Use the contactId to fetch the corresponding contact from the database
        Contact contact =  contactDAO.findOneContact(contactId);

        // Set the contact in the request scope to make it available in the JSP
        request.getSession().setAttribute("contactId",contactId);
        request.getSession().setAttribute("contact", contact); // Set the contact in the session
        request.getRequestDispatcher("edit-contact.jsp").forward(request, response);

        //System.out.println(contact.getContactId());
    }

}
