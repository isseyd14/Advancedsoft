package uts.bank.Controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import uts.bank.Model.Card;
import uts.bank.Model.DAO.CardDAO;

@WebServlet("/card/*")
public class CardServlet extends BaseServlet {

    private CardDAO cardDAO;

    public CardServlet() {
        this.cardDAO = new CardDAO();
    }
    
    public void selectAll(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            
            HttpSession session = request.getSession();
            List<Card> listCard = cardDAO.findAllCards();
            session.setAttribute("listCard", listCard);
            if(listCard !=null){
            
            response.sendRedirect("../card.jsp");
            
      }

    }

    public void add(HttpServletRequest request, HttpServletResponse response)
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
            response.sendRedirect("selectAll");   
    
        }

    public void delete(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            HttpSession session = request.getSession();
            String cardNumber = request.getParameter("cardNumber");
            session.setAttribute("cardNumber", cardNumber);
         
            try{
            cardDAO.deleteCard(cardNumber);
            

            response.sendRedirect("selectAll");
            
    
            }catch (SQLException | NullPointerException ex) {
            ex.printStackTrace();
        
            }
        }

}



