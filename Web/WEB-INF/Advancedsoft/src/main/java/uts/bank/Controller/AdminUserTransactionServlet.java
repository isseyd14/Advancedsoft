package uts.bank.Controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import uts.bank.model.DAO.AdminDAO;
import uts.bank.model.DAO.TransactionDAO;
import uts.bank.model.Transaction;
import uts.bank.model.User;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/AdminUserTransactionServlet")
public class AdminUserTransactionServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        User user = (User) session.getAttribute("user");

        AdminDAO adminDAO = new AdminDAO();
        ArrayList<Transaction> transactions = null;

        try {
            transactions = adminDAO.getTransactionsByEmail(user.getEmail());
        } catch (SQLException | NullPointerException ex) {
            request.setAttribute("errorMessage", "Cannot find any transaction");
            RequestDispatcher rd = request.getRequestDispatcher("/admin-UserTransactions.jsp");
            rd.forward(request, response);
            return;
        }

        request.setAttribute("transactions", transactions);
        request.getRequestDispatcher("/admin-UserTransactions.jsp").forward(request, response);
    }
}
