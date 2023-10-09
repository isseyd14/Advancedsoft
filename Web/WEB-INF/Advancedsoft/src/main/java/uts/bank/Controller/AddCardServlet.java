package uts.bank.Controller;

import java.io.IOException;
import java.sql.SQLException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import uts.bank.model.Card;
import uts.bank.model.DAO.CardDAO;

@WebServlet("/AddCardServlet")
public class AddCardServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private CardDAO cardDAO;

    public AddCardServlet() {
        this.cardDAO = new CardDAO();
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        this.doGet(request, response);
        }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    
        
        String cardNumber = request.getParameter("cardNumber");
        String cardHolder = request.getParameter("cardHolder");
        String expiryDate = request.getParameter("expiryDate");
        String cvv = request.getParameter("cvv");
        String cardType = request.getParameter("cardType");
        
        Card newCard = new Card(cardNumber, cardHolder, expiryDate, cvv, cardType, "Active", "1001", "2001", 0, "1234");        
        try {
            cardDAO.addCard(newCard);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        response.sendRedirect("CardServlet");   
    
        }
    




}



