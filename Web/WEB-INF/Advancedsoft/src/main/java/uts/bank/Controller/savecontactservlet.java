package uts.bank.Controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import uts.bank.model.Contact;
import uts.bank.model.DAO.ContactDAO;

import java.io.IOException;
import java.util.List;


@WebServlet("/savecontactservlet")
public class savecontactservlet extends HttpServlet {

    private ContactDAO contactDAO;

    public savecontactservlet() {this.contactDAO = new ContactDAO();}

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String email = (String) session.getAttribute("email");
        List<Contact> listContacts = contactDAO.findContacts(email);
        session.setAttribute("listcontacts", listContacts);
        RequestDispatcher dispatcher = request.getRequestDispatcher("Save-Contact.jsp");
        dispatcher.forward(request, response);
    }
}


