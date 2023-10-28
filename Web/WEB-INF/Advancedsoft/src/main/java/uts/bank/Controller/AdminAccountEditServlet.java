package uts.bank.Controller;

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

        Account account;
        ArrayList<Account> accounts;
        AdminDAO adminDAO = new AdminDAO();

        if (action.equals("Submit")) {
            try {
                if (!accountName.isEmpty() && !availableFunds.isEmpty()) {
                    adminDAO.updateAccount(accountNumber, accountName, Double.parseDouble(availableFunds));

                } else if (accountName.isEmpty() && !availableFunds.isEmpty()) {
                    accountName = adminDAO.getAccount(accountNumber).getAccountName();
                    adminDAO.updateAccount(accountNumber, accountName, Double.parseDouble(availableFunds));

                } else if (!accountName.isEmpty()){
                    double availableFunds1 = adminDAO.getAccount(accountNumber).getAccountAvailableFunds();
                    adminDAO.updateAccount(accountNumber, accountName, availableFunds1);
                } else {
                    accountName = adminDAO.getAccount(accountNumber).getAccountName();
                    double availableFunds1 = adminDAO.getAccount(accountNumber).getAccountAvailableFunds();
                    adminDAO.updateAccount(accountNumber, accountName, availableFunds1);


                }

                account = adminDAO.getAccount(accountNumber);
                request.setAttribute("account", account);
                accounts = adminDAO.findAccounts(adminDAO.getEmailbyAccount(accountNumber));
                request.setAttribute("accounts", accounts);
                request.getRequestDispatcher("/admin-ViewAccount.jsp").forward(request, response);

            } catch (SQLException e) {

            }
        }
    }
}
