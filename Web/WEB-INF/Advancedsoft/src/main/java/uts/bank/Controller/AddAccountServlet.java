package uts.bank.Controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import uts.bank.model.Account;
import uts.bank.model.DAO.AccountDAO;

import java.io.IOException;
import java.sql.SQLException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/AddAccountServlet")
public class AddAccountServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private AccountDAO accountDAO;

    public AddAccountServlet() {
        this.accountDAO = new AccountDAO();
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        this.doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String email = (String) session.getAttribute("email");
        String accountName = request.getParameter("AccountName");
        String accountType = request.getParameter("AccountType");
        double availableFunds = Double.parseDouble(request.getParameter("AvailableFunds"));
        double currentFunds = Double.parseDouble(request.getParameter("CurrentFunds"));
        Account newAccount = new Account(email,accountName, accountType, availableFunds, currentFunds);
        try {
            accountDAO.addAccount(newAccount);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        response.sendRedirect("viewbalanceservlet");

    }





}



