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

import java.io.IOException;

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
        // gets details from form to send money to different account
        int contactId = Integer.parseInt(request.getParameter("ContactName"));
        int accountId = Integer.parseInt(request.getParameter("AccountName"));
        int amonut = Integer.parseInt(request.getParameter("Amount"));

        //creates contact and account objects
        Contact contact = contactDAO.findOneContact(contactId);
        Account account = accountDAO.findOneAccount(accountId);
        //create the transaction in the database
        transactionDAO.addTransaction(contact, account, amonut);
        // take the money from the account
        accountDAO.updateAccountBalance(account,amonut);
        //send back to the main account page
        RequestDispatcher dispatcher = request.getRequestDispatcher("viewbalanceservlet");
        dispatcher.forward(request, response);
    }
}
