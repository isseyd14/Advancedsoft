package uts.bank.Controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import uts.bank.model.Contact;
import uts.bank.DAO.ContactDAO;

import java.io.IOException;
import java.sql.SQLException;

import jakarta.servlet.http.HttpSession;

@WebServlet("/AddContactServlet")
public class AddContactServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private ContactDAO contactDAO;

    public AddContactServlet() {
        this.contactDAO = new ContactDAO();
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        this.doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String email = (String) session.getAttribute("email");
        String contactName = request.getParameter("ContactName");
        String contactNicName = request.getParameter("ContactNicName");
        String contactEmail = request.getParameter("ContactEmail");

        Contact newContact = new Contact(email, contactName, contactNicName, contactEmail);
        try {
            contactDAO.addContact(newContact);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        response.sendRedirect("savecontactservlet");

    }





}



