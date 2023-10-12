package uts.bank.Controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import jakarta.servlet.http.HttpSession;
import uts.bank.DAO.AdminDAO;
import uts.bank.model.User;
import uts.bank.model.Account;

@WebServlet("/AdminServlet")
public class AdminServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve the search parameter from the request
        HttpSession session = request.getSession();
        String searchEmail = request.getParameter("search");
        session.setAttribute("search", searchEmail);

        User user = null;
        ArrayList<Account> accounts;
        AdminDAO adminDAO = new AdminDAO();

        try {
            user = adminDAO.findUser(searchEmail);
            accounts = adminDAO.findAccounts(searchEmail);
            session.setAttribute("user", user);
            session.setAttribute("accounts", accounts);
            request.getRequestDispatcher("/admin-ViewAccount.jsp").forward(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(AdminServlet.class.getName()).log(Level.SEVERE, null, ex);

        }

    }
}