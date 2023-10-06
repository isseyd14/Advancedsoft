package uts.bank.Controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import uts.bank.model.Card;
import uts.bank.model.DAO.CardDAO;

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

    public void edit(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            HttpSession session = request.getSession();
            String cardNumber = request.getParameter("cardNumber");
            session.setAttribute("cardNumber", cardNumber);
            System.out.println(cardNumber);
            request.getRequestDispatcher("../changepin.jsp").forward(request, response);

            
      

    }

    public void add(HttpServletRequest request, HttpServletResponse response)
                throws ServletException, IOException {
            HttpSession session = request.getSession();
            Validator validator = new Validator();
            validator.clear(session);
            String cardNumber = request.getParameter("cardNumber");
            String cardHolder = request.getParameter("cardHolder");
            String expiryDate = request.getParameter("expiryDate");
            String cvv = request.getParameter("cvv");
            String cardType = request.getParameter("cardType");
            Card newCard = new Card(cardNumber, cardHolder, expiryDate, cvv, cardType, "Active", "1001", "2001", 0, "1234");        
            Boolean isError = false;
            
            if(!validator.validateCardNo(cardNumber)){
                session.setAttribute("cardErr", "Error: Card Number format incorrect");
                isError = true;
            }
            if(!validator.validateName(cardHolder)){
                session.setAttribute("nameErr", "Error: Name format incorrect");
                isError = true;
            }
            if(!validator.validateExp(expiryDate)){
                session.setAttribute("expErr", "Error: Expiry Date format incorrect");
                isError = true;
            }
            if(!validator.validateCVV(cvv)){
                session.setAttribute("cvvErr", "Error: CVV format incorrect");
                isError = true;
            }
            if(!isError){
                try {
                    cardDAO.addCard(newCard);
                    response.sendRedirect("selectAll");
                } catch (SQLException e) {
                    
                    e.printStackTrace();
                }
            }else{
                request.getRequestDispatcher("addCard.jsp").include(request, response);
            }
        
    
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

    public void activate (HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            HttpSession session = request.getSession();
            String cardNumber = request.getParameter("cardNumber");
            session.setAttribute("cardNumber", cardNumber);
         
            try{
            cardDAO.activateCard(cardNumber);
            

            response.sendRedirect("selectAll");
            
    
            }catch (SQLException | NullPointerException ex) {
            ex.printStackTrace();
        
            }
        }

    public void deactivate (HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            HttpSession session = request.getSession();
            String cardNumber = request.getParameter("cardNumber");
            session.setAttribute("cardNumber", cardNumber);
         
            try{
            cardDAO.deactivateCard(cardNumber);
            

            response.sendRedirect("selectAll");
            
    
            }catch (SQLException | NullPointerException ex) {
            ex.printStackTrace();
        
            }
        }

    public void changePin (HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            HttpSession session = request.getSession();
            String cardNumber = request.getParameter("cardNumber");
            String pin = request.getParameter("pin");
            session.setAttribute("cardNumber", cardNumber);
            session.setAttribute("pin", pin);
         
            try{
            cardDAO.changePin(cardNumber, pin);
            

            response.sendRedirect("../selectAll");
            
    
            }catch (SQLException | NullPointerException ex) {
            ex.printStackTrace();
        
            }
        }

}



