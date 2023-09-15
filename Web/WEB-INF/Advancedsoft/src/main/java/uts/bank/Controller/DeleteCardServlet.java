package uts.bank.Controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import uts.bank.Model.DAO.CardDAO;

@WebServlet("/DeleteCardServlet")
public class DeleteCardServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private CardDAO cardDAO;

    public DeleteCardServlet() {
        this.cardDAO = new CardDAO();
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        this.doGet(request, response);
        }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    
                HttpSession session = request.getSession();
                String cardNumber = request.getParameter("cardNumber");
                session.setAttribute("cardNumber", cardNumber);
             
                try{
                cardDAO.deleteCard(cardNumber);
                

                request.getRequestDispatcher("CardServlet").include(request, response);
                
        
                }catch (SQLException | NullPointerException ex) {
                Logger.getLogger(DeleteCardServlet.class.getName()).log(Level.SEVERE, null, ex);
            
                }   
            
              
            
    }
}

