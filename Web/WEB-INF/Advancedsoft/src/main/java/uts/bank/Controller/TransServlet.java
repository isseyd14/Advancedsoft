package uts.bank.Controller;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import uts.bank.model.Transaction;
import uts.bank.model.DAO.TransDAO;

@WebServlet("/trans/*")
public class TransServlet extends BaseServlet{

    private TransDAO transDAO;

    public TransServlet() {
        this.transDAO = new TransDAO();
    }
    public void add(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        System.out.println("trans/add");
    }
    public void selectAll(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        HttpSession session = request.getSession();
        List<Transaction> listTrans = transDAO.findAllTransactions();
        session.setAttribute("listTrans", listTrans);
        if(listTrans !=null){
            response.sendRedirect("../transaction.jsp");
        }
    }
    // select transaction by account number
    public void selectByAccountId(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            HttpSession session = request.getSession();
            String accountId = request.getParameter("accountNumber");
            System.out.println(accountId);
            session.setAttribute("accountId", accountId);
          
            
            
            List<Transaction> listTrans = transDAO.findTransByAccountId(accountId);
            session.setAttribute("listTrans", listTrans);
            
            
            response.sendRedirect("../transaction.jsp");
            
      

    }
    public void selectByKeyword(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            HttpSession session = request.getSession();
            String keyword = request.getParameter("keyword");
            System.out.println(keyword);
            String accountId = (String) session.getAttribute("accountId");
            session.setAttribute("keyword", keyword);
          
            
            
            List<Transaction> listTrans = transDAO.findTransByKeyword(accountId,keyword);
            session.setAttribute("listTrans", listTrans);
            
            
            response.sendRedirect("../transaction.jsp");
            
      

    }

    
}
