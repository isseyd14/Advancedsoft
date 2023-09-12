package uts.bank.Controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import uts.bank.model.Card;
import uts.bank.model.DAO.CardDAO;

@WebServlet("/")
public class CardServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private CardDAO cardDAO;

    public CardServlet() {
        this.cardDAO = new CardDAO();
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        this.doGet(request, response);
        }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
            String action = request.getServletPath();
        
            switch(action){
                case "/new":
                    showNewForm(request, response);
                    break;

                case "/add":
                    try {
                        addCard(request, response);
                    } catch (SQLException e) {

                        e.printStackTrace();
                    }
                    break;
                default:
                    try {
                        listCard(request, response);
                    } catch (SQLException e) {

                        e.printStackTrace();
                    }
                    break;
            }
         
        
        }

        private void showNewForm(HttpServletRequest request, HttpServletResponse response) 
                throws ServletException, IOException {
            request.getRequestDispatcher("addCard.jsp").forward(request, response);
        }

        private void addCard(HttpServletRequest request, HttpServletResponse response) 
                throws ServletException, IOException, SQLException {
        String cardNumber = request.getParameter("cardNumber");
        String cardHolder = request.getParameter("cardHolder");
        String expiryDate = request.getParameter("expiryDate");
        String cvv = request.getParameter("cvv");
        String cardType = request.getParameter("cardType");
        
        Card newCard = new Card(cardNumber, cardHolder, expiryDate, cvv, cardType, "Active", "1001", "2001", 0, "1234");        
        cardDAO.addCard(newCard);
        response.sendRedirect("list");   
    
        }

        private void listCard(HttpServletRequest request, HttpServletResponse response) 
                throws ServletException, IOException, SQLException {
          
            List<Card> listCard = cardDAO.findAllCards();
            request.setAttribute("listCard", listCard);
            RequestDispatcher dispatcher = request.getRequestDispatcher("cardList.jsp");
            dispatcher.forward(request, response);
        }



}



