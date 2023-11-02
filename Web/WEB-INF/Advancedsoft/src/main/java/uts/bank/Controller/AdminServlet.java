package uts.bank.Controller;

import jakarta.servlet.RequestDispatcher;
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
import uts.bank.model.DAO.AdminDAO;
import uts.bank.model.User;
import uts.bank.model.Account;

@WebServlet("/AdminServlet")
public class AdminServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String searchEmail = request.getParameter("search");
        session.setAttribute("search", searchEmail);

        User user = null;
        ArrayList<Account> accounts;
        AdminDAO adminDAO = new AdminDAO();

        try {
            user = adminDAO.findUser(searchEmail);
            accounts = adminDAO.findAccounts(searchEmail);

            if (user != null) {
                session.setAttribute("user", user);
                session.setAttribute("accounts", accounts);
                request.getRequestDispatcher("/admin-ViewAccount.jsp").forward(request, response);
                request.getRequestDispatcher("/admin-EditAccount.jsp").forward(request, response);
                request.getRequestDispatcher("/UserDetails.jsp").forward(request, response);
            } else {
                request.setAttribute("errorMessage", "Cannot find User with that Email");
                RequestDispatcher rd = request.getRequestDispatcher("/admin.jsp");
                rd.forward(request, response);
                return;
            }
        } catch (SQLException ex) {
            Logger.getLogger(AdminServlet.class.getName()).log(Level.SEVERE, null, ex);
            request.setAttribute("errorMessage", "User does not Exist");
            RequestDispatcher rd = request.getRequestDispatcher("/admin.jsp");
            rd.forward(request, response);
            return;
        }

    }
}