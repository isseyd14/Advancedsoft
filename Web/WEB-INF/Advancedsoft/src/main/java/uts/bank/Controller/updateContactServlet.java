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

    public updateContactServlet(){this.contactDAO = new ContactDAO();}

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        this.doGet(request, response);
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String contactName = request.getParameter("contactName");
        System.out.println(contactName);
        String contactNicName = request.getParameter("contactEmail");
        System.out.println(contactNicName);
        String contactEmail = request.getParameter("contactNicName");
        System.out.println(contactEmail);
        Contact contact = (Contact) session.getAttribute("contact");
        contact.setContactId((Integer) session.getAttribute("contactId"));
        System.out.println(contact.getContactEmail());
        contact.setContactName(contactName);
        contact.setContactNicName(contactNicName);
        contact.setContactEmail(contactEmail);
        try {
            contactDAO.updateContact(contact);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        response.sendRedirect("savecontactservlet");

    }
}
