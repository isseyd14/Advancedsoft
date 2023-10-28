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

    //constructor
    public savecontactservlet() {this.contactDAO = new ContactDAO();}

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //gets the current session
        HttpSession session = request.getSession();
        //creates a list of all current contacts attached to the current user
        String email = (String) session.getAttribute("email");
        List<Contact> listContacts = contactDAO.findContacts(email);
        session.setAttribute("listcontacts", listContacts);
        // sends to the main contact page
        RequestDispatcher dispatcher = request.getRequestDispatcher("Save-Contact.jsp");
        dispatcher.forward(request, response);
    }
}


