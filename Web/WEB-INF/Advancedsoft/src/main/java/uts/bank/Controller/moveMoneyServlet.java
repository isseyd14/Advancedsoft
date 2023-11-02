package uts.bank.Controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import uts.bank.model.Account;
import uts.bank.model.Contact;
import uts.bank.model.DAO.AccountDAO;
import uts.bank.model.DAO.ContactDAO;
import uts.bank.model.DAO.TransactionDAO;
import uts.bank.model.Transaction;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/moveMoneyServlet")
public class moveMoneyServlet extends HttpServlet {
    private ContactDAO contactDAO;
    private AccountDAO accountDAO;
    private TransactionDAO transactionDAO;


    //constructor
    public moveMoneyServlet(){
        this.contactDAO = new ContactDAO();
        this.accountDAO = new AccountDAO();
        this.transactionDAO = new TransactionDAO();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //Handles if this servlet is handeled in a dopost fashion - sends streight to the do get method
        this.doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Transaction transaction;
        // gets details from form to send money to different account
        int contactId = Integer.parseInt(request.getParameter("ContactName"));
        int accountId = Integer.parseInt(request.getParameter("AccountName"));
        String amountStr = request.getParameter("Amount");


        // Try to parse the amount as a valid double
        try {
            int amount = Integer.parseInt(amountStr);

            //creates contact and account objects
            Contact contact = contactDAO.findOneContact(contactId);
            Account account = accountDAO.findOneAccount(accountId);
            try {
                transaction = new Transaction(transactionDAO.getNexttransactionId(), amount, account.getAccountEmail(), contact.getContactEmail(), account.getAccountNumber());
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            //create the transaction in the database
            try {
                transactionDAO.addTransaction(transaction);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

            Account payeeAccount = accountDAO.findOneAccount(contact.getAccountNumber() );
            // take the money from the account
            accountDAO.takeAccountBalance(account,amount);
            if(payeeAccount != null){
                accountDAO.giveAccountBalance(payeeAccount, amount);
            }
            //send back to the main account page
            RequestDispatcher dispatcher = request.getRequestDispatcher("viewbalanceservlet");
            dispatcher.forward(request, response);


        } catch (NumberFormatException e) {
            // Handle the case where parsing as a double fails
            response.sendRedirect("Pay-Transfer.jsp?error=invalid-amount");
        }

    }
}
