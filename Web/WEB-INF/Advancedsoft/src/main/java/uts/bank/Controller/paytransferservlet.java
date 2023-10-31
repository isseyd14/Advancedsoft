package uts.bank.Controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import uts.bank.model.Account;
import uts.bank.model.Contact;
import uts.bank.model.DAO.AccountDAO;
import uts.bank.model.DAO.ContactDAO;

import java.io.IOException;
import java.sql.*;
import java.util.List;


@WebServlet("/paytransferservlet")
public class paytransferservlet extends HttpServlet {
    private ContactDAO contactDAO;
    private AccountDAO accountDAO;

    //constructor
    public paytransferservlet() {
        // creates contact and account classes
        this.contactDAO = new ContactDAO();
        this.accountDAO = new AccountDAO();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // gets current session
        HttpSession session = request.getSession();
        // creates lists of contacts and accounts that are linked to this current users
        String email = (String) session.getAttribute("email");
        List<Contact> listContacts = contactDAO.findContacts(email);
        session.setAttribute("listcontacts", listContacts);
        List<Account> listAccount = accountDAO.findaccounts(email);
        session.setAttribute("listaccount", listAccount);
        // sends the user to the pay transfer page
        RequestDispatcher dispatcher = request.getRequestDispatcher("Pay-Transfer.jsp");
        dispatcher.forward(request, response);
    }
}


