package uts.bank.Controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import uts.bank.DAO.AdminDAO;
import uts.bank.model.Account;
import uts.bank.model.User;

import java.io.IOException;
import java.io.Writer;
import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet("/AdminAccountDeleteServlet")
public class AdminAccountDeleteServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) {

        HttpSession session = request.getSession();

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int accountNumber = Integer.parseInt(request.getParameter("accountNumber"));

        // Call the DAO to delete the account
        AdminDAO adminDAO = new AdminDAO();
        try {
            adminDAO.deleteAccount(accountNumber);

            // Retrieve the search parameter from the session
            String searchEmail = (String) request.getSession().getAttribute("search");

            // Retrieve the user and accounts data
            User user = adminDAO.findUser(searchEmail);
            ArrayList<Account> accounts = adminDAO.findAccounts(searchEmail);

            // Set user and accounts data as attributes in the request
            request.setAttribute("user", user);
            request.setAttribute("accounts", accounts);

            // Forward the request to admin-ViewAccount.jsp
            RequestDispatcher dispatcher = request.getRequestDispatcher("/admin-ViewAccount.jsp");
            dispatcher.forward(request, response);
        } catch (SQLException e) {
            // Handle any exceptions
            e.printStackTrace();
            // You might want to show an error message or redirect to an error page
            response.sendRedirect("error.jsp");
            return;
        }
    }
}



//    String action = request.getParameter("action");
//    AdminDAO adminDAO = new AdminDAO();
//
//        if (action.equals("delete")) {
//                int accountNumber = Integer.parseInt(request.getParameter("accountNumber"));
//                try {
//                adminDAO.deleteAccount(accountNumber);
//
//                } catch (SQLException e) {
//                throw new RuntimeException(e);
//                }
//                }
