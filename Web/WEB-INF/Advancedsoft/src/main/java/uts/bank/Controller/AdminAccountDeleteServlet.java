package uts.bank.Controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import uts.bank.model.DAO.AdminDAO;
import uts.bank.model.Account;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet("/AdminAccountDeleteServlet")
public class AdminAccountDeleteServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        HttpSession session = request.getSession();

        String action = request.getParameter("action");
        int accountNumber = Integer.parseInt(request.getParameter("accountNumber"));
        // Call the DAO to delete the account
        AdminDAO adminDAO = new AdminDAO();
        ArrayList<Account> accounts;
        String email = "";

            if (action.equals("delete")) {
                try {
                    email = adminDAO.getEmailbyAccount(accountNumber);
                    adminDAO.deleteAccount(accountNumber);

                    accounts = adminDAO.findAccounts(email);
                    request.setAttribute("accounts", accounts);
                    request.getRequestDispatcher("/admin-ViewAccount.jsp").forward(request, response);
                } catch (SQLException e) {
                    // Handle any exceptions
                    e.printStackTrace();
                    // You might want to show an error message or redirect to an error page
                    response.sendRedirect("error.jsp");
                    return;
                }

            } else if (action.equals("edit")) {
                try {
                    Account account = adminDAO.getAccount(accountNumber);
                    session.setAttribute("account", account);
                    request.getRequestDispatcher("/admin-EditAccount.jsp").forward(request, response);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }



            } else {
                response.sendRedirect("error.jsp");
            }
    }
}