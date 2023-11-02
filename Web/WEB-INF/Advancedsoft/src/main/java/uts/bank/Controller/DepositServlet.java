package uts.bank.Controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import uts.bank.model.Account;
import uts.bank.model.DAO.AdminDAO;
import uts.bank.model.DAO.TransactionDAO;
import uts.bank.model.Transaction;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet("/DepositServlet")
public class DepositServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        int accountNumber = Integer.parseInt(request.getParameter("accounts"));
        double amount = Double.parseDouble(request.getParameter("deposit"));

        Account account = null;
        double updatedFunds = 0.0;
        ArrayList<Account> accounts;
        AdminDAO adminDAO = new AdminDAO();

        TransactionDAO transactionDAO = new TransactionDAO();
        Transaction transaction = null;
        try {
            account = adminDAO.getAccount(accountNumber);
            updatedFunds = account.getAccountCurrentFunds() + amount;
            adminDAO.deposit(accountNumber, updatedFunds);

            transaction = new Transaction(transactionDAO.getNexttransactionId(), amount, account.getAccountEmail(), account.getAccountEmail(), accountNumber, accountNumber);
            adminDAO.newTransaction(transaction);

            accounts = adminDAO.findAccounts(account.getAccountEmail());
            session.setAttribute("accounts", accounts);
            request.getRequestDispatcher("/admin-ViewAccount.jsp").forward(request, response);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
