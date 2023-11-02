package uts.bank.Controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import uts.bank.model.Account;
import uts.bank.model.DAO.AdminDAO;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet("/AdminAccountEditServlet")
public class AdminAccountEditServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        HttpSession session = request.getSession();

        String action = request.getParameter("action");
        int accountNumber = Integer.parseInt(request.getParameter("accountNumber"));
        String accountName = request.getParameter("accountName");
        String availableFunds = request.getParameter("availableFunds");

        Account account = null;
        ArrayList<Account> accounts = null;
        AdminDAO adminDAO = new AdminDAO();

        if (action.equals("submit")) {
            try {
                account = adminDAO.getAccount(accountNumber);
                if (Double.parseDouble(availableFunds) <= account.getAccountCurrentFunds()) {
                    adminDAO.updateAccount(accountNumber, accountName, Double.parseDouble(availableFunds));
                } else {
                    request.setAttribute("errorMessage", "Not Enough Funds");
                    RequestDispatcher rd = request.getRequestDispatcher("/admin-EditAccount.jsp");
                    rd.forward(request, response);
                    return;

                }

                accounts = adminDAO.findAccounts(adminDAO.getEmailbyAccount(accountNumber));

            } catch (SQLException e) {
                System.out.println("One or more elements could not be updated");
            }
        }

        if (account != null) {
            account.setAccountName(accountName);
            account.setAccountAvailableFunds(Double.parseDouble(availableFunds));
        }

        request.getSession().setAttribute("accounts", accounts);
        request.getRequestDispatcher("/admin-ViewAccount.jsp").forward(request, response);
    }
}
