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

@WebServlet("/WithdrawServlet")
public class WithdrawServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        int accountNumber = Integer.parseInt(request.getParameter("accounts"));
        double amount = Double.parseDouble(request.getParameter("withdraw"));

        Account account;
        double updatedFunds;
        ArrayList<Account> accounts;
        AdminDAO adminDAO = new AdminDAO();
        TransactionDAO transactionDAO = new TransactionDAO();
        Transaction transaction = null;
        try {
            account = adminDAO.getAccount(accountNumber);
            if (amount <= account.getAccountCurrentFunds()) {
                updatedFunds = account.getAccountCurrentFunds() - amount;
                adminDAO.withdraw(accountNumber, updatedFunds);

                transaction = new Transaction(transactionDAO.getNexttransactionId(), amount, account.getAccountEmail(), "staff@gmail.com", accountNumber, 0);
                adminDAO.newTransaction(transaction);

                accounts = adminDAO.findAccounts(account.getAccountEmail());
                session.setAttribute("accounts", accounts);
                request.getRequestDispatcher("/admin-ViewAccount.jsp").forward(request, response);
            } else {
                System.out.println("Cannot withdraw more than balance");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
