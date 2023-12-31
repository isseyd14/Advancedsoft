package uts.bank.Controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import java.util.logging.Level;
import java.util.logging.Logger;
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

    //select card by customer ID
    public void selectByCustomerId(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            HttpSession session = request.getSession();
            Validator validator = new Validator();
            validator.clear(session);
            String customerId = (String)session.getAttribute("email");
            List<Card> listCard = cardDAO.findCardByCustomerId(customerId);
            session.setAttribute("listCard", listCard);
            
            
            response.sendRedirect("../card.jsp");
            
      

    }

    public void edit(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            HttpSession session = request.getSession();
            String cardNumber = request.getParameter("cardNumber");
            session.setAttribute("cardNumber", cardNumber);
            System.out.println(cardNumber);
            request.getRequestDispatcher("../changepin.jsp").forward(request, response);

    }
    // public void newCard(HttpServletRequest request, HttpServletResponse response)
    //         throws ServletException, IOException {
    //         request.getRequestDispatcher("addCard.jsp").forward(request, response);

    // }

    public void add(HttpServletRequest request, HttpServletResponse response)
                throws ServletException, IOException {
            HttpSession session = request.getSession();
            Validator validator = new Validator();
            validator.clear(session);
            String customerId = (String)session.getAttribute("email");
            String cardNumber = request.getParameter("cardNumber");
            String cardHolder = request.getParameter("cardHolder");
            String expiryDate = request.getParameter("expiryDate");
            String cvv = request.getParameter("cvv");
            String cardType = request.getParameter("cardType");
            Card newCard = new Card(cardNumber, cardHolder, expiryDate, cvv, cardType, "Active", customerId, "2001", 0, "1234");        
           
           
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
                if(cardDAO.findCard(cardNumber) != null){
                    session.setAttribute("cardErr", "Error: Card Number already exists");
                    response.sendRedirect("../addCard.jsp");
                }else{
                try {
                    cardDAO.addCard(newCard);
                    response.sendRedirect("selectByCustomerId");
                } catch (SQLException | NullPointerException ex) {
                    Logger.getLogger(CardServlet.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                    
                }
            }else{
                
                response.sendRedirect("../addCard.jsp");
            }
        
    
    }

    public void delete(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            HttpSession session = request.getSession();
            String cardNumber = request.getParameter("cardNumber");
            session.setAttribute("cardNumber", cardNumber);
         
            try{
            cardDAO.deleteCard(cardNumber);
            

            response.sendRedirect("selectByCustomerId");
            
    
            }catch (SQLException | NullPointerException ex) {
            ex.printStackTrace();
        
            }
        }

    public void activate (HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            HttpSession session = request.getSession();
            String cardNumber = request.getParameter("cardNumber");
            System.out.println(cardNumber);
            session.setAttribute("cardNumber", cardNumber);
         
            try{
            cardDAO.activateCard(cardNumber);
            

            response.sendRedirect("selectByCustomerId");
            
    
            }catch (SQLException | NullPointerException ex) {
            ex.printStackTrace();
        
            }
        }

    public void deactivate (HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            HttpSession session = request.getSession();
            String cardNumber = request.getParameter("cardNumber");
            System.out.println(cardNumber);
            session.setAttribute("cardNumber", cardNumber);
         
            try{
            cardDAO.deactivateCard(cardNumber);
            

            response.sendRedirect("selectByCustomerId");
            
    
            }catch (SQLException | NullPointerException ex) {
            ex.printStackTrace();
        
            }
        }

    public void changePin (HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            HttpSession session = request.getSession();
            String cardNumber = request.getParameter("cardNumber");
            System.out.println(cardNumber);
            String pin = request.getParameter("pin");
            session.setAttribute("cardNumber", cardNumber);
            session.setAttribute("pin", pin);
         
            try{
            cardDAO.changePin(cardNumber, pin);
            

            response.sendRedirect("../selectByCustomerId");
            
    
            }catch (SQLException | NullPointerException ex) {
            ex.printStackTrace();
        
            }
        }

}



