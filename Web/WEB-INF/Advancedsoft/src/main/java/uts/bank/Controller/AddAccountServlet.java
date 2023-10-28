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

import jakarta.servlet.http.HttpSession;

@WebServlet("/AddAccountServlet")
public class AddAccountServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private AccountDAO accountDAO;

    //constructor
    public AddAccountServlet() {
        this.accountDAO = new AccountDAO();
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //Handles if this servlet is handeled in a dopost fashion - sends streight to the do get method
        this.doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // gets the current session
        HttpSession session = request.getSession();
        // gets the next free account number from the database
        int accountNumber = 0;
                try {
                    accountNumber = accountDAO.getNextAccountId();
                } catch (SQLException ex) {

                }
        // getting all the elements from the form, and putting them into an account object
        String email = (String) session.getAttribute("email");
        String accountName = request.getParameter("AccountName");
        String accountType = request.getParameter("AccountType");
        double availableFunds = Double.parseDouble(request.getParameter("AvailableFunds"));
        double currentFunds = Double.parseDouble(request.getParameter("CurrentFunds"));
        Account newAccount = new Account(accountNumber, email,accountName, accountType, availableFunds, currentFunds);
        // putting the new account object into the database
        try {
            accountDAO.addAccount(newAccount);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        // sending the user back to the home page
        response.sendRedirect("viewbalanceservlet");

    }





}



