package uts.bank.Controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import uts.bank.model.Account;
import uts.bank.DAO.AccountDAO;
import java.io.IOException;
import java.util.List;


@WebServlet("/viewbalanceservlet")
public class viewbalanceservlet extends HttpServlet {
    private AccountDAO accountDAO;
    public viewbalanceservlet() {
        this.accountDAO = new AccountDAO();
    }
//    protected void doPost(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        //this.doGet(request, response);
//    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String email = (String) session.getAttribute("email");
        List<Account> listAccount = accountDAO.findaccounts(email);
        session.setAttribute("listaccount", listAccount);
        RequestDispatcher dispatcher = request.getRequestDispatcher("View-Balance.jsp");
        dispatcher.forward(request, response);
    }
}


